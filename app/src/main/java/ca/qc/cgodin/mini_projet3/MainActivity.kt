package ca.qc.cgodin.mini_projet3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SuccursaleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}