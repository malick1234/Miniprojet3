package ca.qc.cgodin.roomstudent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.R
import ca.qc.cgodin.mini_projet3.data.Succursale

class SuccursaleListAdapter constructor(
    context: Context
) : RecyclerView.Adapter<SuccursaleListAdapter.SuccursaleViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var succursales = emptyList<Succursale>() // Cached copy of students

    inner class SuccursaleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val villeItemView: TextView = itemView.findViewById(R.id.tvVille)
        val budgetItemView: TextView = itemView.findViewById(R.id.tvBudget)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuccursaleViewHolder {
        val itemView = inflater.inflate(R.layout.list_item, parent, false)
        return SuccursaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SuccursaleViewHolder, position: Int) {
        val current = succursales[position]
        holder.villeItemView.text = "${current.Ville}"
        holder.budgetItemView.text = "${current.Budget}"
    }

    fun setSuccursales(succursales: List<Succursale>) {
        this.succursales = succursales
        notifyDataSetChanged()
    }

    override fun getItemCount() = succursales.size
}