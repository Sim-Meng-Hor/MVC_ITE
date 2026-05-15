package MVC.mapper;

import MVC.model.User;
import MVC.model.dto.CreateUserDto;
import MVC.model.dto.UserResponseDto;

import java.util.Random;
import java.util.UUID;

public class UserMapper {
    public static User fromCreateUserDto(CreateUserDto createUserDto) {
        return new User(
                new Random().nextInt(99999),
                UUID.randomUUID().toString(),
                createUserDto.name(),
                createUserDto.email(),
                createUserDto.password(),
                "https://imgs.search.brave.com/6SPSSe4iDQnMe-xsfwucKoWBvQVkJTW8pwMH1RafOkY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMudmVjdGVlenku/Y29tL3N5c3RlbS9y/ZXNvdXJjZXMvdGh1/bWJuYWlscy8wNTMv/OTA0Lzk1Ni9zbWFs/bC9hLWdob3N0LXdp/dGgtYS1oYW5naW5n/LXdoaXRlLXNoZWV0/LWFuZC1ibGFjay1m/ZWF0dXJlcy1zdGFu/ZHMtaW4tYS1kYXJr/ZW5lZC1hcmVhLWNy/ZWF0aW5nLWEtc3Bv/b2t5LWFtYmlhbmNl/LXBob3RvLmpwZw"
        );
    }

    public static UserResponseDto fromUserToUserResponseDto(User user) {
        return new UserResponseDto(
                user.getUuid(),
                user.getName(),
                user.getEmail(),
                user.getProfile()
        );
    }
}
