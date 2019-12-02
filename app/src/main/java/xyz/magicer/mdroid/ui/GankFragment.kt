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
import xyz.magicer.mdroid.base.Success
import xyz.magicer.mdroid.model.bean.ResultInfo
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.mdroid.utils.logI
import xyz.magicer.mdroid.viewmodel.TodayViewModel


class GankFragment : Fragment() {

    private val viewModel by lazy{

        //这里要使用activity的scope 因为navigation是通过replace来切换fragment的，
        //会destroyView并且重新onCreateView 使用activity的scope能够使在viewmodel中
        //已经请求成功的数据不至于再次被请求
        //todo 暂时使用这种方法 fixme？
        ViewModelProviders.of(activity!!).get(GankViewModel::class.java)
    }

    private val adapter:GankAdapter by lazy {
        GankAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logI("onCreate GankFragment ${savedInstanceState?.getString("text")?:""}")
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

//        viewModel.loadToday()

        viewModel.todayResult.observe(this, Observer {
            logI("complete today ${it.category}")
            adapter.submitList(it.results.android)
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("test","随便输入内容")
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
