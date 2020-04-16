import java.util.ArrayList;
public class Account {
    public String accountName;
    public ArrayList<Email> inbox = new ArrayList<Email>();
    public ArrayList<Email> sent = new ArrayList<Email>();
    public ArrayList<Email> drafts = new ArrayList<Email>();

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public void addToInbox(Email e) {
        inbox.add(e);
    }

    public void addToSent(Email e) {
        sent.add(e);
    }

    public void addToDrafts(Email e) {
        drafts.add(e);
    }

    public void viewInbox() {
        if (inbox.size() > 0) {
            System.out.print(inbox.get(0).toString());
        }
    }

    public void viewSent() {
        if (sent.size() > 0) {
            System.out.print(sent.get(0));
        }
    }
}