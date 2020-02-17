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
import androidx.core.view.NestedScrollingChild;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.ParcelUuid;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNews;
    private NewsAdapter newsAdapter;
    private ArrayList<News> newsList;
    private ProgressBar progressBar;

    String pakistaniNewsLink = "http://androidworkshop.net/apis/thenews/pakistani.php";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvNews = findViewById(R.id.rvNews);
        progressBar = findViewById(R.id.progressBar);
        fetchNewsDataFromServer();

    }

    private void fetchNewsDataFromServer() {
        progressBar.setVisibility(View.VISIBLE);
        StringRequest request = new StringRequest(pakistaniNewsLink, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                Log.i("mytag", response);

                try {
                    JSONArray newsArray = new JSONArray(response);
                    newsList = new ArrayList<>();

                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject newsObject = newsArray.getJSONObject(i);
                        String title = newsObject.getString("title");
                        String link = newsObject.getString("link");
                        String image = newsObject.getString("image");
                        String detail = newsObject.getString("detail");
                        String publishDate = newsObject.getString("publishDate");


                        News news = new News(title, link, detail, publishDate,image);
                        newsList.add(news);
                    }


                    rvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

                    rvNews.setAdapter(new NewsAdapter(newsList, new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "unable to process data", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                error.printStackTrace();
                Toast.makeText(MainActivity.this, "unable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(request);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
