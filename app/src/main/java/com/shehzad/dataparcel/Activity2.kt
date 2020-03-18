package com.shehzad.dataparcel

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val intent = intent
        val exampleItem: ExampleItem = intent.getParcelableExtra("Example Item")
        val imageRes = exampleItem.getImageResource()
        val line1 = exampleItem.getText1()
        val line2 = exampleItem.getText2()
        val imageView =
            findViewById<ImageView>(R.id.image_activity2)
        imageView.setImageResource(imageRes)
        val textView1 = findViewById<TextView>(R.id.text1_activity2)
        textView1.text = line1
        val textView2 = findViewById<TextView>(R.id.text2_activity2)
        textView2.text = line2
    }
}
