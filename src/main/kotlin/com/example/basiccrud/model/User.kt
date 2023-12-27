package com.example.basiccrud.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
    var name: String,
    var email: String,
    var password: String,
    var role: String,
    var sector: String
)
