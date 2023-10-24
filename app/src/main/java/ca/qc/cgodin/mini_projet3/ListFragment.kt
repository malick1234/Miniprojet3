package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val viewModel: SuccursaleViewModel by navGraphViewModels(R.id.nav_graph)
    private lateinit var succursaleAdapter: ItemAdapter
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        succursaleAdapter = ItemAdapter()
        viewModel.getListeSuccursale(CompteSuccursale(ConnexionFragment.aut))
        binding.rvSuccursales.adapter = succursaleAdapter

        viewModel.liste.observe(
            viewLifecycleOwner,
            Observer { listeReponse ->
                succursaleAdapter.setSuccursales(listeReponse.succursales)
            }
        )
        /*succursaleAdapter.setOnItemClickListener {
            Log.i("Labo8", "You have clicked on me!!")
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment,
                bundle
            )
        }*/
    }
}