package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.graphics.Color
import android.graphics.Color.rgb
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val COLOR_CHOICE = "COLOR_CHOICE"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {
     val blue = rgb(150, 150, 255)
    val red = rgb(255,150,150)
    var myIndex : Int = 0

    companion object {
        private var fragmentCount = 0
        // TODOd: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(choice: Int) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_CHOICE, choice)
                }

            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          if(savedInstanceState == null){
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        Log.d("ColorFragment", "===ON VIEW CREATED!!!====")
        val colorChoice = arguments?.getInt(COLOR_CHOICE) ?: 0
        val lowerFragment = view.findViewById<TextView>(R.id.mycolor)

        when(colorChoice) {
            1 -> {
                lowerFragment.setBackgroundColor(blue)
                lowerFragment.text ="GENERIC RED FRAGMENT - UID $myIndex"
            }
            2 -> {
                lowerFragment.setBackgroundColor(red)
                lowerFragment.text ="GENERIC BLUE FRAGMENT - UID $myIndex"

            }
        }
    }


}