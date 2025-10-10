package com.example.app_coolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout



class activity_main : AppCompatActivity() {


    private lateint var textInputAlcool: TextInputLayout //Aqui eu digo que o textInputAlcool é do tipo TextInputLayout
    private lateint var editAlcool: TextInputEditText //TextInputEditText para editar o texto

    private lateint var textInputGasolina: TextInputLayout
    private lateint var editGasolina: TextInputEditText

    private lateint var btnCalcular: Button //botão
    private lateint var textResultado: TextView //show result




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()

        }



            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun activity_main.calcularMelhorPreco() {

        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if(resultadoValidacao ){

            val precoAlcoolNumero   = precoAlcool.toDouble()//tô transformando em double, pq é tostring
            val precoGasolinaNumero = precoGasolina.toDouble()

            val resultado = precoGasolinaNumero / precoAlcoolNumero
            if(resultado >= 0.7){
                textResultado.text = "Melhor utilizar Gasolina"
            }else{

                textResultado.text = ("É melhor utilizar Álcool.")

            }



        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null //Se tem o valor nulo, ele não fica mais vermelho e a mensagem não aparece
        textInputGasolina.error = null

        if(pAlcool.isEmpty()) {//aqui testa se o preco do alcool está vazio
            textInputAlcool.error = "Digite o preço do álcool"//mensagem de erro fica vermelha e repete a mensagem
            return false

        }else if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }

        return true

    }

    private fun inicializarComponentesInterface() {

        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
    }
}