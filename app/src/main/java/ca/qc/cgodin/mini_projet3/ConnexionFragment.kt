package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ca.qc.cgodin.mini_projet3.databinding.FragmentConnexionBinding


class ConnexionFragment : Fragment() {
private lateinit var binding: FragmentConnexionBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConnexionBinding.inflate(layoutInflater);

        binding.btnConnexion.setOnClickListener{
            findNavController().navigate(ConnexionFragmentDirections.actionConnexionFragmentToListFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}