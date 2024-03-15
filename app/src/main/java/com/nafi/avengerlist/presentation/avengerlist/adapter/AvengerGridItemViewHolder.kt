package com.nafi.avengerlist.presentation.avengerlist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.nafi.avengerlist.R
import com.nafi.avengerlist.base.ViewHolderBinder
import com.nafi.avengerlist.data.model.Avenger
import com.nafi.avengerlist.databinding.ItemAvengerBinding
import com.nafi.avengerlist.databinding.ItemAvengerGridBinding

class AvengerGridItemViewHolder(private val binding: ItemAvengerGridBinding) : ViewHolder(binding.root),
    ViewHolderBinder<Avenger> {
    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl){
                // crossfade, gambar muncul secara perlahan
                crossfade(true)
                // error, gambar fallbcak ketika gambar gagal di load
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text= it.name
        }
    }


}