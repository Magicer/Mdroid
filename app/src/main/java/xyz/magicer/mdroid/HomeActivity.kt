package xyz.magicer.mdroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navController = Navigation.findNavController(this,R.id.fragment)

//        NavigationUI.setupWithNavController(bottomNav,navController)
        bottomNav.setupWithNavController(navController)

        bottomNav.selectedItemId = R.id.homeFragment


    }
}
