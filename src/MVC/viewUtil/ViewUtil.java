package MVC.viewUtil;

import MVC.model.dto.UserResponseDto;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class ViewUtil {

    public static void displayUsers(List<UserResponseDto> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        Table table = new Table(4, BorderStyle.UNICODE_DOUBLE_BOX, ShownBorders.ALL);
        table.addCell("UUID", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Email", new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("Profile", new CellStyle(CellStyle.HorizontalAlign.center));

        for (UserResponseDto user : users) {
            table.addCell(user.uuid());
            table.addCell(user.name());
            table.addCell(user.email());
            table.addCell(user.profile());
        }

        System.out.println(table.render());
    }

    public static void displayUser(UserResponseDto user) {
        System.out.println("----------------------------------------------------------");
        System.out.println("User Details:");
        System.out.println("UUID    : " + user.uuid());
        System.out.println("Name    : " + user.name());
        System.out.println("Email   : " + user.email());
        System.out.println("Profile : " + user.profile());
        System.out.println("----------------------------------------------------------");
    }

    public static void displayMessage(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void displayMenu() {
        System.out.println("\n========== USER MANAGEMENT SYSTEM ==========");
        System.out.println("1. Create User");
        System.out.println("2. Get All Users");
        System.out.println("3. Search User by UUID");
        System.out.println("4. Update User by UUID");
        System.out.println("5. Delete User by UUID");
        System.out.println("6. Search User by Name");
        System.out.println("0. Exit");
        System.out.println("============================================");
    }
}
