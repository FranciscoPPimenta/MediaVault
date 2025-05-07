package com.example.mediavault

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mediavault.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var sessionManager: SessionManager

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        if(sessionManager.isLoggedIn()){
            findNavController().navigate(R.id.main_to_logged)
            return
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        backButton?.setOnClickListener {
//            Log.d("teste",sharedViewModel.previousPage.value.toString())
//            when (sharedViewModel.previousPage.value) {
//                "MainMenu" -> {
//                }
//            }
//        }

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.buttonSignIn?.setOnClickListener{
            signIn(view)
        }

        binding.textNewHere?.setOnClickListener {
            findNavController().navigate(R.id.login_to_register)
        }


    }

    private fun signIn(view: View) {
        val email = binding.editEmail?.text.toString()
        val password = binding.editPassword?.text.toString()

        if(email != "" && password != ""){
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        if (user != null) {
                            sessionManager.createLoginSession(user.uid)
                            findNavController().navigate(R.id.login_to_logged)
                        }
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(requireContext(), "Email ou Password Incorreta.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
        else{
            Toast.makeText(requireContext(), "Preencha os campos!",
                Toast.LENGTH_SHORT).show()
        }

    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}