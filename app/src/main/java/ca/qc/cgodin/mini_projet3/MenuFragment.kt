package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private lateinit var _binding: FragmentMenuBinding;
    private val binding get() = _binding!!
    private val viewModel: SuccursaleViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "aut est " + ConnexionFragment.aut,
            Toast.LENGTH_LONG).show()
        viewModel.getCompteSuccursale(CompteSuccursale(ConnexionFragment.aut))
        binding.txtNom.setText("Welcome " + viewModel.connect?.student?.nom + "!");
        binding.txtNbSuccursales.setText("Vous avez " + viewModel.nbSuccursale + " succursale(s)")

        binding.btnDeconnexion.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_connexionFragment)
        }
        binding.btnLister.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_listFragment)
        }
    }
}