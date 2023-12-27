package com.example.basiccrud.service

import com.example.basiccrud.dto.ResetUserPasswordDto
import com.example.basiccrud.model.User
import org.springframework.stereotype.Service
import com.example.basiccrud.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): User {
        return userRepository.getReferenceById(id)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUser(id: Long, user: User): User {
        val existingUser: User = getUserById(id)

        existingUser.apply {
            name = user.name
            email = user.email
            role = user.role
            sector = user.sector
        }

        return userRepository.save(existingUser)
    }

    fun updatePassword(id: Long, resetPassword: ResetUserPasswordDto) {
        val existingUser: User = getUserById(id)
        existingUser.apply { password = resetPassword.newPassword }
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
