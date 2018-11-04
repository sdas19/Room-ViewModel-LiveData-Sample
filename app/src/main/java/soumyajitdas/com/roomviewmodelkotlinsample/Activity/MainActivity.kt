package soumyajitdas.com.roomviewmodelkotlinsample.Activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel
import soumyajitdas.com.roomviewmodelkotlinsample.CountryRecyclerViewAdapter
import soumyajitdas.com.roomviewmodelkotlinsample.R

class MainActivity : AppCompatActivity() {

    lateinit var countryRecyclerView: RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryRecyclerView = findViewById(R.id.countryRecyclerView)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        if(isNetworkConnected(this))
        {
            mainActivityViewModel.getCountriesFromAPIAndStore()

        }
        else
        {
            Toast.makeText(this,"No internet found. Showing cached list in the view",Toast.LENGTH_LONG).show()
        }

        mainActivityViewModel.getAllCountryList().observe(this, Observer<List<CountryModel>> { countryList ->
            Log.e(MainActivity::class.java.simpleName,countryList.toString())
            setUpCountryRecyclerView(countryList!!)
        })
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun setUpCountryRecyclerView(countries : List<CountryModel>)
    {
        val countryRecyclerViewAdapter = CountryRecyclerViewAdapter(this, countries)
        countryRecyclerView.adapter = countryRecyclerViewAdapter
        countryRecyclerView.layoutManager = GridLayoutManager(this,2)
        countryRecyclerView.setHasFixedSize(true)
    }

}
