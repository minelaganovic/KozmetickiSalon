package com.example.kozmetickisalon;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kozmetickisalon.R;
import com.example.kozmetickisalon.AppAdapter.appadapter;
import com.example.kozmetickisalon.model.KozmetickiProzivod;
import com.example.kozmetickisalon.model.User;
import com.example.kozmetickisalon.retrofit.RetrofitService;
import com.example.kozmetickisalon.api.appapi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;


public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private appadapter retrofitAdapter;
    private List<KozmetickiProzivod> kozmetickiList;
    private appapi kozApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize RetrofitService
        RetrofitService retrofitService = new RetrofitService();
        kozApi = retrofitService.getAllKProizvod();

        // Create a list of Kozmeticki items
        kozmetickiList = new ArrayList<>();

        // Initialize RetrofitAdapter with the list
        retrofitAdapter = new appadapter(kozmetickiList);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(retrofitAdapter);

        // Load data from the backend using Retrofit
        fetchDataFromBackend();
    }

    private void fetchDataFromBackend() {
        // Make the network request
        Call<List<KozmetickiProzivod>> call = kozApi.getAllKProizvod();
        call.enqueue(new Callback<List<KozmetickiProzivod>>() {
            @Override
            public void onResponse(Call<List<KozmetickiProzivod>> call, Response<List<KozmetickiProzivod>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Update the adapter with the received data
                    List<KozmetickiProzivod> newData = response.body();
                    retrofitAdapter.updateData(newData);
                } else {
                    // Handle unsuccessful response
                    // You can log an error message or show an error to the user
                }
            }

            @Override
            public void onFailure(Call<List<KozmetickiProzivod>> call, Throwable t) {
                // Handle network failure
                // You can log an error message or show an error to the user
            }
        });
    }
}