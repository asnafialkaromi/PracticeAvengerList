package com.nafi.avengerlist.presentation.avengerdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nafi.avengerlist.R
import com.nafi.avengerlist.databinding.FragmentAvengerDetailBinding


class AvengerDetailFragment : Fragment() {

    private lateinit var binding: FragmentAvengerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAvengerDetailBinding.inflate(layoutInflater,container,false)
        return inflater.inflate(R.layout.fragment_avenger_detail, container, false)
    }


}