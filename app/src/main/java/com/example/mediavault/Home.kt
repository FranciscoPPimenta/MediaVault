package com.example.mediavault

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnOpenDrawer: View
    private lateinit var btnCloseDrawer: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        btnOpenDrawer = findViewById(R.id.imageButton9) // botão hambúrguer/menu
        btnCloseDrawer = navigationView.getHeaderView(0).findViewById(R.id.btn_close_drawer)

        // Abrir o menu (ícone hambúrguer)
        btnOpenDrawer.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Fechar o menu (ícone X no header)
        btnCloseDrawer.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Ação para "Home"
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
    }
}
