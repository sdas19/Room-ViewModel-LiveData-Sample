package soumyajitdas.com.roomviewmodelkotlinsample.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

interface RestApi {

    @GET("all")
    fun getAllCountries() : Call<List<CountryModel>>
}