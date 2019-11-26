package xyz.magicer.mdroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.model.TodayRepository
import xyz.magicer.mdroid.utils.logE
import xyz.magicer.mdroid.utils.logI

class TodayViewModel : ViewModel() {

    private val _todayResult: MutableLiveData<TodayResult> = MutableLiveData()

    //只暴露LiveData 而不是MutableLiveData
    val todayResult: LiveData<TodayResult>
        get() = _todayResult

    fun loadToday() {
        viewModelScope.launch {
            val r = TodayRepository().loadToday()
            logI("currentThread ${Thread.currentThread().name}")
            when (r.status) {
                Result.Status.SUCCESS -> {
                    _todayResult.value = r.data
                }
                Result.Status.ERROR -> {

                }
                else -> {
                }
            }

        }
    }

}