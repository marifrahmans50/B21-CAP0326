package com.example.infosungai.data


import com.google.gson.annotations.SerializedName

data class MapValue(
        @SerializedName("results")
    var results: List<Result>,
)

data class Result(
@SerializedName("nama_sungai")
var nama_sungai: String,
@SerializedName("titik_pantau")
var titik_pantau: String,
@SerializedName("bujur_timur")
var bujur_timur: Double,
@SerializedName("lintang_selatan")
var lintang_selatan: Double,
@SerializedName("Indeks Pencemar")
var indeks_pencemar: String,
@SerializedName("kategori")
var kategori: String
)

