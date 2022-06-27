package com.trei.testproject.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.databinding.FragmentHomeBinding
import com.trei.testproject.utils.CircularScrollListenerHome
import com.trei.testproject.utils.Resource
import com.trei.testproject.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : Fragment(), HomeAdapter.OnClickListener {

    private var bind: FragmentHomeBinding by autoCleared()
    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentHomeBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllComponents()
        setUpObserver()
        setUpRecycler()

    }

    private fun setUpRecycler() {
        val scroll = CircularScrollListenerHome()
        bind.recycler.addOnScrollListener(scroll)
        bind.recycler.adapter = homeAdapter
    }

    private fun setUpObserver() {
        bind.progressBar.visibility = VISIBLE
        viewModel.albums.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bind.progressBar.visibility = GONE
                    homeAdapter?.setItems(it.data as ArrayList<AlbumModelItem>)
                    //Log.i("TAG", "onViewCreated: " + it.data)
                }
                Resource.Status.ERROR -> {
                    bind.progressBar.visibility = GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    bind.progressBar.visibility = VISIBLE
                }
            }
        }
    }

    private fun initAllComponents() {

        homeAdapter = HomeAdapter(requireContext(), this, viewModel, viewLifecycleOwner)

    }
}