package com.tiki.viewbaseplaground.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiki.viewbaseplaground.databinding.FragmentCatelogBinding

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatelogBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ExampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentCatelogBinding.inflate(layoutInflater)
        adapter = ExampleAdapter {
            findNavController().navigate(it.destination)
        }
        binding.exampleList.adapter = adapter
        binding.exampleList.layoutManager = LinearLayoutManager(requireContext())
        adapter.submitList(EXAMPLES)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}