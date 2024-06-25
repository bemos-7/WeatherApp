package com.bemos.data.remote.retrofit.city.mappers

import com.bemos.data.remote.retrofit.city.models.City
import com.bemos.data.remote.retrofit.city.models.Data
import com.bemos.domain.model.city_models.CityDomain
import com.bemos.domain.model.city_models.DataDomain

class CityMapper {

    fun toDomain(city: City) : CityDomain {
        return CityDomain(
            data = city.data.map {
                toDomain(it)
            }
        )
    }

    private fun toDomain(data: Data): DataDomain {
        return DataDomain(
            data.cities.map {
                toDomain(it)
            },
            data.country
        )
    }

    private fun toDomain(cityText: String): String {
        return cityText
    }

    //-------------------------------------------------

    fun toCity(cityDomain: CityDomain) : City {
        return City(
            data = cityDomain.data.map {
                toCity(it)
            }
        )
    }

    private fun toCity(dataDomain: DataDomain): Data {
        return Data(
            dataDomain.cities.map {
                toCity(it)
            },
            dataDomain.country
        )
    }

    private fun toCity(cityText: String): String {
        return cityText
    }

}