import java.util.ArrayList;

public class Email {
    String author;
    ArrayList<String> recipients;
    ArrayList<String> cc;
    String subject;
    String content;

    public Email(String author, ArrayList<String> recipients, ArrayList<String> cc, String subject, String content) {
        this.author = author;
        this.recipients = recipients;
        this.cc = cc;
        this.subject = subject;
        this.content = content;
    }

    public String toString() {
        String out = "/n--------------------/n";
        out += "From: " + author + "\n";
        out += "Recipients: ";
        for (int i = 0; i < recipients.size(); i++) {
            out += recipients.get(i) + " ";
        }
        out += "\ncc: ";
        for (int i = 0; i < cc.size(); i++) {
            out += cc.get(i) + " ";
        }
        out += "\nSubject: " + subject;
        out += "\n\n" + content;
        out += "\n\n--------------------";
        return out;
    }
}