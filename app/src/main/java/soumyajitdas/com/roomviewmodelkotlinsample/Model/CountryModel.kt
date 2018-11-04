package soumyajitdas.com.roomviewmodelkotlinsample.Model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Countries")
data class CountryModel (

        @PrimaryKey
        var name : String,
        var capital : String,
        var population : Int,
        var flag:String

)
