package com.example.apiliveapp.data.model

data class FactListResponse (
    val data : List<Fact>,
    val last_page : Int,
    val current_page : Int,
)
