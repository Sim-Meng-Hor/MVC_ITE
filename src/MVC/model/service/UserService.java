package MVC.model.service;

import MVC.model.UserDao;
import MVC.model.dto.CreateUserDto;
import MVC.model.dto.UpdateRequestDto;
import MVC.model.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserDto createUserDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserByUuid(String uuid);
    UserResponseDto updateUserByUuid(String uuid, UpdateRequestDto updateRequestDto);
    int deleteUserByUuid(String uuid);

    List<UserResponseDto> searchUserByName(String name);
}
