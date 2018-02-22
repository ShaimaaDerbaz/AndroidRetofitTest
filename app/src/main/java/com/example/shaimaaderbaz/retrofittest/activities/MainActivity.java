package com.example.shaimaaderbaz.retrofittest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.shaimaaderbaz.retrofittest.R;
import com.example.shaimaaderbaz.retrofittest.adapters.EearthquakeAdapter;
import com.example.shaimaaderbaz.retrofittest.models.BaseResponseResult;
import com.example.shaimaaderbaz.retrofittest.models.FeaturesResults;
import com.example.shaimaaderbaz.retrofittest.models.PropertiesEarthquake;
import com.example.shaimaaderbaz.retrofittest.utils.SOService;
import com.example.shaimaaderbaz.retrofittest.utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EearthquakeAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;
    public void loadAnswers() {
        mService.getEarthquake().enqueue(new Callback<BaseResponseResult>() {
            @Override
            public void onResponse(Call<BaseResponseResult> call, Response<BaseResponseResult> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateEarthquake(response.body().getFeatures());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("MainActivity", statusCode+"");
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<BaseResponseResult> call, Throwable t) {
                //showErrorMessage();
                Log.d("MainActivity", "error loading from API");

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = Utils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mAdapter = new EearthquakeAdapter( new ArrayList<FeaturesResults>(0), new EearthquakeAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
      //  mRecyclerView.addItemDecoration(itemDecoration);

         loadAnswers();

        ////////////////////////////////

    }

}
