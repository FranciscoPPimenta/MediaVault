package com.example.mediavault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.mediavault.databinding.BottomSheetMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import androidx.coordinatorlayout.widget.CoordinatorLayout

class CreateMenuFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetMenuBinding.inflate(inflater, container, false)

        // Fechar o menu ao clicar no botão X
        binding.closeButton.setOnClickListener {
            dismiss()
        }

        // Lógica para os botões
        binding.buttonAlbum.setOnClickListener {
            // Ação para o botão "Album"
        }

        binding.buttonPlaylist.setOnClickListener {
            // Ação para o botão "Playlist"
        }

        binding.buttonTag.setOnClickListener {
            // Ação para o botão "Tag"
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()

        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)

        val layoutParams = bottomSheet?.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.height = 500
        bottomSheet?.layoutParams = layoutParams
    }
}
