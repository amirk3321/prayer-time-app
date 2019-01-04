package com.c4coding.prayertime.ui.fragments.prayercurrent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.c4coding.prayertime.R
import com.c4coding.prayertime.ui.base.FragmentScope
import kotlinx.android.synthetic.main.prayer_time_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class PrayerTimeFragment : FragmentScope(),KodeinAware{
    override val kodein by closestKodein()

    val mViewModelFoctory : PrayerTimeViewModelFoctory by instance()


    private lateinit var viewModel: PrayerTimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.prayer_time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,mViewModelFoctory).get(PrayerTimeViewModel::class.java)
        (activity as? AppCompatActivity)?.supportActionBar?.title="Prayer Time"
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle=""

 /*       val api=PrayerTimeApiServices(NetworkConnectionImpl(this.context!!))
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response=api.getTiming("karachi","pakistan").await()
                current_time.text=response.data.timings.toString()
            }catch (e : ExectionHandler){
                Log.e("NetworkIOExecption"," Error :"+e.message.toString())
            }
        }
        */

        initilizeUI()
    }
    fun initilizeUI() = launch{
        val schdule=viewModel.response.await()
        schdule.observe(this@PrayerTimeFragment, Observer {
            if (it==null) return@Observer

            current_time.text=it.toString()
        })
    }

}
