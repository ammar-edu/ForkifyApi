package com.s95ammar.forkifyapi.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.s95ammar.forkifyapi.R
import com.s95ammar.forkifyapi.ui.main.Dish

class DishesAdapter : ListAdapter<Dish, DishesAdapter.DishViewHolder>(DishDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        getItem(position)?.let { dish ->
            holder.bind(dish)
        }
    }

    class DishViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(dish: Dish) {
            val textView =  itemView.findViewById<TextView>(R.id.dish_name_textView)
            val imageView =  itemView.findViewById<ImageView>(R.id.dish_image_view)

            textView.text = dish.title

            Glide.with(itemView)
                .load(dish.imageUrl)
//                .placeholder(R.drawable.ic_image_loading)
//                .error(R.drawable.ic_image_error)
                .centerCrop()
                .into(imageView)
        }
    }

    class DishDiffUtil : DiffUtil.ItemCallback<Dish>() {
        override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem == newItem
        }
    }
}