package com.example.infosungai.data

import com.google.gson.annotations.SerializedName

data class ClassifierData (
    @SerializedName("labels") val labels: String?,
    @SerializedName("accuracy") val accuracy: String?
)