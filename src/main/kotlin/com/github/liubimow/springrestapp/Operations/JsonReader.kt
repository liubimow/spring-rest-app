package com.github.liubimow.springrestapp.Operations

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JsonReader {
    fun readJson(json: Any): String {
        return ObjectMapper().writeValueAsString(json)
    }
}