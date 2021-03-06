import java.util.HashMap;

public class Server {
    public HashMap<String, String> loginInfo = new HashMap<String, String>();
    public HashMap<String, Account> accountInfo = new HashMap<String, Account>();


    // Constructor
    public Server() {

    }

    // Registers the user's account by storing their account name and password in the loginInfo hashmap. Will create an Account object for them as well
    public boolean register(String accountName, String password) {
        if (validateAccountName(accountName)) {
            System.out.println("Account already exists or is invalid.");
            return false;
        }
        else {
            loginInfo.put(accountName, password);
            Account newAccount = new Account(accountName);
            accountInfo.put(accountName, newAccount);
            return true;
        }
    }

    // Logs the user into their account. Returns the users account object.
    public Account login(String accountName, String password) {
        if (!this.loginInfo.containsKey(accountName)) { // If no account exists by that name
            System.out.println("Invalid Account Name");
            return null;
        }
        else if (this.loginInfo.get(accountName).equals(password)) { // If the account exists and password is correct
            return accountInfo.get(accountName);

        }
        else {
            System.out.println("Invalid Password");
            return null;
        }
    }

    // Logs user out of account
    public void logout(Account account) {
        accountInfo.replace(account.accountName, account);
    }

    // Checks if the account name exists. Returns true if the account exists, false if not
    public boolean validateAccountName(String accountName) {
        if (accountName == "quit") {
            return false;
        }
        return loginInfo.containsKey(accountName);
    } 

    // Adds the email to all recipients and cc inboxes
    public void sendEmail(Email e) {
        Account recipient;
        String accountName;
        for (int i = 0; i < e.recipients.size(); i++) {
            accountName = e.recipients.get(i);
            if (validateAccountName(accountName)) {
                recipient = accountInfo.get(accountName);
                recipient.addToInbox(e);
                accountInfo.replace(accountName, recipient);
            }
            
        }

        if (e.cc.size() > 0) {
            for (int i = 0; i < e.cc.size(); i++) {
                accountName = e.cc.get(i);
                if (validateAccountName(accountName)) {
                    recipient = accountInfo.get(accountName);
                    recipient.addToInbox(e);
                    accountInfo.replace(accountName, recipient);
                }
            }
        }
    }
}