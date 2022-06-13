package com.example.aula9_4bottom

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        binding.btnDialogS.setOnClickListener {
            dialogSimples()
        }

        binding.btnAlegria.setOnClickListener {
            dialogJoy()
        }
    }

    //Criando um dialogozinho bem nativão android
    private fun dialogSimples() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Hi friend")
        builder.setMessage("Always have JOY in your life!")
        //Criando o botão positivo
        builder.setPositiveButton("Right!", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                //Para criar um Toast (aquelas menssagenszinhas) tem que ter:
                // a classe do Toast
               Toast.makeText( // metodo *.makeText*
                   this@MainActivity, // tem que passar um contexto
                   "God bless you!!!", // um texto
                   Toast.LENGTH_SHORT  // e passar a duração que vai aparecer na tela, que pode ser curta *Toast.LENGTH_SHORT* ou um pouco longa *Toast.LENGTH_LONG*
               ).show() //.show() é para mostrar o Toast.
            }
            
        })

        builder.setNegativeButton("Ops!", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                //Para criar um Toast (aquelas menssagenszinhas) tem que ter:
                // a classe do Toast
                Toast.makeText( // metodo *.makeText*
                    this@MainActivity, // tem que passar um contexto
                    "Oh my God!!!", // um texto
                    Toast.LENGTH_SHORT  // e passar a duração que vai aparecer na tela, que pode ser curta *Toast.LENGTH_SHORT* ou um pouco longa *Toast.LENGTH_LONG*
                ).show() //.show() é para mostrar o Toast.
            }

        })

        builder.setNeutralButton("Null!", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                //Para criar um Toast (aquelas menssagenszinhas) tem que ter:
                // a classe do Toast
                Toast.makeText( // metodo *.makeText*
                    this@MainActivity, // tem que passar um contexto
                    "Have a nice day!!!", // um texto
                    Toast.LENGTH_SHORT  // e passar a duração que vai aparecer na tela, que pode ser curta *Toast.LENGTH_SHORT* ou um pouco longa *Toast.LENGTH_LONG*
                ).show() //.show() é para mostrar o Toast.
            }

        })

        builder.create().show()
    }

    private fun dialogJoy() {
        val view: View = layoutInflater.inflate(R.layout.activity_joy, null)
        val builder = AlertDialog.Builder(this).also {
            it.setTitle("Menssagem Motivacional Alegre")
            it.setView(view)
        }
        val alert = builder.create()
        view.findViewById<Button>(R.id.btnRecebo).setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Recebido",
                Toast.LENGTH_SHORT
            ).show()
            alert.dismiss()
        }
        alert.show()
    }




//    private fun showBottomSheetDialog(){
//
//        val dialog = BottomSheetDialog(this)
//        val sheetBinding: CustomBottomSheetBinding = CustomBottomSheetBinding.inflate(layoutInflater, null, false)
//
//        dialog.setContentView(sheetBinding.root)
//
//
//    }
}