package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.ListFragment
import androidx.fragment.app.replace

interface ColorListener{
    fun onSelect(id: Int)
}


class MainActivity : AppCompatActivity(), ColorListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            findViewById<FragmentContainerView>(R.id.upperfragment_container)?.let{
                frameLayout ->
                val choiceFragment = ChoiceFragment()
                supportFragmentManager.beginTransaction().add(frameLayout.id, choiceFragment).commit()
            }
        }
    }


    override fun onSelect(id:Int) {
        val fcv = findViewById<FragmentContainerView>(R.id.lower_fragment_container)
        val colorFragment = ColorFragment.newInstance(id)
        supportFragmentManager.beginTransaction().replace(fcv.id, colorFragment).addToBackStack(null).commit()
    }


}