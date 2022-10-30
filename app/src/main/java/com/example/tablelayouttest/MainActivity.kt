package com.example.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var arrayList = arrayListOf<Pair>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_button.setOnClickListener {
            arrayList.add(Pair(androidVersion.text.toString(),androidCodeName.text.toString()))
            updateTable(arrayList)
        }
    }

    fun updateTable(arrayList: ArrayList<Pair>){
        for (a in arrayList){
            val tableRow = TableRow(getApplicationContext())
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)
            val androidVersionTextView = TextView(getApplicationContext())
            androidVersionTextView .text = a.androidVersion
            val androidCodeTextView  = TextView(getApplicationContext())
            androidCodeTextView .text = a.androidCode
            tableRow.addView(androidVersionTextView,0)
            tableRow.addView(androidCodeTextView,1)
            tableLayout.addView(tableRow)
        }
    }
    data class Pair(var androidVersion:String, var androidCode:String)
}