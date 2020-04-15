import java.util.Scanner;

public class Device {

    public String[] lrInputs = {"login", "register"};
    public Account currentAccount;
    public Server server = new Server();
    public Scanner in = new Scanner(System.in);
    // Constructor
    public Device() {

    }

    // Returns true if the user logs into an account. Returns false otherwise
    public boolean loginOrRegister() {
        System.out.print("Enter either 'login' or 'register': ");
        String lrInput = in.nextLine();
        while(!validateInput(lrInput, this.lrInputs)) {
            System.out.print("Please enter either 'login' or 'register': ");
            lrInput = in.nextLine();
        }

        if (lrInput.equals("register")) {
            registerAccount();
            
        }
        else {
            login();
            return true;
        }
        return false;
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

    // Logs the user into their account by setting the currentAccount variable to the users account
    public boolean login() {
        System.out.print("Please enter your account name: ");
        String accountName = in.nextLine();
        
        while(!server.validateAccountName(accountName)) {
            if (accountName.equals("quit")) {
                return false;
            }
            System.out.print("Invalid account name. Please enter your account name: ");
            accountName = in.nextLine();
        }

        System.out.print("Please enter your password: ");
        String password = in.nextLine();
        Account log = server.login(accountName, password);
        while (log == null) {
            if (password.equals("quit")) {
                return false;
            }
            System.out.print("Please enter your password");
            password = in.nextLine();
            log = server.login(accountName, password);
        }
        this.currentAccount = log;
        System.out.println("Successfully logged into account " + accountName);
        return true;

    }
}