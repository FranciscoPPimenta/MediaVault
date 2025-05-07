package com.example.mediavault

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mediavault.databinding.FragmentCreatePlaylistBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CreatePlaylist : Fragment() {

    private lateinit var sessionManager: SessionManager

    private var _binding: FragmentCreatePlaylistBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreatePlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createPlaylist.setOnClickListener{
            createPlaylist(view)
        }
    }

    private fun createPlaylist(view: View) {
        val title = binding.title.text.toString()
        val desc = binding.desc.text.toString()
        val userId = sessionManager.getUserID()

        val db = Firebase.firestore
        val userMap = hashMapOf(
            "title" to title,
            "desc" to desc,
            "userID" to userId
        )
        db.collection("playlists")
            .document()
            .set(userMap)
            .addOnSuccessListener {
                Log.d(TAG, "DocumentSnapshot added!")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Erro a adicionar documento", e)
                Toast.makeText(
                    requireContext(),
                    "Falha ao criar playlist",
                    Toast.LENGTH_SHORT)
                    .show()
            }
    }
}