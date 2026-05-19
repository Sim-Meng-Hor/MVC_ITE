package MVC.model.service;

import MVC.model.User;
import MVC.model.UserDao;
import MVC.model.dto.CreateUserDto;
import MVC.model.dto.UpdateRequestDto;
import MVC.model.dto.UserResponseDto;
import MVC.mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDao userDao = new UserDao();
    private final UserMapper userMapper = new UserMapper();

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        User user = UserMapper.fromCreateUserDto(createUserDto);
        User savedUser = userDao.save(user);
        UserResponseDto userResponseDto = UserMapper.fromUserToUserResponseDto(savedUser);
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userDao.findAll().stream()
                .map(UserMapper::fromUserToUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto getUserByUuid(String uuid) {
        return userDao.findAll().stream()
                .filter(user -> user.getUuid().equals(uuid))
                .map(UserMapper::fromUserToUserResponseDto)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with UUID " + uuid + " not found"));
    }

    @Override
    public UserResponseDto updateUserByUuid(String uuid, UpdateRequestDto updateRequestDto) {
        User user = userDao.findAll().stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst().get();
        user.setName(updateRequestDto.name());
        user.setEmail(updateRequestDto.email());
        user.setPassword(updateRequestDto.password());
        user.setProfile(updateRequestDto.profile());
        userDao.update(user);
        return UserMapper.fromUserToUserResponseDto(user);
    }

    @Override
    public int deleteUserByUuid(String uuid) {
        User user = userDao.findAll()
                .stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with UUID " + uuid + " not found"));
        userDao.remove(user);
        return 1;
    }

    @Override
    public List<UserResponseDto> searchUserByName(String name) {
        return userDao.findAll().stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::fromUserToUserResponseDto)
                .toList();
    }
}
