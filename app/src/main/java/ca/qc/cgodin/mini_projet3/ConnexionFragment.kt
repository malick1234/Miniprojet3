package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.databinding.FragmentConnexionBinding


class ConnexionFragment : Fragment() {
private lateinit var _binding: FragmentConnexionBinding;
    private val binding get() = _binding!!
    private val viewModel: SuccursaleViewModel by navGraphViewModels(R.id.nav_graph)
    var matricule : String = ""
    var mdp : String = ""
    companion object{
        var aut: String = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConnexionBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtIdentifiant.setText("");
        binding.txtPassword.setText("");
        binding.btnConnexion.setOnClickListener{
            matricule = binding.txtIdentifiant.text.toString();
            mdp = binding.txtPassword.text.toString();

            if(matricule == "" || mdp == ""){
                Toast.makeText(activity, "Veuillez renseignez les champs!",
                    Toast.LENGTH_LONG).show()
            }
            else{
                val connexion = Connexion(matricule, mdp)
                viewModel.getConnexion(connexion);

                if(viewModel.connect?.student != null){
                    aut = matricule + mdp.substring(mdp.length - 5)
                    findNavController().navigate(R.id.action_connexionFragment_to_menuFragment)
                    Toast.makeText(activity, "Bienvenue " + viewModel.connect?.student?.nom,
                        Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(activity, "Les informations entrées sont incorrectes!",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}