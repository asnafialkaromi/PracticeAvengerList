package com.nafi.avengerlist.presentation.avengerdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.nafi.avengerlist.R
import com.nafi.avengerlist.data.model.Avenger
import com.nafi.avengerlist.databinding.FragmentAvengerDetailBinding


class AvengerDetailFragment : Fragment() {

    private lateinit var binding: FragmentAvengerDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAvengerDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentData()
    }

    private fun getArgumentData() {
        val item = arguments?.getParcelable<Avenger>(EXTRAS_ITEM)
        binding.ivAvengerPhoto.load(item?.profilePictUrl){
            // crossfade, gambar muncul secara perlahan
            crossfade(true)
            // error, gambar fallbcak ketika gambar gagal di load
            error(R.mipmap.ic_launcher)
        }
        binding.tvName.text = item?.name
        binding.tvAvengerPower.text = item?.power
        binding.tvDesc.text = item?.profileDesc
        Toast.makeText(requireContext(),item?.name, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
    }

}