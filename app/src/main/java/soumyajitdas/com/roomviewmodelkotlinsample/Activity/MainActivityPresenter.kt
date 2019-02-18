package soumyajitdas.com.roomviewmodelkotlinsample.Activity

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soumyajitdas.com.roomviewmodelkotlinsample.DB.CountryDatabase
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel
import soumyajitdas.com.roomviewmodelkotlinsample.Retrofit.RestApi
import soumyajitdas.com.roomviewmodelkotlinsample.RoomViewModelKotlinSampleApplication
import javax.inject.Inject

class MainActivityPresenter(_mainView : MainActivityContract.View) : MainActivityContract.Presenter{


    val mainView = _mainView
    val BASE_URL = "https://restcountries.eu/rest/v2/"
    val TAG = MainActivityPresenter::class.java.simpleName

    @Inject
    lateinit var countryDatabase: CountryDatabase

    @Inject
    lateinit var retrofit: Retrofit


    init {
        RoomViewModelKotlinSampleApplication.mApiComponent?.inject(this)
    }

    override fun apiCallAndPutInDB() {

        /*val gson = Gson()
        val retrofit =  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()*/

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllCountries().enqueue(object : Callback<List<CountryModel>> {

            override fun onFailure(call: Call<List<CountryModel>>?, t: Throwable?) {
                Log.e(TAG,"OOPS!! something went wrong..")
            }

            override fun onResponse(call: Call<List<CountryModel>>?, response: Response<List<CountryModel>>?) {

                Log.e(TAG,response!!.body().toString())
                when(response.code())
                {
                    200 ->{
                        Thread(Runnable {

                            countryDatabase.countryDao().deleteAllCountries()
                            countryDatabase.countryDao().insertAllCountries(response.body()!!)

                        }).start()
                    }
                }

            }
        })    }

    override fun getCountries(): Flowable<List<CountryModel>> {
        return countryDatabase.countryDao().getAllCountries()
    }

}