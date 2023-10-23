package ca.qc.cgodin.mini_projet3

import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ca.qc.cgodin.mini_projet3.databinding.FragmentBudgetBinding
import ca.qc.cgodin.mini_projet3.databinding.FragmentUpdateBinding
import ca.qc.cgodin.roomstudent.AdapterCallback
import ca.qc.cgodin.roomstudent.AdapterCallbackInfos
import ca.qc.cgodin.roomstudent.SuccursaleListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentUpdateBinding

    private var ville: String = ""
    private var budget: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val ville = arguments?.getString("VILLE")
        val budget = arguments?.getString("BUDGET")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater)

//        val ville = arguments?.getString("VILLE")
//        binding.tvVilleMod.text = ville

        binding.btnUpdate.setOnClickListener {
            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
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
         * @return A new instance of fragment UpdateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpdateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        fun newInstance(id: String, ville: String, budget: String): UpdateFragment {
            val fragment = UpdateFragment()
            val args = Bundle()
            args.putString("ID", id)
            args.putString("VILLE", ville)
            args.putString("BUDGET", budget)
            fragment.arguments = args
            return fragment
        }


    }

}