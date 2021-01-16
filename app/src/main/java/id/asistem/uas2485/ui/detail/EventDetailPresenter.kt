package id.asistem.uas2485.ui.detail

import com.google.gson.Gson
import id.asistem.uas2485.data.api.ApiRepository
import id.asistem.uas2485.data.api.TheSportDBApi
import id.asistem.uas2485.data.model.EventDetailResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventDetailPresenter(private val view: EventDetailView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson){

    fun getEventDetail(eventId: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getEventDetail(eventId)),
                    EventDetailResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventDetail(data.events)
            }
        }
    }
}