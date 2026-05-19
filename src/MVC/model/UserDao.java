package MVC.model;

import MVC.util.DataConnectionConfigure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// repository or Dao
public class UserDao {
    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try(Connection connection = DataConnectionConfigure.getConnection()){
            Statement statement = connection.createStatement();
            boolean isExecuted = statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){;
                int id = resultSet.getInt("id");
                String uuid = resultSet.getString("uuid");
                String userName = resultSet.getString("user_name");
                String email  =resultSet.getString("email");
                String password = resultSet.getString("password");
                String profile  = resultSet.getString("profile");
                User user = new User(id,uuid,userName,email,password,profile);
                // add user object to list
                users.add(user);
            }
        }catch (Exception exception){
            System.out.println("Connection failed");
        }
        return users;
    }

    public int remove(User user){
        String sql = """
                DELETE FROM users
                WHERE uuid = ?
                """;
        try (Connection connection = DataConnectionConfigure.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUuid());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Delete user failed, no rows affected");
            }
            return rowsAffected;
        } catch (Exception exception) {
            throw new RuntimeException("Error during delete user: " + exception.getMessage(), exception);
        }
    }

    public User update(User uu){
        String sql  = """
                UPDATE users 
                SET user_name = ?, email = ?, password = ?, profile = ?
                WHERE uuid = ?
                """;
        try (Connection connection = DataConnectionConfigure.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uu.getName());
            preparedStatement.setString(2, uu.getEmail());
            preparedStatement.setString(3, uu.getPassword());
            preparedStatement.setString(4, uu.getProfile());
            preparedStatement.setString(5, uu.getUuid());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Update user failed, no rows affected");
            }
            return uu;
        } catch (Exception exception) {
            throw new RuntimeException("Error during update user: " + exception.getMessage(), exception);
        }
    }

    public User save(User user) {
        String sql = """
                INSERT  INTO users(uuid, user_name, email, password, profile)
                VALUES (?,?,?,?,?)
                """;
        try(Connection connection = DataConnectionConfigure.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUuid());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getProfile());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Insert user failed, no rows affected");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
            return user;
        }catch (Exception exception){
            throw new RuntimeException("Error during insert new user: " + exception.getMessage(), exception);
        }
    }
}
