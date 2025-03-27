package com.sarahlappin.recyclerview
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sarahlappin.recyclerview.databinding.CardViewBinding
import androidx.core.content.ContextCompat


class RecyclerAdapter
    (private val items: List<RandomItem>,

            ) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

    holder.itemView.setOnClickListener { view ->
        val intent = Intent(view.context, SecondActivity::class.java).apply {
            // Pass data via intent
            putExtra("title", item.title)
            putExtra("detail", item.detail)
            putExtra("imageResId", item.imageResId)
            putExtra("arrayIndex", position) // Add array index as a hidden value
        }
        // Start the activity
        ContextCompat.startActivity(view.context, intent, null)

}
    }
    override fun getItemCount(): Int = items.size


    inner class ViewHolder(private val binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RandomItem) {
            binding.itemTitle.text = item.title
            binding.itemDetail.text = item.detail
            binding.itemImage.setImageResource(item.imageResId)
        }
    }


}