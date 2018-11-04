package soumyajitdas.com.roomviewmodelkotlinsample

import android.app.Application
import android.arch.persistence.room.Room
import soumyajitdas.com.roomviewmodelkotlinsample.DB.CountryDatabase

class RoomViewModelKotlinSampleApplication : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}