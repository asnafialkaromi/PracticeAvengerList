package com.nafi.avengerlist.base

import com.nafi.avengerlist.data.model.Avenger

interface ViewHolderBinder<T> {
    fun bind(item: Avenger)
}