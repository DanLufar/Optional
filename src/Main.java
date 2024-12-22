import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        int searchId = 4;
        Optional<User> userById = repository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("Found user for ID: " + user),
                () -> System.out.println("User for ID " + searchId + " not found.")
        );

        String searchEmail = "11111@gmail.com";
        Optional<User> userByEmail = repository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Found user for email: " + user),
                () -> System.out.println("User for email " + searchEmail + " not found.")
        );

        Optional<List<User>> allUsers = repository.getAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    System.out.println("Total number of users: " + users.size());
                    users.forEach(System.out::println);
                },
                () -> System.out.println("This user list is empty.")
        );
    }
}

