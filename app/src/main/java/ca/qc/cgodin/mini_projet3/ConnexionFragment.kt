package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.databinding.FragmentConnexionBinding


class ConnexionFragment : Fragment() {
private lateinit var _binding: FragmentConnexionBinding;
    private lateinit var succursaleAdapter: SuccursaleAdapter

    private val binding get() = _binding!!
    private val viewModel: SuccursaleViewModel by navGraphViewModels(R.id.nav_graph)
    var matricule : String = ""
    var mdp : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConnexionBinding.inflate(layoutInflater);

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         succursaleAdapter = SuccursaleAdapter()

        binding.btnConnexion.setOnClickListener{
            matricule = binding.txtIdentifiant.text.toString();
            mdp = binding.txtPassword.text.toString();
            val connexion = Connexion(matricule, mdp)
            viewModel.getConnexion(connexion, {
                response ->
            },
                onFailure {
                     ->
                });
            Log.i("", "J'y suis et j'ai le matricule " + viewModel.connexion.value)
            viewModel.connexion.observe(
                viewLifecycleOwner, Observer {studentResponse ->
                    Log.i("Response Connexion", studentResponse.toString())
                    if(studentResponse != null){
                        findNavController().navigate(R.id.action_connexionFragment_to_listFragment)
                    }
                }
            )
        }
    }

}