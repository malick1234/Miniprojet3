package ca.qc.cgodin.mini_projet3

import com.google.gson.annotations.SerializedName

data class Connexion(
    @SerializedName("Mat")
    val mat: String,
    @SerializedName("MDP")
    val mdp: String
)