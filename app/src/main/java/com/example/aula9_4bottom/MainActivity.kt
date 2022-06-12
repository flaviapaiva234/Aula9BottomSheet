package com.example.aula9_4bottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula9_4bottom.databinding.ActivityMainBinding
import com.example.aula9_4bottom.databinding.CustomBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // esse bottomSheetIncluido veio do meu include no layout activity_main
        val bottomSheet = binding.bottomSheetIncluido.root

        binding.btnSubir.setOnClickListener {
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    private fun showBottomSheetDialog(){

        val dialog = BottomSheetDialog(this)
        val sheetBinding: CustomBottomSheetBinding = CustomBottomSheetBinding.inflate(layoutInflater, null, false)

        dialog.setContentView(sheetBinding.root)


    }
}