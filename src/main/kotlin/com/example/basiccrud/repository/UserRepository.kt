package com.example.basiccrud.repository

import com.example.basiccrud.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
