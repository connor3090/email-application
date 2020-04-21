import java.util.Scanner;
public class Driver {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Device d = new Device();
        Boolean running = true;
        Boolean loggedIn = false;
        Boolean viewingInbox = false;
        Boolean viewingSent = false;
        String option = "";
        Email selectedEmail;

        while (running){
            System.out.print("Please enter an option (type 'help' for options): ");
            option = in.nextLine();

            switch(option) {
                case "help":
                    help("initial");
                    break;
                case "lr":
                    loggedIn = d.loginOrRegister();
                    
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            while (loggedIn) {
                System.out.print("Please enter an option (type 'help' for options): ");
                option = in.nextLine();

                switch(option) {
                    case "help":
                        help("loginPage");
                        break;
                    case "logout":
                        d.logout();
                        loggedIn = false;
                        break;
                    case "compose":
                        d.composeEmail();
                        break;
                    case "inbox":
                        viewingInbox = true;
                        d.viewInbox();
                        while (viewingInbox) {
                            System.out.print("You are currently viewing your inbox. Enter 'select' or 'quit': ");
                            option = in.nextLine();
                            switch(option) {
                                case "quit":
                                    viewingInbox = false;
                                    break;
                                case "select":
                                    selectedEmail = d.currentAccount.selectEmail("inbox");
                                    System.out.print("Enter either 'reply' or 'quit': ");
                                    option = in.nextLine();
                                    switch(option) {
                                        case ("reply"):
                                            d.reply(selectedEmail);
                                            break;
                                        case ("quit"):
                                            break;
                                        default:
                                            break;
                                    }

                            }
                        }
                        break;
                    case "sent":
                        d.viewSent();
                        break;
                    default:
                        System.out.print("Invalid option.");
                        

                }

            }

            
        }
    }

    public static void help(String stage) {
        switch (stage) {
            case "initial":
                System.out.println("Enter 'quit' to exit the application.");
                System.out.println("Enter 'lr' to login/register.");
                break;
            case "loginPage":
                System.out.println("Enter 'logout' to log out of your account.");
                System.out.println("Enter 'compose' to create an email.");
                System.out.println("Enter 'inbox' to view your inbox.");
                System.out.println("Enter 'sent' to view your sent folder.");
                break;
        }
        
    }
}   