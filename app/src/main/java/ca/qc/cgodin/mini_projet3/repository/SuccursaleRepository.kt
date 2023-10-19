package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.network.RetrofitInstance

class SuccursaleRepository() {
    suspend fun getConnexion(mat: String, mdp: String) =
        RetrofitInstance.retrofitService.getConnexion(mat, mdp);
}
