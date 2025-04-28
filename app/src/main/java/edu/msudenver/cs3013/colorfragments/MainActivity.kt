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

    fun onCreatedView(savedInstanceState: Bundle?){

    }

    fun insertFrag(){
        var flag : Boolean = true
        var mainLayout : LinearLayout = findViewById(R.id.main)
        var inflater : LayoutInflater = getLayoutInflater()
        var colorFragment : View = inflater.inflate(R.layout.fragment_color , mainLayout, false)

    }
    override fun onSelect(id:Int) {
        id.let { pickColor ->
            val colorFragment = ColorFragment.newInstance(id)
            val cf = id
            val redFrag = Color.rgb(255, 150, 150)
            val blueFrag = Color.rgb(155,155, 250)
        }
    }


}