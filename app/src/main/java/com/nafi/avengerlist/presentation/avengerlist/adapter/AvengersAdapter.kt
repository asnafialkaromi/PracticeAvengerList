package com.nafi.avengerlist.presentation.avengerlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nafi.avengerlist.base.ViewHolderBinder
import com.nafi.avengerlist.data.model.Avenger
import com.nafi.avengerlist.databinding.ItemAvengerBinding
import com.nafi.avengerlist.databinding.ItemAvengerGridBinding

class AvengersAdapter(
    private val listener: OnItemClickedListener<Avenger>,
    private val listMode: Int= MODE_LIST) : RecyclerView.Adapter<ViewHolder>()
{

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<Avenger>() {
            override fun areItemsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                //membandingkan apakah item tersebut sama
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                //yang dibandingkan adalah kontennya
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    fun submitData(data: List<Avenger>){
        asyncDataDiffer.submitList(data)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (listMode == MODE_GRID) AvengerGridItemViewHolder(
            ItemAvengerGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        ) else {
            AvengerListItemViewHolder(
                ItemAvengerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<*>).bind(asyncDataDiffer.currentList[position])
    }
}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}