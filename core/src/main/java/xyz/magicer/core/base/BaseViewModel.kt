package xyz.magicer.core.base

import androidx.annotation.IntDef
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {
    private val uiState: MutableLiveData<Int> = MutableLiveData()
    private val prompt: MutableLiveData<String> = MutableLiveData() //提示语

    val uiStateLiveData: LiveData<Int>
        get() = uiState

    val promptLiveData: LiveData<String>
        get() = prompt

    fun emitUiState(@UiState int: Int, prompt: String) {
        uiState.value = int
        this.prompt.value = prompt
    }

    companion object {
        const val LOADING = 1
        const val ERROR = 2
        const val NETWORK_ERROR = 3
        const val HIDE_LOADING = 4
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(LOADING, ERROR, NETWORK_ERROR, HIDE_LOADING)
    annotation class UiState


}