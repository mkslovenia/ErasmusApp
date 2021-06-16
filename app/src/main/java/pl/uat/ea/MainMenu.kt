package pl.uat.ea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class MainMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)

        val weatherButton = view.findViewById<Button>(R.id.weatherButton)
        val newsButton = view.findViewById<Button>(R.id.newsButton)
        val tipsButton = view.findViewById<Button>(R.id.tipsButton)
        val qrmenuButton = view.findViewById<Button>(R.id.QRMenuButton)
        val favPlacesButton = view.findViewById<Button>(R.id.favPlacesButton)

        weatherButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_weather)
        }

        newsButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_news)
        }

        tipsButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_tips)
        }

        qrmenuButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_QRMenu)
        }

        favPlacesButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_favPlaces)
        }

        //Add menu
        setHasOptionsMenu(true)

        return view
    }

}