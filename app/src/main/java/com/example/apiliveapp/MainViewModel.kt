package com.example.apiliveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiliveapp.data.Repository
import com.example.apiliveapp.data.model.Fact
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    val repository = Repository()

    val facts = repository.facts


    fun loadFacts() {
        //_facts.value = DataSource.facts

        viewModelScope.launch {
            repository.loadData()
        }
    }

}