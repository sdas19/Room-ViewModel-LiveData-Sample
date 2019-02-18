package soumyajitdas.com.roomviewmodelkotlinsample.DI.Module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import soumyajitdas.com.roomviewmodelkotlinsample.DB.CountryDatabase
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDataBase(application : Application) : CountryDatabase
    {
        return Room.databaseBuilder(application, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}