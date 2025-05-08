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
import com.example.mediavault.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Register : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var sessionManager: SessionManager

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as? MainActivity)?.setBottomNavigationVisibility(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = Firebase.auth
        binding.buttonSignUp?.setOnClickListener{
            signUp(view)
        }
        binding.textHasAccount?.setOnClickListener{
            findNavController().navigate(R.id.register_to_login)
        }
    }

    private fun signUp(view: View) {
        val email = binding.editEmail?.text.toString()
        val password = binding.editPassword?.text.toString()
        val displayName = binding.editDisplayName?.text.toString()
        val firstName = binding.editFirstName?.text.toString()
        val lastName = binding.editLastName?.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser

                        val db = Firebase.firestore
                        val userMap = hashMapOf(
                            "email" to email,
                            "displayName" to displayName,
                            "firstName" to firstName,
                            "lastName" to lastName
                        )

                        if (user != null) {
                            db.collection("users")
                                .document(user.uid)
                                .set(userMap)
                                .addOnSuccessListener {
                                    Log.d(TAG, "DocumentSnapshot added with ID: ${user.uid}")
                                }
                                .addOnFailureListener { e ->
                                    Log.w(TAG, "Erro a adicionar documento", e)
                                    Toast.makeText(
                                        requireContext(),
                                        "Falha ao criar user",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        }


                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            requireContext(),
                            "Já existe conta com esse email!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        } else {
            Toast.makeText(requireContext(), "Preencha os campos!s", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Restore bottom navigation visibility when leaving this fragment
        (activity as? MainActivity)?.setBottomNavigationVisibility(true)
        _binding = null
    }
}