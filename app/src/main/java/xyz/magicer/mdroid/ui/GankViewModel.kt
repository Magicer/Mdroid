package xyz.magicer.mdroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.magicer.core.bean.Error
import xyz.magicer.core.bean.Success
import xyz.magicer.mdroid.model.TodayRepository
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.core.utils.logI

class GankViewModel : ViewModel() {
    private val liveData: MutableLiveData<TodayResult> = MutableLiveData()

    init {
        loadToday()
    }

    //只暴露LiveData 而不是MutableLiveData
    val todayResult: LiveData<TodayResult>
        get() = liveData

    fun loadToday() {
        logI("gankViewModel loadToday Start")
        viewModelScope.launch {
            val r = TodayRepository().loadToday()
            logI("currentThread ${Thread.currentThread().name}")
            when (r) {
                is Success -> {
                    logI("gankViewModel success ")
                    liveData.value = r.data
                }
                is Error -> {

                }
            }

        }
    }

}