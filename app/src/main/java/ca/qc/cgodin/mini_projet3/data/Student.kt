package ca.qc.cgodin.mini_projet3.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_student")
data class Student(
    @PrimaryKey(autoGenerate = false)
    val Mat: String,
    val MDP: String,
    val Nom: String,
    val Prenom: String
)
