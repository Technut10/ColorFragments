package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val BLUE = 1
private const val RED = 2


/**
 * A simple [Fragment] subclass.
 * Use the [ChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoiceFragment : Fragment() {

    private var choiceListener: ColorListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ColorListener){
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement something")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val redButton = view.findViewById<TextView>(R.id.red_fragment)
        val blueButton = view.findViewById<TextView>(R.id.blue_fragment)
        redButton.setOnClickListener {
            choiceListener?.onSelect(RED)
        }
        blueButton.setOnClickListener {
            choiceListener?.onSelect(BLUE)

        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * tis fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChoiceFragment.
         */
        // TODOd: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChoiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}