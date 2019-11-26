package xyz.magicer.mdroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import xyz.magicer.mdroid.databinding.ActivityMainBinding
import xyz.magicer.mdroid.utils.logI
import xyz.magicer.mdroid.viewmodel.TodayViewModel

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null

//    private val viewModel: TodayViewModel by lazy {
//        ViewModelProviders.of(this).get(TodayViewModel::class.java)
//    }

    private val viewModel by viewModels<TodayViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding?.data = viewModel
        binding?.lifecycleOwner = this
        viewModel.loadToday()
        viewModel.todayResult.observe(this, Observer {
            logI("complete ===")
        })

    }


}

