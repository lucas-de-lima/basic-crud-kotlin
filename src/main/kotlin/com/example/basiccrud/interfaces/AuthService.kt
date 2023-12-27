package com.example.basiccrud.interfaces

import com.example.basiccrud.dto.LoginRequestDto
import com.example.basiccrud.dto.LoginResponseDto

interface AuthService {
    fun authenticate(loginRequest: LoginRequestDto): LoginResponseDto
}
