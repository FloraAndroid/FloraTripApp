package com.flora.floratripapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.flora.floratripapp.MyViewModel
import com.flora.floratripapp.MyViewModelFactory
import com.flora.floratripapp.R
import com.flora.floratripapp.network.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        myViewModel = ViewModelProvider(
//            this,
//            MyViewModelFactory(ServiceBuilder)
//        )[MyViewModel::class.java]

        btn_fetch.setOnClickListener {
//            if (savedInstanceState == null) {
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.frame, ArticlesFragment.newInstance()).addToBackStack("Articles")
//                    .commit()
//            }
            startActivity(Intent(this, ArticlesActivity::class.java))
//            myViewModel.loadData()
//
//        }
//        myViewModel.listArticles.observe(this, Observer {
//            Log.d("Articles", it.toString())
//        })

        }

    }
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}