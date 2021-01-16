package id.asistem.uas2485.ui.event

import com.google.gson.Gson
import id.asistem.uas2485.data.api.ApiRepository
import id.asistem.uas2485.data.api.TheSportDBApi
import id.asistem.uas2485.data.model.EventResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){
    fun getEventList(league: String?, event: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getEvent(league, event)),
                    EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }
}
