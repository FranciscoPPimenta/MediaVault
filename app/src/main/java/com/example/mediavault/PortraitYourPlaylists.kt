package com.example.mediavault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentPortraitYourAlbumsBinding
import com.example.mediavault.databinding.FragmentPortraitYourPlaylistsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PortraitYourPlaylists : Fragment() {
    private var _binding: FragmentPortraitYourPlaylistsBinding?=null
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
        _binding = FragmentPortraitYourPlaylistsBinding.inflate(inflater, container, false)

        val bottomNavigationView: BottomNavigationView = binding.bottomNav
        val navController = findNavController()

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home-> {
                    navController.navigate(R.id.action_portraitYourPlaylists_to_portraitHome)
                    true
                }
                R.id.about -> {
                    navController.navigate(R.id.action_portraitYourPlaylists_to_portraitAbout)
                    true
                }
                R.id.playlists -> {
                    false
                }
                R.id.albums -> {
                    navController.navigate(R.id.action_portraitYourPlaylists_to_portraitYourAlbums)
                    true
                }
                R.id.tags -> {
                    navController.navigate(R.id.action_portraitYourPlaylists_to_portraitTags)
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