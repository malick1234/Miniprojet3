package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentAddBinding
import ca.qc.cgodin.roomstudent.SuccursaleListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAddBinding

    private val succursaleViewModel: SuccursaleViewModel by lazy{
        ViewModelProvider(this).get(SuccursaleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.btnRetour.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToListFragment())
        }


        binding.btnAjouterSucc.setOnClickListener {

            if (binding.etVille.text.trim().length == 0){
                Toast.makeText(requireContext(), "Veuillez écrire le nom de la ville !", Toast.LENGTH_LONG).show()
            }
            else if(binding.etBudget.text.trim().length == 0){
                Toast.makeText(requireContext(), "Veuillez écrire le budget !", Toast.LENGTH_LONG).show()
            }
            else if(binding.etVille.text.trim().length == 0 &&
                binding.etBudget.text.trim().length == 0){
                Toast.makeText(requireContext(), "Veuillez inscrire les informations du succursale !", Toast.LENGTH_LONG).show()
            }
            else{
                val ville = binding.etVille.text.trim().toString()
                val budget = binding.etBudget.text.trim().toString().toInt()
                val succursale = Succursale(ville,budget)
                succursaleViewModel.insert(succursale)
                findNavController().navigate(AddFragmentDirections.actionAddFragmentToListFragment())

            }

        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}