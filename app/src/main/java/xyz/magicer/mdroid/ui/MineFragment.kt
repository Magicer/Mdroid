package xyz.magicer.mdroid.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import xyz.magicer.mdroid.R
import xyz.magicer.mdroid.utils.logI


class MineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logI("MineFragment")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }


}
