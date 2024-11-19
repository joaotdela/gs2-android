package joaotdela.com.github.joaotancredi_rm93527.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import joaotdela.com.github.joaotancredi_rm93527.R
import joaotdela.com.github.joaotancredi_rm93527.model.DicaModel

class DicaAdapter(private val tips: MutableList<DicaModel>,
                  private val onItemClicked: (DicaModel) -> Unit) :
    RecyclerView.Adapter<DicaAdapter.ItemViewHolder>() {

    private var listaDicas = listOf<DicaModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.titleTextView)
        val desc = view.findViewById<TextView>(R.id.descTextView)

        fun bind(item: DicaModel) {
            title.text = item.title
            desc.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dica_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = listaDicas.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listaDicas[position]
        holder.bind(item)
    }

    fun updateDicas(newDicas: List<DicaModel>){
        listaDicas = newDicas
        notifyDataSetChanged()
    }
}
