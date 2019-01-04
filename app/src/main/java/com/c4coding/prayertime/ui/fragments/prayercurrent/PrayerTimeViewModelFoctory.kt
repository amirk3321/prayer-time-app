package com.c4coding.prayertime.ui.fragments.prayercurrent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.c4coding.prayertime.data.repository.Repository

class PrayerTimeViewModelFoctory(private val repository : Repository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PrayerTimeViewModel(repository = repository) as T
    }
}