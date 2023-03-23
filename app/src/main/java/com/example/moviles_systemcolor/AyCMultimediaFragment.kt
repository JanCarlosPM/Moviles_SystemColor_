package com.example.moviles_systemcolor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.moviles_systemcolor.databinding.FragmentAycmultimediaBinding

class AyCMultimediaFragment : Fragment() {

    private lateinit var binding: FragmentAycmultimediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAycmultimediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnUno.setOnClickListener {
            it.findNavController().navigate(R.id.imagenFragment)
        }
        binding.btnDos.setOnClickListener {
            it.findNavController().navigate(R.id.videoFragment)
        }
    }
}