package com.juaracodinglima.tugasakhirfixx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracodinglima.tugasakhirfixx.adapter.AdapterListBasic;
import com.juaracodinglima.tugasakhirfixx.model.ListModel;
import com.juaracodinglima.tugasakhirfixx.service.APIClient;
import com.juaracodinglima.tugasakhirfixx.service.APIInterfacesRest;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    RecyclerView rvList;
    ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        progressBar = findViewById(R.id.progressBar);
        rvList = findViewById(R.id.rvList);

        //Collections.sort(yourList, Collections.reverseOrder()); -> descending
//        https://stackoverflow.com/questions/13120316/how-to-sort-date-in-descending-order-from-arraylist-date-in-android
//        https://abhiandroid.com/ui/listview



        callProduk();
    }
        APIInterfacesRest apiInterface;
        ProgressDialog progressDialog;

        public void callProduk(){

            progressDialog = new ProgressDialog(ListActivity.this);
            progressDialog.setTitle("Loading");
            progressDialog.show();

            apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
            progressBar.setVisibility(View.VISIBLE);

            Call<ListModel> call3 = apiInterface.getListModel();
            call3.enqueue(new Callback<ListModel>() {
                @Override
                public void onResponse(Call<ListModel> call, Response<ListModel> response) {
                    progressBar.setVisibility(View.GONE);
                    ListModel listModel = response.body();

                    if (listModel !=null) {
                        AdapterListBasic adapter = new AdapterListBasic(ListActivity.this,listModel.getResults());
                        adapter.setOnItemClickListener((AdapterListBasic.OnItemClickListener) ListActivity.this);
                        rvList.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                        rvList.setItemAnimator(new DefaultItemAnimator());
                        rvList.setAdapter(adapter);

                    }else{
                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());
                            Toast.makeText(ListActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(ListActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ListModel> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                    call.cancel();
                }
            });
        }

    @Override
    protected void onResume() {
        super.onResume();
        callProduk();
    }
    }