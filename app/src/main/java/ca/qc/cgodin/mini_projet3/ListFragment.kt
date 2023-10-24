package ca.qc.cgodin.mini_projet3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleFavoris
import ca.qc.cgodin.mini_projet3.data.SuccursaleFavorisViewModel
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentListBinding
import ca.qc.cgodin.mini_projet3.repository.SuccursaleRepository
import ca.qc.cgodin.roomstudent.AdapterCallback
import ca.qc.cgodin.roomstudent.SuccursaleListAdapter

class ListFragment : Fragment(), AdapterCallback {
    //private val args: ListFragmentArgs by navArgs()

    private lateinit var binding: FragmentListBinding

    private val succursaleViewModel: SuccursaleViewModel by lazy{
        ViewModelProvider(this).get(SuccursaleViewModel::class.java)
    }

    private val succursaleViewModelFavoris: SuccursaleFavorisViewModel by lazy{
        ViewModelProvider(this).get(SuccursaleFavorisViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }

        binding.fabBudget.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToBudgetFragment())
        }

        binding.fabFav.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToListFragmentFavoris())
        }


        val adapter = SuccursaleListAdapter(requireContext())
        adapter.adapterCallback = this
        binding.rvListeSuccursales.adapter = adapter


        succursaleViewModel.allSuccursales.observe(viewLifecycleOwner, Observer { succursales ->
            // Update the cached copy of the students in the adapter.
            succursales?.let { adapter.setSuccursales(it) }
        })
    }


    //recoit le message du adapter
    override fun sendSucc(succursale: Succursale, code: String) {
        Log.i("code:",code)
        if(code=="DELETE"){
            succursaleViewModel.delete(succursale)
        }
        else if(code == "FAV"){
            val succFav = SuccursaleFavoris(0, succursale.Ville, succursale.Budget)
            succursaleViewModelFavoris.insert(succFav)
        }

    }

    override fun sendSuccFav(succ: SuccursaleFavoris, code: String) {
    }


}