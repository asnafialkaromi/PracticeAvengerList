package com.nafi.avengerlist.presentation.avengerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nafi.avengerlist.R
import com.nafi.avengerlist.databinding.FragmentAvengerListBinding

class AvengerListFragment : Fragment() {

    private lateinit var binding : FragmentAvengerListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAvengerListBinding.inflate(layoutInflater, container,false)
        return inflater.inflate(R.layout.fragment_avenger_list, container, false)
    }

}