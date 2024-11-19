package joaotdela.com.github.joaotancredi_rm93527

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val items = mutableListOf<ItemModel>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView = view.findViewById<TextView>(R.id.textViewTitle)
        val descView = view.findViewById<TextView>(R.id.textViewDesc)
        fun bind(item: ItemModel) {
            titleView.text = item.title
            descView.text = item.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    fun updateItems(items: List<ItemModel>?): List<ItemModel>? {

    }


}