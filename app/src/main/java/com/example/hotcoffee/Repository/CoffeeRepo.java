package com.example.hotcoffee.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.hotcoffee.CoffeeModel;
import com.example.hotcoffee.Service.CoffeeService;
import com.example.hotcoffee.retro.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoffeeRepo {
    private final CoffeeService coffeeService;

    public CoffeeRepo() {
        coffeeService = RetroInstance.getRetrofit().create(CoffeeService.class);
    }

    public MutableLiveData<List<CoffeeModel>> getCoffee(){
        MutableLiveData<List<CoffeeModel>> coffeeData = new MutableLiveData<>();

        coffeeService.getCoffee().enqueue(new Callback<List<CoffeeModel>>() {
            @Override
            public void onResponse(Call<List<CoffeeModel>> call, Response<List<CoffeeModel>> response) {
                if (response.isSuccessful()) {
                    coffeeData.setValue(response.body());
                } else {
                    coffeeData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<CoffeeModel>> call, Throwable t) {
                coffeeData.setValue(null);
            }
        });
        return coffeeData;
    }
}
