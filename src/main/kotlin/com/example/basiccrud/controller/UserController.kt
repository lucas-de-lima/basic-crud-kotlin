package com.example.basiccrud.controller

import com.example.basiccrud.dto.ResetUserPasswordDto
import com.example.basiccrud.dto.UserResponseDto
import com.example.basiccrud.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.basiccrud.service.UserService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
) {

    @GetMapping
    fun getAllUsers(): List<UserResponseDto> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user: User = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser: User = userService.createUser(user)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/reset/password/{id}")
    fun updatePassword(@PathVariable id: Long, @RequestBody resetPassword: ResetUserPasswordDto): ResponseEntity<Void> {
        userService.updatePassword(id, resetPassword)
        return ResponseEntity.ok().build()
    }

    @PatchMapping("/{id}/update-name")
    fun updateUserName(@PathVariable id: Long, @RequestParam newName: String): ResponseEntity<UserResponseDto> {
        val updatedUser = userService.updateUserName(id, newName)
        val responseDto = UserResponseDto.fromUser(updatedUser)
        return ResponseEntity.ok(responseDto)
    }

    @PatchMapping("/{id}/update-email")
    fun updateUserEmail(@PathVariable id: Long, @RequestParam newEmail: String): ResponseEntity<UserResponseDto> {
        val updatedUser = userService.updateUserEmail(id, newEmail)
        val responseDto = UserResponseDto.fromUser(updatedUser)
        return ResponseEntity.ok(responseDto)
    }

    @PatchMapping("/{id}/update-role")
    fun updateUserRole(@PathVariable id: Long, @RequestParam newRole: String): ResponseEntity<UserResponseDto> {
        val updatedUser = userService.updateUserRole(id, newRole)
        val responseDto = UserResponseDto.fromUser(updatedUser)
        return ResponseEntity.ok(responseDto)
    }

    @PatchMapping("/{id}/update-password")
    fun updateUserPassword(@PathVariable id: Long, @RequestParam newPassword: String): ResponseEntity<UserResponseDto> {
        val updatedUser = userService.updateUserPassword(id, newPassword)
        val responseDto = UserResponseDto.fromUser(updatedUser)
        return ResponseEntity.ok(responseDto)
    }

    @PatchMapping("/{id}/update-sector")
    fun updateUserSector(@PathVariable id: Long, @RequestParam newSector: String): ResponseEntity<UserResponseDto> {
        val updatedUser = userService.updateUserSector(id, newSector)
        val responseDto = UserResponseDto.fromUser(updatedUser)
        return ResponseEntity.ok(responseDto)
    }

}
