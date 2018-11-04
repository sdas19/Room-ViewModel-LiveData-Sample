package soumyajitdas.com.roomviewmodelkotlinsample.DB

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase :RoomDatabase(){

    abstract fun countryDao() : CountryDao
}


