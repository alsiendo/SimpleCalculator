package com.siendo.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operation = ""
    var oldNumbers = ""
    var newNumbers = ""
    var isNewOp = true
    var isDot = false
    var leftNum = false
    var rightNum = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View){
        if (isNewOp) {
            clearTheDisplay()
        }
        isNewOp = false
        var btnSelect = view as Button
        var btnClickValue: String = displayNumber.text.toString()
        when (btnSelect.id){
            btn0.id -> {
                if(btnClickValue != "") btnClickValue += "0"
            }
            btn1.id -> {
                btnClickValue += "1"
            }
            btn2.id -> {
                btnClickValue += "2"
            }
            btn3.id -> {
                btnClickValue += "3"
            }
            btn4.id -> {
                btnClickValue += "4"
            }
            btn5.id -> {
                btnClickValue += "5"
            }
            btn6.id -> {
                btnClickValue += "6"
            }
            btn7.id -> {
                btnClickValue += "7"
            }
            btn8.id -> {
                btnClickValue += "8"
            }
            btn9.id -> {
                btnClickValue += "9"
            }
            btnDot.id -> {
                if (btnClickValue == "") {
                    btnClickValue += "0."
                    isDot = true
                }else {
                    if(isDot == false) {
                        btnClickValue += "."
                        isDot = true
                    }
                }
            }
            btnNegative.id -> {
                Log.i("Nilai : ", btnClickValue)
                if(btnClickValue != "") btnClickValue = (btnClickValue.toDouble() * -1).toString()
            }
        }
        displayNumber.setText(btnClickValue)
        if(leftNum == false) firstNum.setText(btnClickValue)
        else secondNum.setText(btnClickValue)
    }

    fun btnOpEvent(view: View){
        var btnSelect = view as Button
        when(btnSelect.id){
            btnDiv.id -> {
                operation = "/"
            }
            btnMul.id -> {
                operation = "*"
            }
            btnSum.id -> {
                operation = "+"
            }
            btnSub.id -> {
                operation = "-"
            }
        }
        oldNumbers = displayNumber.text.toString()
        isNewOp = true
        theOperation.setText(operation)
        leftNum = true
    }

    fun btnEqualEvent(view: View){
        var newNumber = displayNumber.text.toString()
        var finalNumber: Double? = null
        when(operation){
            "*" -> {
                finalNumber = oldNumbers.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumbers.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumbers.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumbers.toDouble() - newNumber.toDouble()
            }
        }
        clearTheDisplay()
        clearTheOperation()
        firstNum.setText(finalNumber.toString())
        leftNum = false
        displayNumber.setText(finalNumber.toString())
        isNewOp = false
    }

    fun btnClearEvent(view: View){
        clearTheDisplay()
        clearTheOperation()
    }

    fun btnPercentEvent(view:View){
        var temp = (displayNumber.text.toString().toDouble()/100).toString()
        Log.i(temp, "btnPercentEvent: ")
        clearTheDisplay()
        displayNumber.setText(temp)
    }

    fun clearTheDisplay(){
        displayNumber.setText("")
        isNewOp = true
        isDot = false
    }

    fun clearTheOperation(){
        leftNum = false
        rightNum = false
        firstNum.setText("")
        secondNum.setText("")
        theOperation.setText("")
    }
    //CATATAN
    // 0 Pertama kali tidak boleh
}