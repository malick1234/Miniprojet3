package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName

data class ResponseSuccursales(
    @SerializedName("succursales")
    val succursales: List<Succursales>,
    @SerializedName("statut")
    val statut: String
)
