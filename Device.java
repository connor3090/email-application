import java.util.Scanner;

public class Device {

    public String[] lrInputs = {"login", "register"};
    public String currentAccount = "";
    public Server server = new Server();
    // Constructor
    public Device() {

    }

    public void loginOrRegister() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter either 'login' or 'register': ");
        String lrInput = in.nextLine();
        while(!validateInput(lrInput, this.lrInputs)) {
            System.out.print("Please enter either 'login' or 'register': ");
            lrInput = in.nextLine();
        }

        if (lrInput.equals("register")) {
            registerAccount();
        }

    }

    // Takes an input string and returns true if that string is in the validInputs array, returns false if not
    public boolean validateInput(String input, String[] validInputs) {
        for (int i = 0; i < validInputs.length; i++) {
            if (input.equals(validInputs[i])) {
                return true;
            }
        }
        return false;
    }

    // Registers a new account to the server
    public boolean registerAccount() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your desired account name: ");
        String newAccountName = in.nextLine();
        while (server.validateAccountName(newAccountName)) {
            System.out.print("Account already exists. Please enter a new account name: ");
            newAccountName = in.nextLine();
        }
        System.out.print("Enter a new password: ");
        String newPassword = in.nextLine();
        System.out.print("Please enter it again to confirm your password: ");
        String confirmPassword = in.nextLine();
        while(!newPassword.equals(confirmPassword)) {
            System.out.print("Password confirmation failed. Please enter a new password: ");
            newPassword = in.nextLine();
            System.out.print("Please enter it again to confirm your password: ");
            confirmPassword = in.nextLine();
        }
        this.server.register(newAccountName, newPassword);
        System.out.println("Successfully registered new account");
        return true;
    }
}