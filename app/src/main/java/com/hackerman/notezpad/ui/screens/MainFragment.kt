package com.hackerman.notezpad.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackerman.notezpad.R
import com.hackerman.notezpad.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
     private var binding:FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setFragment(NotesFragment())

        binding?.bottomNavigationView?.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.notes -> setFragment( NotesFragment())
                R.id.favorites -> setFragment( FavouritesFragment())
                R.id.todos -> setFragment(ToDosFragment())
            }
            true
        }
    }

    private fun setFragment(fragment:Fragment){
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }

}