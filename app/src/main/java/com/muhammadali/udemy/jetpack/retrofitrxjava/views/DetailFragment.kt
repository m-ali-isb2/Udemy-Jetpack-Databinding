package com.muhammadali.udemy.jetpack.retrofitrxjava.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.muhammadali.udemy.jetpack.retrofitrxjava.R
import com.muhammadali.udemy.jetpack.retrofitrxjava.model.DogBreed
import com.muhammadali.udemy.jetpack.retrofitrxjava.utils.getProgressDrawable
import com.muhammadali.udemy.jetpack.retrofitrxjava.utils.loadImage
import com.muhammadali.udemy.jetpack.retrofitrxjava.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.detail_layout.body
import kotlinx.android.synthetic.main.detail_layout.name
import kotlinx.android.synthetic.main.item_dog.*
import kotlinx.android.synthetic.main.item_dog.view.*
import kotlinx.android.synthetic.main.item_dog.view.image


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    lateinit var dogBreed: DogBreed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //retrieving Argument
        arguments?.let {
            dogBreed = DetailFragmentArgs.fromBundle(it).dogBreed
//            detailText.text = dogUuid.toString()

        }
//
//        buttonList.setOnClickListener {
//            val action: NavDirections =
//                DetailFragmentDirections.actionDetailFragmentToListFragment()
//            Navigation.findNavController(it).navigate(action)
//
//        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.setDetails(dogBreed)
        observeDetails()
    }

    fun observeDetails() {
        viewModel.dogObj.observe(viewLifecycleOwner, Observer {
            it?.let {
                name.text = it.breed
                purpose.text = it.breedGroup
                temperament.text = it.temperament
                body.text = it.lifespan
                icon.loadImage(it.image, getProgressDrawable(icon.context))

            }
        })
    }
}

