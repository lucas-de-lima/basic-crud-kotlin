package com.example.basiccrud.service

import com.example.basiccrud.dto.ResetUserPasswordDto
import com.example.basiccrud.dto.UserResponseDto
import com.example.basiccrud.model.User
import org.springframework.stereotype.Service
import com.example.basiccrud.repository.UserRepository
import com.fasterxml.jackson.annotation.JsonIgnore

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserResponseDto> {
        val users: List<User> = userRepository.findAll()
        return users.map { user ->
            UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email,
                role = user.role,
                sector = user.sector
            )
        }
    }

    fun getUserById(id: Long): User {
       return userRepository.getReferenceById(id)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUserName(id: Long, newName: String): User {
        val existingUser: User = getUserById(id)
        existingUser.name = newName
        return userRepository.save(existingUser)
    }

    fun updateUserEmail(id: Long, newEmail: String): User {
        val existingUser: User = getUserById(id)
        existingUser.email = newEmail
        return userRepository.save(existingUser)
    }

    fun updateUserRole(id: Long, newRole: String): User {
        val existingUser: User = getUserById(id)
        existingUser.role = newRole
        return userRepository.save(existingUser)
    }

    fun updateUserPassword(id: Long, newPassword: String): User {
        val existingUser: User = getUserById(id)
        existingUser.password = newPassword
        return userRepository.save(existingUser)
    }

    fun updateUserSector(id: Long, newSector: String): User {
        val existingUser: User = getUserById(id)
        existingUser.sector = newSector
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
