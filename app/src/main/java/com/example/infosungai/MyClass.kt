package com.salesorder.json

data class Theater(
    val status: String
)

data class Result(
    val nama_sungai: String,
    val titik_pantau: String,
    val bujur_timur: Double,
    val lintang_selatan: Double,
    val indeks_pencemar: String,
    val kategori: String
)


