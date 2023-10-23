package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentListBinding
import ca.qc.cgodin.roomstudent.AdapterCallback
import ca.qc.cgodin.roomstudent.SuccursaleListAdapter

class ListFragment : Fragment(), AdapterCallback {
    //private val args: ListFragmentArgs by navArgs()

    private lateinit var binding: FragmentListBinding

    private val succursaleViewModel: SuccursaleViewModel by lazy{
        ViewModelProvider(this).get(SuccursaleViewModel::class.java)
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

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }

        binding.fabBudget.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToBudgetFragment())
        }

        val adapter = SuccursaleListAdapter(requireContext())
        adapter.adapterCallback = this
        binding.rvListeSuccursales.adapter = adapter


        succursaleViewModel.allSuccursales.observe(viewLifecycleOwner, Observer { succursales ->
            // Update the cached copy of the students in the adapter.
            succursales?.let { adapter.setSuccursales(it) }
        })

        return binding.root
    }


    //recoit le message du adapter
    override fun sendID(message: String) {
        Log.i("jsp", succursaleViewModel.allSuccursales.value?.get(message.toInt()).toString())

        var succADelete = succursaleViewModel.allSuccursales.value?.get(message.toInt())
        if (succADelete != null) {
            succursaleViewModel.delete(succADelete)
        }


    }



}