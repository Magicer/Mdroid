package xyz.magicer.mdroid.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.fragment_mine.*
import xyz.magicer.core.ModuleLogin
import xyz.magicer.core.utils.logI
import xyz.magicer.mdroid.R


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
            ARouter.getInstance().build(ModuleLogin.login)
                .withString("text","Hello Login Module")
                .navigation()
        }
    }



}
