package com.example.apiliveapp.ui

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiliveapp.data.CatFactApi
import com.example.apiliveapp.data.model.Fact
import com.example.apiliveapp.databinding.FactItemBinding

class FactAdapter(
    val dataset: List<Fact>
) : RecyclerView.Adapter<FactAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: FactItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val fact = dataset[position]

        holder.binding.factTV.text = fact.fact
    }
}