package id.asistem.uas2485.ui.detail


import id.asistem.uas2485.data.model.EventDetail

interface EventDetailView{
    fun showLoading()
    fun hideLoading()
    fun showEventDetail(data: List<EventDetail>)
}