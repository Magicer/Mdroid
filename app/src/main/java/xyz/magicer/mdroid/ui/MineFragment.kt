package xyz.magicer.mdroid.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.fragment_mine.*

import xyz.magicer.mdroid.R
import xyz.magicer.core.logI


class MineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logI("MineFragment")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivImage.setOnClickListener {
            ARouter.getInstance().build("/login/login")
                .withString("text","Hello Login Module")
                .navigation()
        }
    }


}
