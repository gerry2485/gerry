package id.asistem.uas2485.ui.favorite

import id.asistem.uas2485.data.db.entities.EventFavorite

interface ClickListener {
    fun onClickListener(eventFavorite: EventFavorite)
}