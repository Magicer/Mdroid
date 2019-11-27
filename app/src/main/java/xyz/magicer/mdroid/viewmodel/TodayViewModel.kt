package xyz.magicer.mdroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import xyz.magicer.mdroid.base.Error
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.base.Success
import xyz.magicer.mdroid.model.TodayRepository
import xyz.magicer.mdroid.utils.logE
import xyz.magicer.mdroid.utils.logI

class TodayViewModel : ViewModel() {

    init {
        loadToday()
    }

    private val _todayResult: MutableLiveData<TodayResult> = MutableLiveData()

//
//    private  val currentWeather: LiveData<String> = liveData {
//        emit(LOADING_STRING)
//        emitSource(dataSource.fetchWeather())
//    }

    //只暴露LiveData 而不是MutableLiveData
    val todayResult: LiveData<TodayResult>
        get() = _todayResult

    fun loadToday() {
        logI("loadToday start")
        viewModelScope.launch {
            val r = TodayRepository().loadToday()
            logI("currentThread ${Thread.currentThread().name}")
            when (r) {
                is Success -> {
                    logI("success")
                    _todayResult.value = r.data
                }
                is Error -> {
                    logE(r.exception.message?:"error")

                }
                else -> {
                    logE("else === ")
                }
            }

        }
    }

}