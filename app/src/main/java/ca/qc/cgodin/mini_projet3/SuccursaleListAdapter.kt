package ca.qc.cgodin.roomstudent

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.ListFragment
import ca.qc.cgodin.mini_projet3.ListFragmentDirections
import ca.qc.cgodin.mini_projet3.MainActivity
import ca.qc.cgodin.mini_projet3.R
import ca.qc.cgodin.mini_projet3.data.Succursale
import ca.qc.cgodin.mini_projet3.data.SuccursaleDao
import ca.qc.cgodin.mini_projet3.data.SuccursaleViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SuccursaleListAdapter constructor(
    context: Context
) : RecyclerView.Adapter<SuccursaleListAdapter.SuccursaleViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var succursales = emptyList<Succursale>() // Cached copy of students

    var adapterCallback: AdapterCallback? = null
    var adapterCallbackInfos: AdapterCallbackInfos? = null

    inner class SuccursaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val villeItemView: TextView = itemView.findViewById(R.id.tvVille)
        val budgetItemView: TextView = itemView.findViewById(R.id.tvBudget)
        val btnDelete: FloatingActionButton = itemView.findViewById(R.id.fabDeleteSucc)
        val btnUpdate: FloatingActionButton = itemView.findViewById(R.id.fabUpdate)
        val btnFavoris: FloatingActionButton = itemView.findViewById(R.id.fabSave)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuccursaleViewHolder {
        val itemView = inflater.inflate(R.layout.list_item, parent, false)
        return SuccursaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SuccursaleViewHolder, position: Int) {
        val current = succursales[position]
        holder.villeItemView.text = "${current.Ville}"
        holder.budgetItemView.text = "${current.Budget}"

        holder.btnDelete.setOnClickListener {
            adapterCallback?.sendID(position.toString())
        }

        holder.btnUpdate.setOnClickListener {
            holder.itemView.findNavController().navigate(ListFragmentDirections.actionListFragmentToUpdateFragment())
        }

        holder.btnFavoris.setOnClickListener {
            holder.itemView.findNavController().navigate(ListFragmentDirections.actionListFragmentToListFragmentFavoris())
        }

    }


    fun setSuccursales(succursales: List<Succursale>) {
        this.succursales = succursales
        notifyDataSetChanged()
    }

    override fun getItemCount() = succursales.size
}


