package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName

data class Succursales(
    @SerializedName("_id")
    val id: String,
    @SerializedName("AccessMDP")
    val MDP: String,
    @SerializedName("Ville")
    val ville: String,
    @SerializedName("Budget")
    val Budget: Double,
    @SerializedName("__v")
    val v: String
)
