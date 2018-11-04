package soumyajitdas.com.roomviewmodelkotlinsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

class CountryRecyclerViewAdapter(_context : Context, _countryList:List<CountryModel>) : RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {

    val context = _context
    val countryList = _countryList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.single_country_model_layout,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder:CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryName.text = country.name
        holder.countryCapital.text = country.capital
        holder.countryPopulation.text = country.population.toString()

    }


    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val countryName : TextView = itemView.findViewById(R.id.country_name)
        val countryCapital : TextView = itemView.findViewById(R.id.country_capital)
        val countryPopulation : TextView = itemView.findViewById(R.id.country_population)
        val countryImage : ImageView = itemView.findViewById(R.id.country_image)
    }

}