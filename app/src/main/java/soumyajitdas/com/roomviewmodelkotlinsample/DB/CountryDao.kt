package soumyajitdas.com.roomviewmodelkotlinsample.DB

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

@Dao
interface CountryDao {

    @Query("SELECT * FROM Countries")
    fun getAllCountries() : Flowable<List<CountryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countryList: List<CountryModel>)

    @Query("DELETE FROM Countries")
    fun deleteAllCountries()
}