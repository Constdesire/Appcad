package com.example.appsql.model

data class CourseModel(
    // on below line we are creating variables for name and job
    var Name: String,
    var Endereco: String,
    var bairro: String,
    var cep: Int,
    var cidade: String,
    var estado: String,
    var telefone: Int,
    var celular: Int,
)