package ph.kodego.sumaya.juan.activity9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.sumaya.juan.activity9.databinding.GroceryItemBinding
import ph.kodego.sumaya.juan.activity9.model.GroceryItem

class ItemAdapter(var items: ArrayList<GroceryItem>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemAdapter.ItemViewHolder {
        val itemBinding = GroceryItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int){
        holder.bindGroceryItem(items[position])
    }

    inner class ItemViewHolder(private val itemBinding: GroceryItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        var item = GroceryItem()

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Snackbar.make(itemBinding.root, item.item,
                Snackbar.LENGTH_SHORT).show()
        }

        fun bindGroceryItem(groceryItem: GroceryItem) {
            this.item = groceryItem
            itemBinding.itemName.text = "${groceryItem.item}, ${groceryItem.quantity} pcs."
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}