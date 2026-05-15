package MVC.model;

import java.util.List;

// repository or Dao
public class UserDao {
    public List<User> findAll(){
        return UserDatabase.users;
    }

    public int remove(User user){
        UserDatabase.users.remove(user);
        return 1;
    }

    public User update(User uu){
        User user = UserDatabase.users
                .stream()
                .filter(u -> u.getUuid().equals(uu.getUuid()))
                .findFirst().orElseThrow(() -> new RuntimeException("User is not found"));
        // update
        user.setName(uu.getName());
        user.setEmail(uu.getEmail());
        user.setPassword(uu.getPassword());
        user.setProfile(uu.getProfile());
        return user;
    }

    public User save(User user) {
        UserDatabase.users.add(user);
        return user;
    }
}
