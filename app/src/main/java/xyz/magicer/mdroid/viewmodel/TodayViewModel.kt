package xyz.magicer.mdroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import xyz.magicer.mdroid.base.TodayResult
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.model.TodayRepository
import xyz.magicer.mdroid.utils.logE

class TodayViewModel : ViewModel() {

    val liveData: MutableLiveData<TodayResult> = MutableLiveData()

    fun loadToday() {
        viewModelScope.launch {
            val r = TodayRepository().loadToday()
            when (r.status) {
                Result.Status.SUCCESS -> {
                    liveData.value = r.data
                }
                Result.Status.ERROR -> {
                    logE(r.message ?: "")
                }
                else -> {}
            }

        }
    }

}