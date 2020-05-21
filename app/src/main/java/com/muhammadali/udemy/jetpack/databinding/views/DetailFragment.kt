package com.muhammadali.udemy.jetpack.databinding.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muhammadali.udemy.jetpack.databinding.R
import com.muhammadali.udemy.jetpack.databinding.databinding.DetailLayoutBinding
import com.muhammadali.udemy.jetpack.databinding.viewModel.DetailViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var uuid: Long = 0
    private lateinit var binding: DetailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //retrieving Argument
        arguments?.let {
            uuid = DetailFragmentArgs.fromBundle(it).uuid
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.setDetails(uuid)
//        view.dog
            observeDetails()
        }

    }

    fun observeDetails() {
        viewModel.dogObj.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.dog = it
            }
        })
    }
}

