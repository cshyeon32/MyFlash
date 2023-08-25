package com.example.myflash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myflash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val torch = Torch(this)
        binding.flashSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                startService(Intent(this, FlashService::class.java).apply {
                    action="on"
                })
                //torch.flashOn()
            }else {
                startService(Intent(this, FlashService::class.java).apply {
                action="off"
            })
                //torch.flashOff()
            }
        }
    }
}