package ca.qc.cgodin.roomstudent

import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleFavoris

interface AdapterCallback {
    fun sendSucc(succ: Succursale, code: String)
    fun sendSuccFav(succ: SuccursaleFavoris, code: String)
}
