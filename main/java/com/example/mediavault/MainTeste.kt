//++Updated 6thMay2025 16:18

package com.example.mediavault

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentMainTesteBinding


class MainTeste : Fragment() {

    private lateinit var sessionManager: SessionManager

    private var _binding: FragmentMainTesteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        if(sessionManager.isLoggedIn()){
            Log.d("LoggadoGuardado","Guardou info User")
            findNavController().navigate(R.id.main_to_logged)
            return
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTesteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.mainTeste_to_Login)
        }
    }
}