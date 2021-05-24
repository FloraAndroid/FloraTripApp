package com.flora.floratripapp.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.flora.floratripapp.MyViewModel
import com.flora.floratripapp.MyViewModelFactory
import com.flora.floratripapp.R
import com.flora.floratripapp.network.ServiceBuilder

class ArticlesActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        myViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(ServiceBuilder)
        )[MyViewModel::class.java]

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame, ArticlesFragment.newInstance())
                .commit()
        }

    }


    override fun onBackPressed() {
        myViewModel.loading.postValue(null)
        myViewModel.loading.removeObserver {  }
        this.viewModelStore.clear()
        this.finish()
    }



    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}