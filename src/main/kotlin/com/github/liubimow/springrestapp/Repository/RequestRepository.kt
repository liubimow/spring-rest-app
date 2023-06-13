package com.github.liubimow.springrestapp.Repository;

import com.github.liubimow.springrestapp.DTO.Request
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestRepository : JpaRepository<Request, Long> {
}