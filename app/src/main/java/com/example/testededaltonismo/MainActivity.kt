package com.example.testededaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_teste2.*
import java.time.Instant

class MainActivity : AppCompatActivity() {
    var resultado1 = 0; var resultado2 = 0; var resultado3 = 0
   val MY_CODE_1 = 2; val MY_CODE_2 = 45; val MY_CODE_3 = 10
    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resposta1.text = ("$resultado1")
        resposta2.text = ("$resultado2")
        resposta3.text = ("$resultado3")


        bresultado.setOnClickListener(){
            if(resultado1 == 2 && resultado2 == 45 && resultado3 == 10) {
                vResultado.text = ("Visão normal")
            }
            else if(resultado1 != 2 && resultado2 != 45 && resultado3 != 10){
                vResultado.text = ("Daltonismo")
            }
            else {
                vResultado.text = ("Valores não inseridos")
            }
        }
    }
     fun clique(v:View){
        var image = 0
        var code = 0
        when(v.id){
            R.id.bteste1->{
                code = MY_CODE_1
                image = 1
            }R.id.bteste2->{
                code = MY_CODE_2
                image = 2
            }R.id.bteste3->{
                code = MY_CODE_3
                image = 3
            }
        }
        var i = Intent(this, Teste2Activity::class.java)
        var b = Bundle()
        b.putInt("imgCode", image)
        i.putExtras(b)
        startActivityForResult(i, code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("TAG", "request code = $requestCode, result code = $resultCode")
        when(requestCode){
            MY_CODE_1->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultado1 = data?.getStringExtra("RESPOSTA")?.toInt()!!
                        Log.i("RESPOSTA", "$resultado1" )
                       resposta1.text = "$resultado1"
                        Toast.makeText(this, "Número Salvo", Toast.LENGTH_LONG).show()
                    }
                    Activity.RESULT_CANCELED->{
                    }
                }
            }
        }
        when(requestCode){
            MY_CODE_2->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        //val resposta = data?.extras
                       // val resultado =   resposta?.getString("RESPOSTA")
                       // resposta2.text = resultado.toString()
                        resultado2 = data?.getStringExtra("RESPOSTA")?.toInt()!!
                        Log.i("RESPOSTA", "$resultado2")
                        resposta2.text = "$resultado2"
                        Toast.makeText(this, "Número Salvo", Toast.LENGTH_LONG).show()
                    }
                    Activity.RESULT_CANCELED->{
                    }
                }
            }
        }
        when(requestCode){
            MY_CODE_3->{
                when(resultCode){
                    Activity.RESULT_OK->{
                       // var resposta = data?.extras
                       // var resultado =   resposta?.getString("RESPOSTA")
                       //resultado3.text = resultado.toString()
                       resultado3 = data?.getStringExtra("RESPOSTA")?.toInt()!!
                       Log.i("RESPOSTA", "$resultado3")
                        resposta3.text = "$resultado3"
                        Toast.makeText(this, "Número Salvo", Toast.LENGTH_LONG).show()
                    }
                    Activity.RESULT_CANCELED->{
                    }
                }
            }
        }
    }
}
