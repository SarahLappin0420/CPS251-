package com.sarahlappin.coroutines
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarahlappin.coroutines.databinding.CardViewBinding

class RecyclerAdapter(private var names: List<String> = emptyList()) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(private val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.nameTextView.text = name
        }
    }

    // Inflating the layout and creating ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Binding data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(names[position])
    }

    // Getting the size of the list
    override fun getItemCount(): Int = names.size

    // Dynamically updating the list
    fun submitList(newNames: List<String>) {
      names= newNames // Add new names
        notifyDataSetChanged() // Notify the adapter to refresh
    }
}
