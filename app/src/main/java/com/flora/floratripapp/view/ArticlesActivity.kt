package com.flora.floratripapp.view

import android.content.Context
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

class ArticlesActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        myViewModel = ViewModelProvider(
                this,
                MyViewModelFactory(ServiceBuilder)
        )[MyViewModel::class.java]

        myViewModel.loadData()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame, ArticlesFragment.newInstance())
                .commit()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        myViewModel.loading.removeObserver {  }
        finish()
    }


    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}