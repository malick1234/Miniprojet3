package ca.qc.cgodin.mini_projet3

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SuccursaleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}