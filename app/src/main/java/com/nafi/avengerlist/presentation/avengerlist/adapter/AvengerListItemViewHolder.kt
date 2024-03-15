package com.nafi.avengerlist.presentation.avengerlist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.nafi.avengerlist.R
import com.nafi.avengerlist.base.ViewHolderBinder
import com.nafi.avengerlist.data.model.Avenger
import com.nafi.avengerlist.databinding.ItemAvengerBinding

class AvengerListItemViewHolder(private val binding: ItemAvengerBinding) : ViewHolder(binding.root),
    ViewHolderBinder<Avenger> {
    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl){
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text = it.name
            binding.tvAvengerPower.text = it.power
        }
    }


}