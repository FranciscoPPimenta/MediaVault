package com.example.mediavault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationView

class Playlist : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnOpenDrawer: View
    private lateinit var btnCloseDrawer: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        // Botão que abre o BottomSheet
        val showMenuButton: ImageButton = view.findViewById(R.id.imageButton5)
        showMenuButton.setOnClickListener {
            val createMenuFragment = CreateMenuFragment()
            // Use requireActivity().supportFragmentManager para aceder o FragmentManager
            createMenuFragment.show(requireActivity().supportFragmentManager, createMenuFragment.tag)
        }

        drawerLayout = view.findViewById(R.id.drawer_layout)
        navigationView = view.findViewById(R.id.navigation_view)
        btnOpenDrawer = view.findViewById(R.id.imageButton9)
        btnCloseDrawer = navigationView.getHeaderView(0).findViewById(R.id.btn_close_drawer)

        btnOpenDrawer.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        btnCloseDrawer.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    true
                }
                R.id.nav_about -> {
                    // Ação para "About"
                    true
                }
                R.id.nav_playlists -> {
                    // Ação para "Playlists"
                    true
                }
                R.id.nav_albums -> {
                    // Ação para "Albums"
                    true
                }
                R.id.nav_tags -> {
                    // Ação para "Tags"
                    true
                }
                else -> false
            }.also {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        return view
    }
}
