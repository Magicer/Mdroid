package xyz.magicer.mdroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import xyz.magicer.annotation.Test
import xyz.magicer.annotation.TestKt
import xyz.magicer.core.ModuleApp
import xyz.magicer.core.ui.BaseActivity
import xyz.magicer.mdroid.databinding.ActivityMainBinding
import xyz.magicer.mdroid.viewmodel.TodayViewModel

//@Test
//@TestKt
@Route(path = ModuleApp.main)
class MainActivity : BaseActivity<TodayViewModel>(), CoroutineScope by MainScope() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.data = viewModel
        binding?.lifecycleOwner = this
        viewModel?.loadToday()
//        viewModel.todayResult.observe(this, Observer {
//            logI("complete ===")
//        })

    }


    override fun setViewModel(): TodayViewModel {
        return ViewModelProviders.of(this).get(TodayViewModel::class.java)
    }


}

