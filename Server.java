import java.util.HashMap;
import java.util.Map;

public class Server {
    public HashMap<String, String> loginInfo = new HashMap();

    // Constructor
    public Server() {

    }

    // Registers the user's account by storing their account name and password in the loginInfo hashmap. Will create an Account object for them as well
    public boolean register(String accountName, String password) {
        if (loginInfo.containsKey(accountName)) {
            System.out.println("Account already exists.");
            return false;
        }
        else {
            loginInfo.put(accountName, password);
            return true;
        }
    }

    // Logs the user into their account. Should return the account object when finished.
    public void login(String accountName, String password) {
        if (!this.loginInfo.containsKey(accountName)) { // If no account exists by that name
            System.out.println("Invalid Account Name");
        }
        else if (this.loginInfo.get(accountName).equals(password)) { // If the account exists and password is correct

        }
        else {
            System.out.println("Invalid Password");
        }
    }

    // Checks if the account name exists. Returns true if the account exists, false if not
    public boolean validateAccountName(String accountName) {
        return loginInfo.containsKey(accountName);
    } 
}