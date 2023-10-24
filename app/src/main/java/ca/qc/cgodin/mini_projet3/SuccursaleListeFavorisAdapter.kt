package ca.qc.cgodin.mini_projet3

import ca.qc.cgodin.mini_projet3.data.SuccursaleFavoris
import ca.qc.cgodin.roomstudent.AdapterCallback
import ca.qc.cgodin.roomstudent.AdapterCallbackInfos

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

class SuccursaleListeFavorisAdapter constructor(
    context: Context
) : RecyclerView.Adapter<SuccursaleListeFavorisAdapter.SuccursaleViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var succursales = emptyList<SuccursaleFavoris>() // Cached copy of students

    var adapterCallback: AdapterCallback? = null

    inner class SuccursaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val villeItemView: TextView = itemView.findViewById(R.id.tvVille)
        val budgetItemView: TextView = itemView.findViewById(R.id.tvBudget)
        val btnDelete: FloatingActionButton = itemView.findViewById(R.id.fabDeleteSucc)
        val btnUpdate: FloatingActionButton = itemView.findViewById(R.id.fabUpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuccursaleViewHolder {
        val itemView = inflater.inflate(R.layout.list_item_favoris, parent, false)
        return SuccursaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SuccursaleViewHolder, position: Int) {
        val current = succursales[position]
        holder.villeItemView.text = "${current.Ville}"
        holder.budgetItemView.text = "${current.Budget}"

        holder.btnDelete.setOnClickListener {

            adapterCallback?.sendSuccFav(current, "DELETE")
        }

        holder.btnUpdate.setOnClickListener {
            holder.itemView.findNavController().navigate(ListFragmentFavorisDirections.actionListFragmentFavorisToListFragment())
        }

    }

    fun setSuccursales(succursales: List<SuccursaleFavoris>) {
        this.succursales = succursales
        notifyDataSetChanged()
    }

    override fun getItemCount() = succursales.size
}


