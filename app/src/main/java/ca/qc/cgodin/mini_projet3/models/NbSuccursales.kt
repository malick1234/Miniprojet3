package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName

data class NbSuccursales(
    @SerializedName("statut")
    val statut: String,
    @SerializedName("nbSuccursales")
    val nbSuccursale: String
)
