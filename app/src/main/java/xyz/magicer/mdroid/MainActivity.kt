package xyz.magicer.mdroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import xyz.magicer.annotation.Test
import xyz.magicer.annotation.TestKt
import xyz.magicer.mdroid.databinding.ActivityMainBinding
import xyz.magicer.mdroid.viewmodel.TodayViewModel

//@Test
//@TestKt
@Route(path = "/app/main")
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
//        viewModel.todayResult.observe(this, Observer {
//            logI("complete ===")
//        })

    }


}

