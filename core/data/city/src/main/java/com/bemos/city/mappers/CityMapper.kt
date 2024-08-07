package com.bemos.city.mappers

import com.bemos.city.models.City
import com.bemos.city.models.Data
import com.bemos.domain.model.city_models.CityDomain

class CityMapper {

    fun toDomain(city: City) : CityDomain {
        return CityDomain(
            data = city.data.map {
                toDomain(it)
            }
        )
    }

    private fun toDomain(data: Data): com.bemos.domain.model.city_models.DataDomain {
        return com.bemos.domain.model.city_models.DataDomain(
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

    private fun toCity(dataDomain: com.bemos.domain.model.city_models.DataDomain): Data {
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