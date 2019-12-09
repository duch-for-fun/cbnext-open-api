package com.fx.cbnext

import org.springframework.stereotype.Service
import java.util.Date

@Service
class Service(private val repo: TodRepository) {

    fun getInitInfo(client: String?) = when (client) {
        null -> Info(false)
        "bob" -> Info(false, Date())
        else -> Info(true, Date(), "USD for $client")
    }

    fun getTods() = repo.findAll()

    fun getTod(id: Long) = repo.findById(id)

    fun saveTod(tod: Tod) = repo.save(tod)

    fun editTod(id: Long, tod: Tod) = repo.save(tod.copy(id = id))

    fun deleteTod(id: Long) = repo.deleteById(id)
}
