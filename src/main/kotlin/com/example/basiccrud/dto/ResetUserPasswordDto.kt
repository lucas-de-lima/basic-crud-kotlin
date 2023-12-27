package com.example.basiccrud.dto

import com.example.basiccrud.interfaces.ResetPasswordInterface

data class ResetUserPasswordDto(
    val email: String,
    val newPassword: String
) : ResetPasswordInterface
