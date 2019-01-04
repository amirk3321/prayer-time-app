package com.c4coding.prayertime.ui.fragments.prayercurrent

import androidx.lifecycle.ViewModel;
import com.c4coding.prayertime.Internal.lazyDefered
import com.c4coding.prayertime.data.repository.Repository

class PrayerTimeViewModel(private val repository: Repository) : ViewModel() {

    val response by lazyDefered {
        repository.getCurrentTime()
    }

}
