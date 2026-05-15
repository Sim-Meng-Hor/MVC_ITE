package MVC;

import MVC.controller.UserController;
import MVC.model.dto.CreateUserDto;
import MVC.model.dto.UpdateRequestDto;
import MVC.model.dto.UserResponseDto;
import MVC.viewUtil.InputUtil;
import MVC.viewUtil.ViewUtil;

import java.util.List;

public class Main {
    private static final UserController userController = new UserController();

    private static void createUser() {
        try {
            String name = InputUtil.getString("Enter name");
            String email = InputUtil.getString("Enter email");
            String password = InputUtil.getString("Enter password");
            CreateUserDto createUserDto = new CreateUserDto(name, email, password);
            UserResponseDto response = userController.createUser(createUserDto).data();
            ViewUtil.displayMessage("User created successfully!");
            ViewUtil.displayUser(response);
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    private static void getAllUsers() {
        try {
            List<UserResponseDto> users = userController.getAllUsers().data();
            ViewUtil.displayUsers(users);
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    private static void getUserByUuid() {
        String uuid = InputUtil.getString("Enter user UUID");
        try {
            UserResponseDto user = userController.getUserByUuid(uuid).data();
            ViewUtil.displayUser(user);
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    private static void updateUser() {
        String uuid = InputUtil.getString("Enter user UUID to update");
        try {
            // First check if user exists
            userController.getUserByUuid(uuid);

            String name = InputUtil.getString("Enter new name");
            String email = InputUtil.getString("Enter new email");
            String password = InputUtil.getString("Enter new password");
            String profile = InputUtil.getString("Enter new profile URL");

            UpdateRequestDto updateRequestDto = new UpdateRequestDto(name, email, password, profile);
            UserResponseDto response = userController.updateUserByUuid(uuid, updateRequestDto).data();
            ViewUtil.displayMessage("User updated successfully!");
            ViewUtil.displayUser(response);
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    private static void deleteUser() {
        String uuid = InputUtil.getString("Enter user UUID to delete");
        try {
            userController.deleteUserByUuid(uuid);
            ViewUtil.displayMessage("User deleted successfully!");
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    private static void searchUser() {
        try {
            String name = InputUtil.getString("Enter name to search");
            List<UserResponseDto> users = userController.searchUserByName(name).data();
            ViewUtil.displayUsers(users);
        } catch (Exception e) {
            ViewUtil.displayError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            ViewUtil.displayMenu();
            int choice = InputUtil.getInt("Choose an option  ");

            switch (choice) {
                case 1 -> createUser();
                case 2 -> getAllUsers();
                case 3 -> getUserByUuid();
                case 4 -> updateUser();
                case 5 -> deleteUser();
                case 6 -> searchUser();
                case 0 -> {
                    ViewUtil.displayMessage("Exiting application...");

                    System.exit(0);
                }
                default -> ViewUtil.displayError("Invalid option. Try again.");
            }
        }
    }
}
