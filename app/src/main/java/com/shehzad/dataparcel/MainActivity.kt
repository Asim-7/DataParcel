package com.shehzad.dataparcel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mExampleList: ArrayList<ExampleItem>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createExampleList()

        var mRecyclerView: RecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.setHasFixedSize(true)
        var mLayoutManager = LinearLayoutManager(this)

        var mAdapter: ExampleAdapter = ExampleAdapter(mExampleList!!)
        mRecyclerView.setLayoutManager(mLayoutManager)
        mRecyclerView.setAdapter(mAdapter)

        mAdapter.setOnItemClickListener(object : ExampleAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, Activity2::class.java)
                intent.putExtra("Example Item", mExampleList!![position])
                startActivity(intent)
            }

        })

    }

    fun createExampleList() {
        mExampleList = ArrayList()
        mExampleList!!.add(ExampleItem(R.drawable.ic_android_black_24dp, "Line 1", "Line 2"))
        mExampleList!!.add(ExampleItem(R.drawable.ic_audiotrack_black_24dp, "Line 3", "Line 4"))
        mExampleList!!.add(ExampleItem(R.drawable.ic_wb_sunny_black_24dp, "Line 5", "Line 6"))
    }

}
