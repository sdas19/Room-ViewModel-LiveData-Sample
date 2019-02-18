package soumyajitdas.com.roomviewmodelkotlinsample

import android.app.Application
import android.arch.persistence.room.Room
import soumyajitdas.com.roomviewmodelkotlinsample.DB.CountryDatabase
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Component.ApiComponent
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Component.DaggerApiComponent
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Module.ApiModule
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Module.AppModule

class RoomViewModelKotlinSampleApplication : Application() {

    /*companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }*/



    companion object {
         var mApiComponent: ApiComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerApiComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule("https://restcountries.eu/rest/v2/"))
                .build()
    }


}