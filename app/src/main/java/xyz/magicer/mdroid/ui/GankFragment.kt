package xyz.magicer.mdroid.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_gank.*

import xyz.magicer.mdroid.R
import xyz.magicer.mdroid.adapter.GankAdapter
import xyz.magicer.mdroid.utils.logI
import xyz.magicer.mdroid.viewmodel.TodayViewModel


class GankFragment : Fragment() {

    private val viewModel by lazy{

        //这里要使用activity的scope 因为navigation是通过replace来切换fragment的，
        //会destroyView并且重新onCreateView 使用activity的scope能够使在viewmodel中
        //已经请求成功的数据不至于再次被请求
        ViewModelProviders.of(activity!!).get(TodayViewModel::class.java)
    }

    private val adapter:GankAdapter by lazy {
        GankAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logI("onCreate GankFragment ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        logI("onViewCreated GankFragment")

        viewModel.todayResult.observe(this, Observer {
            logI("complete today ${it.category}")
            adapter.submitList(it.results.android)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        logI("onDestroyView GankFragment")

    }
    override fun onDestroy() {
        super.onDestroy()
        logI("onDestroy GankFragment")
    }


}
