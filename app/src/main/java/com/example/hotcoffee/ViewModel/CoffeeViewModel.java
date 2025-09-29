package com.example.hotcoffee.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hotcoffee.CoffeeModel;
import com.example.hotcoffee.Repository.CoffeeRepo;

import java.util.List;

public class CoffeeViewModel extends ViewModel {

    private final CoffeeRepo repo;
    private MutableLiveData<List<CoffeeModel>> coffees;

    public CoffeeViewModel() {
        repo = new CoffeeRepo();
        coffees = null;
    }

    public LiveData<List<CoffeeModel>> getCoffee(){
        if (coffees == null){
            coffees = repo.getCoffee();
        }
        return coffees;
    }
}
