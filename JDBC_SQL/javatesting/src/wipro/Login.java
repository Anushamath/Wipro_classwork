package wipro;
import java.util.Scanner;

public class Login {
	
	private String username;
    private String password;

    // Method to get user input
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();
        scanner.close();
    }

    // Method to validate login
    public boolean validateLogin(String username, String password) {
        return username.equals("admin") && password.equals("1234");
    }

    // Getter methods (used for testing)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
