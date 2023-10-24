package ca.qc.cgodin.mini_projet3.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_succursale_favoris")
data class SuccursaleFavoris (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Ville: String,
    val Budget: Int
)
