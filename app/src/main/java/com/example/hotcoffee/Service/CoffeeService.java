package com.example.hotcoffee.Service;

import com.example.hotcoffee.CoffeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoffeeService {
    @GET("hot")
    Call<List<CoffeeModel>> getCoffee();
}
