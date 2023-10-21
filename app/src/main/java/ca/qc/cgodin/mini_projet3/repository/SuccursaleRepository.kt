package ca.qc.cgodin.mini_projet3.repository

import ca.qc.cgodin.mini_projet3.Connexion
import ca.qc.cgodin.mini_projet3.network.RetrofitInstance

class SuccursaleRepository() {
    suspend fun getConnexion(connexion: Connexion) =
        RetrofitInstance.retrofitService.getConnexion(connexion);
}
