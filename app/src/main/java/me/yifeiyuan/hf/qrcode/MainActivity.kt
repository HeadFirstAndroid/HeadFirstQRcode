package me.yifeiyuan.hf.qrcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.yifeiyuan.hf.qrcode.databinding.ActivityMainBinding
import me.yifeiyuan.hf.zxing.CaptureActivity


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

    }

    fun testGenQRCode(v: View) {

        val bitmap = QRCode.genQRCode("测试内容", 400)

        bitmap?.let {
            binding.showQRCode.setImageBitmap(it)
        }
    }

    fun testScanQRCode(v: View){
//        IntentIntegrator(this).initiateScan()
        startActivity(Intent(this, CaptureActivity::class.java))
    }

}