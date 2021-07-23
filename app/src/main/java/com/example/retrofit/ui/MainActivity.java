package com.example.retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.data.BoredApi;
import com.example.retrofit.data.RetrofitBuilder;
import com.example.retrofit.data.model.BoredApiModel;
import com.example.retrofit.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Spinner spinner = binding.spinerCategory;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    public void btnOnClick(View view) {

        RetrofitBuilder.creatRetrofit().getActivities().enqueue(new Callback<BoredApiModel>() {
            @Override
            public void onResponse(Call<BoredApiModel> call, Response<BoredApiModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("tag", "success " + response.body().getAvtivities());

                    binding.textActivity.setText(response.body().getAvtivities());

                } else {
                    Log.d("tag", "error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BoredApiModel> call, Throwable t) {
                Log.d("tag", "failure " + t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}