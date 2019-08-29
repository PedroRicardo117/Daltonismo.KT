package com.example.testededaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_teste2.*

class Teste2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste2)

        var params = intent.extras
        var imagem = params?.getInt("imgCode")

        if (imagem == 1){
           IDimg.setImageResource(R.drawable.test2)
        }
        if(imagem == 2){
            IDimg.setImageResource(R.drawable.test45)
        }
        if(imagem == 3) {
            IDimg.setImageResource(R.drawable.test10)
        }
        var i = Intent(this, MainActivity::class.java)
        cancelButton.setOnClickListener(){
            Toast.makeText(this, "Operação Cancelada", Toast.LENGTH_LONG).show()
            startActivity(i)
        }

        confirmButton.setOnClickListener(){
            i.putExtra("RESPOSTA", valorText.text.toString())
            Toast.makeText(this, "Valor Salvo", Toast.LENGTH_LONG).show()
            setResult(Activity.RESULT_OK,i)
            finish()

        }

    }
}
