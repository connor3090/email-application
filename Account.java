import java.util.ArrayList;
public class Account {
    public String accountName;
    public ArrayList<Email> inbox;
    public ArrayList<Email> sent;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public void addToInbox(Email e) {
        inbox.add(e);
    }

    public void addToSent(Email e) {
        sent.add(e);
    }

    public void viewInbox() {
        if (inbox.size() > 0) {
            System.out.print(inbox.get(1).toString());
        }
    }

    public void viewSent() {
        if (inbox.size() > 0) {
            System.out.print(sent.get(1).toString());
        }
    }
}