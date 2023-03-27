package com.geektech.homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var inputTV: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            inputTV = binding.itInput.text.toString().trim()
            if (inputTV==""){
                Toast.makeText(applicationContext, "invalid input", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(astra, inputTV)
                resultLauncher.launch(intent)
            }
        }
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: String? = result.data!!.getStringExtra(rosie)
                Log.e("astra", data.toString())
                binding.itInput.setText(data)
            }
        }

    companion object{
        const val astra: String = "ASTRA"
        const val rosie: String = "ROSIE"
    }
}