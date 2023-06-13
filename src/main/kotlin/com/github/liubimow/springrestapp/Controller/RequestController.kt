package com.github.liubimow.springrestapp.Controller

import com.github.liubimow.springrestapp.DTO.Request
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.github.liubimow.springrestapp.Service.Producer
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired


@RestController
@RequestMapping("/main")
class RequestController() {
    @Autowired
    private lateinit var kafkaProducer: Producer

    @PostMapping("/new")
    fun publish(@Valid @RequestBody request: Request): ResponseEntity<String> {
        val text = "Hello ${request.name}!" +
                "\nRequest completed successfully! Have a good day :)"
        kafkaProducer.sendMessage(request)
        return ResponseEntity.ok(text)
    }

}
