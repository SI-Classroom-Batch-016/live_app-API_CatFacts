package com.example.apiliveapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiliveapp.data.model.Fact

class Repository() {
    //Das Repository ist dafür verantwortlich die Daten in einem sinnvollen Format bereit zu stellen


    private val _facts = MutableLiveData<List<Fact>>()
    val facts: LiveData<List<Fact>>
        get() = _facts

    var currentPage = 30

    suspend fun loadData() {

        val factListResponse = CatFactApi.apiService.getFactList(currentPage)
        Log.d("CatFactAPI", factListResponse.toString())
        _facts.postValue(factListResponse.data)
        //_facts.value =   könnte in Coroutine Probleme verursachen

        if (currentPage < factListResponse.last_page) {
            currentPage++
        } else {
            currentPage = 1
        }

    }


}