package ca.qc.cgodin.mini_projet3.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Student(
    @SerializedName("Matricule")
    val Matricule: String,
    @SerializedName("Nom")
    val Nom: String,
    @SerializedName("Prenom")
    val Prenom: String,
    @SerializedName("token")
    val token: String
) : Serializable
