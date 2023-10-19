package ca.qc.cgodin.mini_projet3.data


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_succursale")
data class Succursale(
    @PrimaryKey(autoGenerate = false)
    val Ville: String,
    val Budget: Int
)
