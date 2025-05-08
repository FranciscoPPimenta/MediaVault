package com.example.mediavault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentPortraitRegisterBinding

class PortraitRegister : Fragment() {

    private var _binding:FragmentPortraitRegisterBinding?=null
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
        _binding = FragmentPortraitRegisterBinding.inflate(inflater, container, false)

        binding.textHasAccount.setOnClickListener{
            findNavController().navigate(R.id.action_portraitRegister_to_portraitLogin)
        }

        binding.buttonSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_portraitRegister_to_portraitHome)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}