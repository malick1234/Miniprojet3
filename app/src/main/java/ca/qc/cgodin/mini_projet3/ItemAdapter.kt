package ca.qc.cgodin.mini_projet3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.databinding.ActivityItemAdapterBinding
import ca.qc.cgodin.mini_projet3.models.Succursales

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.SuccursaleViewHolder>() {
    private var succursales: List<Succursales> = emptyList()
    private var itemBinding: ActivityItemAdapterBinding? = null

    inner class SuccursaleViewHolder(private val binding: ActivityItemAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        val nomSuccursale: TextView = binding.txtNomSucc
        val budget: TextView = binding.txtBudget
        //val supprimer: Button = binding.btnSupprimer
        //val modifier: Button = binding.btnModifier
        val textLayout: LinearLayout = binding.llText
        //val buttonLayout: LinearLayout = binding.llButton
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuccursaleViewHolder {
        itemBinding = ActivityItemAdapterBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return SuccursaleViewHolder(itemBinding!!)
    }

    override fun getItemCount(): Int = succursales.size


    override fun onBindViewHolder(holderSuccursales: SuccursaleViewHolder, position: Int)
    {
        val succursale = succursales[position]
        holderSuccursales.nomSuccursale.text = succursale.ville
        holderSuccursales.budget.text = succursale.Budget
        holderSuccursales.textLayout.setBackgroundColor(Color.BLUE)
    }
    fun setSuccursales(succursales: List<Succursales>) {
        this.succursales = succursales
        notifyDataSetChanged()
    }

}