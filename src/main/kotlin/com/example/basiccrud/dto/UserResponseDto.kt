package com.example.basiccrud.dto

import com.example.basiccrud.model.User

data class UserResponseDto(
    val id: Long,
    val name: String,
    val email: String,
    val role: String,
    val sector: String
) {
    companion object {
        fun fromUser(user: User): UserResponseDto {
            return UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email,
                role = user.role,
                sector = user.sector
            )
        }
    }
}