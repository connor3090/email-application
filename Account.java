import java.util.ArrayList;
import java.util.Scanner;
public class Account {
    public String accountName;
    public ArrayList<Email> inbox = new ArrayList<Email>();
    public ArrayList<Email> sent = new ArrayList<Email>();
    public ArrayList<Email> drafts = new ArrayList<Email>();
    Scanner in = new Scanner(System.in);

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

    public void viewHeaders(ArrayList<Email> folder) {
        if (folder.size() > 0) {
            int count = 1;
            for (int i = folder.size()-1; i >= 0; i--) {
                System.out.print("\n--------------------\n");
                System.out.print(count + "\n");
                System.out.print(folder.get(i).getHeader());
                System.out.print("\n--------------------\n\n");
            }
        }
        else {
            System.out.println("Folder is empty.");
        }
    }

    public void viewInbox() {
        viewHeaders(inbox);
    }

    public void viewSent() {
        viewHeaders(sent);
    }

    public Email selectEmail(String folderName) {
        int input = 0;
        ArrayList<Email> folder = new ArrayList<Email>();
        switch(folderName) {
            case "inbox":
                folder = inbox;
                break;
            case "sent":
                folder = sent;
                break;
        }
        System.out.print("Please select an email by inputting the number: ");
        input = Integer.parseInt(in.nextLine());
        while (input > folder.size() || input <= 0) {
            System.out.print("Invalid input. Please select an email: ");
            input = Integer.parseInt(in.nextLine());
        }
        int select = folder.size() - input;
        Email e = folder.get(select);
        System.out.print(e);
        return e;

    }
}