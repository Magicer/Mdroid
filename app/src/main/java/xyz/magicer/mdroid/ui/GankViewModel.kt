package xyz.magicer.mdroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.magicer.mdroid.base.Error
import xyz.magicer.mdroid.base.Success
import xyz.magicer.mdroid.model.TodayRepository
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.mdroid.utils.logI

class GankViewModel : ViewModel() {
    private val liveData: MutableLiveData<TodayResult> = MutableLiveData()

    //只暴露LiveData 而不是MutableLiveData
    val todayResult: LiveData<TodayResult>
        get() = liveData

    fun loadToday() {
        viewModelScope.launch {
            val r = TodayRepository().loadToday()
            logI("currentThread ${Thread.currentThread().name}")
            when (r) {
                is Success -> {
                    liveData.value = r.data
                }
                is Error -> {

                }
                else -> {
                }
            }

        }
    }

}