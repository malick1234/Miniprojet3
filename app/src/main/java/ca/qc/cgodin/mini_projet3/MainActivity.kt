package ca.qc.cgodin.mini_projet3

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SuccursaleViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import ca.qc.cgodin.mini_projet3.databinding.ActivityMainBinding
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository

class MainActivity : AppCompatActivity() {
    private val navController by lazy {     val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController }

    private lateinit var binding: ActivityMainBinding
    private lateinit var succursaleViewModel : SuccursaleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val succursaleRepository = SuccursaleRepository()
        val viewModelProviderFactory = SuccursaleViewModelProvider(succursaleRepository)
        try {
            val viewModelProvider = ViewModelProvider(
                navController.getViewModelStoreOwner(R.id.nav_graph),
                viewModelProviderFactory)
            succursaleViewModel = viewModelProvider.get(SuccursaleViewModel::class.java)
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
        }
    }
}