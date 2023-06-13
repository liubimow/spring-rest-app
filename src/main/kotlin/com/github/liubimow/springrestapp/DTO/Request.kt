package com.github.liubimow.springrestapp.DTO

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.GeneratedValue
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "requests")
class Request (
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @NotBlank
    var name: String,
    @NotBlank
    var message: String
    ) {
    constructor() : this(0L, "", "") {}
}