import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public Optional<User> findUserById(int id) {
        return getData().stream()
                .filter(user -> user.getID() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return getData().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> getAllUsers() {
        List<User> users = getData();
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }

    List<User> getData() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Igor", "11111@gmail.com"));
        users.add(new User(2, "Oleg", "22222@gmail.com"));
        users.add(new User(3, "Mary", "33333@gmail.com"));
        users.add(new User(4, "Nika", "44444@gmail.com"));
        users.add(new User(5, "Ivan", "55555@gmail.com"));
        return users;
    }

}
