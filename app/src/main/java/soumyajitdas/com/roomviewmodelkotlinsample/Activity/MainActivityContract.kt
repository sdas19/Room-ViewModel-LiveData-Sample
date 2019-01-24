package soumyajitdas.com.roomviewmodelkotlinsample.Activity

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

interface MainActivityContract {

    interface View
    {
        fun setUpCountryRecyclerView (countries : List<CountryModel>)
    }

    interface Presenter
    {
        fun apiCallAndPutInDB()

        fun getCountries() : Flowable<List<CountryModel>>

    }
}