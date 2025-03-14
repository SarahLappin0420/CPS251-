package com.sarahlappin.projectnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sarahlappin.projectnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageResId = arguments?.getInt("imageResId")
        val title = arguments?.getString("title")

        if (imageResId != null) {
            binding.ImageView.setImageResource(imageResId)
            binding.title.text = "Image $imageResId"
        }
        if (title != null) {
            binding.title.text = title
        }
        activity?.title = title
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}