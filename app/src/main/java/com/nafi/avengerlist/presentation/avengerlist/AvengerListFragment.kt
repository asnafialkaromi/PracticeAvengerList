package com.nafi.avengerlist.presentation.avengerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nafi.avengerlist.R
import com.nafi.avengerlist.data.datasource.AvengerDataSource
import com.nafi.avengerlist.data.datasource.AvengerDataSourceImpl
import com.nafi.avengerlist.data.model.Avenger
import com.nafi.avengerlist.databinding.FragmentAvengerListBinding
import com.nafi.avengerlist.presentation.avengerdetail.AvengerDetailFragment
import com.nafi.avengerlist.presentation.avengerlist.adapter.AvengersAdapter
import com.nafi.avengerlist.presentation.avengerlist.adapter.OnItemClickedListener

class AvengerListFragment : Fragment() {

    private lateinit var binding: FragmentAvengerListBinding
    private var adapterAvenger: AvengersAdapter? = null


    //init view model
    private val viewModel : AvengersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGridMode()
        setClickAction()
    }

    private fun observeGridMode() {
        viewModel.isUsingGridMode.observe(viewLifecycleOwner){isUsingGridMode ->
            bindAvengerList(isUsingGridMode)
            setButtonText(isUsingGridMode)
        }
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            viewModel.changeListMode()
        }
    }

    private fun setButtonText(usingGridMode: Boolean) {
        binding.btnChangeListMode.setText(if (usingGridMode) "List Mode" else "Grid Mode")
    }

    private fun bindAvengerList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) AvengersAdapter.MODE_GRID else AvengersAdapter.MODE_LIST
        adapterAvenger = AvengersAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Avenger>{
                override fun onItemClicked(item: Avenger) {
                    navigateToDetail(item)
                }
            }
        )
        binding.rvAvengerList.apply {
            adapter = this@AvengerListFragment.adapterAvenger
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapterAvenger?.submitData(viewModel.getAvengersList())
    }

    private fun navigateToDetail(item: Avenger) {
        val  navController = findNavController()
        val bundle = bundleOf(Pair(AvengerDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_avengerListFragment_to_avengerDetailFragment, bundle)
    }

}