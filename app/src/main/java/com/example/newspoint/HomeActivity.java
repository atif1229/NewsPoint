package com.example.newspoint;

import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvNews2;
    private News2Adapter news2Adapter;
    private ArrayList<News2> news2ArrayList;

    private String pakistaniNewsLink = "http://androidworkshop.net/apis/thenews/pakistani.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvNews2 = findViewById(R.id.rvNews2);
        fetchNewsDataFromServer();

    }

    private void fetchNewsDataFromServer() {

        StringRequest request = new StringRequest(pakistaniNewsLink, new Response.Listener<String>() {
            @Override

            public void onResponse(String response) {

                news2ArrayList = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String image = jsonObject.getString("image");
                        String link = jsonObject.getString("link");
                        String detail = jsonObject.getString("detail");
                        String publishDate = jsonObject.getString("publishDate");


                        News2 news2 = new News2(title, link, image, detail, publishDate);
                        news2ArrayList.add(news2);

                    }
                    rvNews2.setLayoutManager(new LinearLayoutManager(HomeActivity.this, RecyclerView.VERTICAL, false));
                    rvNews2.setAdapter(new News2Adapter(news2ArrayList, new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(HomeActivity.this, "unable to process data", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(HomeActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();

            }
        });


        Volley.newRequestQueue(getApplicationContext()).add(request);

    }

}


