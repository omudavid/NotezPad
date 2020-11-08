package com.hackerman.notezpad.ui.screens


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackerman.notezpad.R
import com.hackerman.notezpad.databinding.FragmentNotesBinding
import com.hackerman.notezpad.ui.adapter.ClickListener
import com.hackerman.notezpad.ui.adapter.NotesAdapter
import com.hackerman.notezpad.ui.model.Note


class NotesFragment : Fragment(),ClickListener {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        _binding = FragmentNotesBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.setOnClickListener(){
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireView().windowToken,0)
        }


        val list = listOf<Note>(Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),
                Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),
                Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),
                Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),
                Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),
                Note(12,"hkhhvskhbvkhsdbvhkdbv","hfjfsjlbljsblfjlsfjnbsnbs"),

        )


        var adater = NotesAdapter(list,this)
        binding?.notesFragmentRv?.adapter = adater
        binding?.notesFragmentRv?.layoutManager = LinearLayoutManager(context)
        adater.notifyDataSetChanged()
    }

    override fun itemClick(currentItem: Note, position: Int) {
        Toast.makeText(context,"$currentItem",Toast.LENGTH_SHORT).show()
    }
}