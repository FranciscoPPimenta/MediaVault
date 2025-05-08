package com.example.mediavault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentPortraitAboutBinding
import com.example.mediavault.databinding.FragmentPortraitHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PortraitAbout : Fragment() {
    private var _binding: FragmentPortraitAboutBinding?=null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPortraitAboutBinding.inflate(inflater, container, false)

        val bottomNavigationView: BottomNavigationView = binding.bottomNav
        val navController = findNavController()

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home-> {
                    navController.navigate(R.id.action_portraitAbout_to_portraitHome)
                    true
                }
                R.id.about -> {
                    false
                }
                R.id.playlists -> {
                    navController.navigate(R.id.action_portraitAbout_to_portraitYourPlaylists)
                    true
                }
                R.id.albums -> {
                    navController.navigate(R.id.action_portraitAbout_to_portraitYourAlbums)
                    true
                }
                R.id.tags -> {
                    navController.navigate(R.id.action_portraitAbout_to_portraitTags)
                    true
                }
                else -> false
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}