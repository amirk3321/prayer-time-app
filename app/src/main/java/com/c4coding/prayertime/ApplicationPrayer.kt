package com.c4coding.prayertime

import android.app.Application
import com.c4coding.prayertime.data.db.PrayerDatabase
import com.c4coding.prayertime.data.network.Response.*
import com.c4coding.prayertime.data.repository.Repository
import com.c4coding.prayertime.data.repository.RepositoryImpl
import com.c4coding.prayertime.ui.fragments.prayercurrent.PrayerTimeViewModelFoctory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ApplicationPrayer : Application(),KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ApplicationPrayer))

        bind() from  singleton { PrayerDatabase(instance()) }
        bind() from singleton { instance<PrayerDatabase>().prayerDao() }
        bind<NetworkConnection>() with singleton { NetworkConnectionImpl(instance()) }
        bind() from singleton { PrayerTimeApiServices(instance()) }
        bind<NetworkDataSource>() with singleton { NetworkDataSourcempl(instance()) }
        bind<Repository>() with singleton { RepositoryImpl(instance(),instance()) }
        bind() from provider { PrayerTimeViewModelFoctory(instance()) }
    }
}