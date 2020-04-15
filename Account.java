import java.util.ArrayList;
public class Account {
    public String accountName;
    public ArrayList<Email> inbox;
    public ArrayList<Email> sent;

    public Account(String accountName) {
        this.accountName = accountName;
    }
}