package com.geektech.homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework1.MainActivity.Companion.astra
import com.geektech.homework1.MainActivity.Companion.rosie
import com.geektech.homework1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    lateinit var inputTV: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.itInput2.setText(intent.getStringExtra(astra))

        binding.btnGo2.setOnClickListener {
            inputTV = binding.itInput2.text.toString().trim()
            if (inputTV==""){
                Toast.makeText(applicationContext, "invalid input", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent()
                intent.putExtra(rosie, inputTV)
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}