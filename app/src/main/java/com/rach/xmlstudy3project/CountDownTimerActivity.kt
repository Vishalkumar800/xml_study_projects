package com.rach.xmlstudy3project

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rach.xmlstudy3project.databinding.ActivityCountDownTimerBinding

class CountDownTimerActivity : AppCompatActivity() {

    private var binding: ActivityCountDownTimerBinding? = null
    private var countDownTimer : CountDownTimer? = null
    private var totalTime:Long = 60000
    private var timeLeft :Long = totalTime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCountDownTimerBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding!!.countText.text = "${timeLeft/1000}"

        binding!!.startButton.setOnClickListener {
            startCountDownTimer()
        }

        binding!!.stopButton.setOnClickListener {
            stopTimer()
        }
        binding!!.restartButton.setOnClickListener {
            restart()
        }

    }

    private fun startCountDownTimer(){
        countDownTimer?.cancel()

        countDownTimer =  object :CountDownTimer(timeLeft , 1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                binding!!.countText.text = "${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                binding!!.countText.text = "0"
                Toast.makeText(this@CountDownTimerActivity,"Time ended " ,Toast.LENGTH_LONG).show()
                timeLeft = totalTime
            }

        }.start()
    }

    private fun stopTimer(){
        countDownTimer?.cancel()
    }
    private fun restart(){
        countDownTimer?.cancel()
        timeLeft = totalTime
        binding!!.countText.text = "${timeLeft/1000}"

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}