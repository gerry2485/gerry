package id.asistem.uas2485.ui.event

import id.asistem.uas2485.data.model.Event

interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}