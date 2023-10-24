package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Succursales(
    @SerializedName("_id")
    val id: String,
    @SerializedName("AccessMDP")
    val AccessMDP: String,
    @SerializedName("Ville")
    val ville: String,
    @SerializedName("Budget")
    val Budget: String,
    @SerializedName("__v")
    val v: String
): Serializable
