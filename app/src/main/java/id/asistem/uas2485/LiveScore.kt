package id.asistem.uas2485

import android.app.Application
import id.asistem.uas2485.data.db.AppDatabase
import id.asistem.uas2485.data.pref.PrefManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class LiveScore : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@LiveScore))

    }

    companion object {
        @get:Synchronized
        lateinit var instance: LiveScore
        lateinit var prefManager: PrefManager
        lateinit var db: AppDatabase

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefManager = PrefManager(this)
        db = AppDatabase(this)
    }
}