package br.com.viniciusrodriguesdasilva_rm95828

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PraiasAdapter(private val praiaList: ArrayList<Praia>, private val context: Context) :
    RecyclerView.Adapter<PraiasAdapter.PraiaViewHolder>() {

    inner class PraiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomePraia: TextView = itemView.findViewById(R.id.NomePraia)
        val cidadePraia: TextView = itemView.findViewById(R.id.CidadePraia)
        val estadoPraia: TextView = itemView.findViewById(R.id.EstadoPraia)
        val btnDeletar: Button = itemView.findViewById(R.id.btnDeletar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PraiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_praia, parent, false)
        return PraiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PraiaViewHolder, position: Int) {
        val beach = praiaList[position]
        holder.nomePraia.text = beach.nome
        holder.cidadePraia.text = beach.cidade
        holder.estadoPraia.text = beach.estado

        holder.btnDeletar.setOnClickListener {
            (context as MainActivity).removeBeach(position)
        }
    }

    override fun getItemCount() = praiaList.size
}