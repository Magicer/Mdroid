package xyz.magicer.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import xyz.magicer.core.base.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
    open var viewModel: VM? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = setViewModel()
        observer()
    }


    abstract fun setViewModel(): VM

    private fun observer() {
        viewModel?.uiStateLiveData?.observe(this, Observer {
            when (it) {
                BaseViewModel.LOADING -> {
                    showLoading()
                }
                BaseViewModel.ERROR -> {
                    showLoading()
                }
                BaseViewModel.NETWORK_ERROR -> {
                    showLoading()
                }
                BaseViewModel.HIDE_LOADING -> {
                    hideLoading()
                }
            }
        })
    }

    private fun hideLoading() {

    }

    private fun showLoading() {

    }

}