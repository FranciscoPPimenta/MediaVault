//++Added 6thMay2025 16:18
package com.example.mediavault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentLoggedMainTesteBinding


class LoggedMainTeste : Fragment() {

    private lateinit var sessionManager: SessionManager

    private var _binding: FragmentLoggedMainTesteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoggedMainTesteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.logoutButton.setOnClickListener{
            sessionManager.logoutUser()
            findNavController().navigate(R.id.logged_to_main)
        }
    }


}