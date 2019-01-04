package com.c4coding.prayertime.ui.fragments.calenderIslamic

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.c4coding.prayertime.R

class IslamicCalanderFragment : Fragment() {



    private lateinit var viewModel: IslamicCalanderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.islamic_calander_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(    savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IslamicCalanderViewModel::class.java)

    }

}
