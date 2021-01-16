package id.asistem.uas2485.data.api

import java.net.URL


class ApiRepository{

    fun doRequest(url: String): String{
        return URL(url).readText()
    }
}