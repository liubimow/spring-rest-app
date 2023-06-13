package com.github.liubimow.springrestapp.Operations

import com.github.liubimow.springrestapp.DTO.Request
import com.github.liubimow.springrestapp.Repository.RequestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SQLSaver {
    @Autowired
    private lateinit var repo: RequestRepository

    fun saveRequest(request: Request) {
        repo.save(request)
    }
}