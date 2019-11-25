package xyz.magicer.mdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import xyz.magicer.mdroid.databinding.ActivityMainBinding
import xyz.magicer.mdroid.utils.logI
import xyz.magicer.mdroid.viewmodel.TodayViewModel

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null

    private val viewModel: TodayViewModel by lazy {
        ViewModelProviders.of(this).get(TodayViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding?.data = viewModel
        binding?.lifecycleOwner = this
        viewModel.loadToday()
        viewModel.liveData.observe(this, Observer {
            logI("complete ===")
        })

    }


}

