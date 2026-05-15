package MVC.controller;

import MVC.model.dto.CreateUserDto;
import MVC.model.dto.UpdateRequestDto;
import MVC.model.dto.UserResponseDto;
import MVC.model.service.UserService;
import MVC.model.service.UserServiceImpl;
import MVC.util.APIResponseTemplate;

import java.time.LocalDate;
import java.util.List;

public class UserController {
    private final UserService userService = new UserServiceImpl();

    public APIResponseTemplate<UserResponseDto> createUser(CreateUserDto createUserDto) {
        return APIResponseTemplate.<UserResponseDto>builder()
                .status(201)
                .message("User created successfully")
                .data(userService.createUser(createUserDto))
                .timeStamp(LocalDate.now())
                .build();
    }

    public APIResponseTemplate<List<UserResponseDto>> getAllUsers() {
        return new APIResponseTemplate<>(
                200,
                "Get all users successfully",
                LocalDate.now(),
                userService.getAllUsers()
        );
    }

    public APIResponseTemplate<UserResponseDto> getUserByUuid(String uuid) {
        return APIResponseTemplate.<UserResponseDto>builder()
                .status(200)
                .message("Get user by uuid successfully")
                .data(userService.getUserByUuid(uuid))
                .timeStamp(LocalDate.now())
                .build();
    }

    public APIResponseTemplate<UserResponseDto> updateUserByUuid(String uuid, UpdateRequestDto updateRequestDto) {
        return APIResponseTemplate.<UserResponseDto>builder()
                .status(200)
                .message("Update user successfully")
                .data(userService.updateUserByUuid(uuid, updateRequestDto))
                .timeStamp(LocalDate.now())
                .build();
    }

    public APIResponseTemplate<Integer> deleteUserByUuid(String uuid) {
        return APIResponseTemplate.<Integer>builder()
                .status(200)
                .message("Delete user successfully")
                .data(userService.deleteUserByUuid(uuid))
                .timeStamp(LocalDate.now())
                .build();
    }

    public APIResponseTemplate<List<UserResponseDto>> searchUserByName(String name) {
        return APIResponseTemplate.<List<UserResponseDto>>builder()
                .status(200)
                .message("Search user successfully")
                .data(userService.searchUserByName(name))
                .timeStamp(LocalDate.now())
                .build();
    }
}
