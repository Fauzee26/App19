package fauzi.hilmy.app19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fauzi.hilmy.app19.Helper.Client;
import fauzi.hilmy.app19.Helper.Server;
import fauzi.hilmy.app19.Response.DataItem;
import fauzi.hilmy.app19.Response.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataItem> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        Client client = Server.getInstance();
        Call<ResponseData> call = client.response_read_data();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Boolean status = response.body().isSuccess();
                Log.d("Tag", "" + response.body().isSuccess());
                if (status) {
                    dataItems = response.body().getData();
                    AdapterDetail adapterDetail = new AdapterDetail(MainActivity.this, dataItems);
                    recyclerView.setAdapter(adapterDetail);

                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }
}
