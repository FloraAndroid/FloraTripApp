package com.flora.floratripapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flora.floratripapp.MyViewModel
import com.flora.floratripapp.R
import com.flora.floratripapp.databinding.FragmentArticlesBinding
import com.flora.floratripapp.view.model.Result
import kotlinx.android.synthetic.main.fragment_articles.*


class ArticlesFragment : Fragment() {
    lateinit var myViewModel: MyViewModel
    var binding: FragmentArticlesBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        activity?.let {
            myViewModel = ViewModelProvider(it).get(MyViewModel::class.java)
        }

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = myViewModel
        list_items.layoutManager = LinearLayoutManager(context)
        list_items.setHasFixedSize(true)
        var adapterList = ArticleListAdapter()
        list_items.adapter = adapterList
        myViewModel.loading.observe(viewLifecycleOwner, Observer {

            when (it) {
                is Result.Success -> {
                    it.data.let(adapterList::submitList)
                }
                is Result.Failure -> {
                    Toast.makeText(activity, it.exception, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() =
                ArticlesFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}