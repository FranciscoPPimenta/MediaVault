package com.example.mediavault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentPortraitHomeBinding
import com.example.mediavault.databinding.FragmentPortraitRegisterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PortraitHome : Fragment() {

    private var _binding: FragmentPortraitHomeBinding?=null
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
        _binding = FragmentPortraitHomeBinding.inflate(inflater, container, false)

        val bottomNavigationView: BottomNavigationView = binding.bottomNav
        val navController = findNavController()

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home-> {
                    false
                }
                R.id.about -> {
                    navController.navigate(R.id.action_portraitHome_to_portraitAbout)
                    true
                }
                R.id.playlists -> {
                    navController.navigate(R.id.action_portraitHome_to_portraitYourPlaylists)
                    true
                }
                R.id.albums -> {
                    navController.navigate(R.id.action_portraitHome_to_portraitYourAlbums)
                    true
                }
                R.id.tags -> {
                    navController.navigate(R.id.action_portraitHome_to_portraitTags)
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