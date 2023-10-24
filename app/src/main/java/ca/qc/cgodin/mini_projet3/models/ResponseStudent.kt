package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName

data class ResponseStudent(
    @SerializedName("student")
    val student: Student,
    @SerializedName("statut")
    val statut: String
)