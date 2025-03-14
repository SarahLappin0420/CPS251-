package com.sarahlappin.projectnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sarahlappin.projectnavigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("imageResId", R.mipmap.image1)
            bundle.putString("title", "image1")
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

        binding.button2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("imageResId", R.mipmap.image2)
            bundle.putString("title", "image2")
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

        binding.button3.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("imageResId", R.mipmap.image3)
            bundle.putString("title", "image3")
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}