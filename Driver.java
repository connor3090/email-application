import java.util.Scanner;
public class Driver {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Device d = new Device();
        Boolean running = true;
        Boolean loggedIn = false;
        String option = "";

        while (running){
            System.out.print("Please enter an option (type 'help' for options): ");
            option = in.nextLine();

            switch(option) {
                case "help":
                    help("initial");
                    break;
                case "lr":
                    loggedIn = d.loginOrRegister();
                    loggedIn = true;
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    //System.out.println("Invalid option.");
            }

            while (loggedIn) {
                System.out.print("Please enter an option (type 'help' for options): ");
                option = in.nextLine();

                switch(option) {
                    case "help":
                        help("loginPage");
                        break;
                    case "logout":
                        loggedIn = false;
                        break;

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
                break;
        }
        
    }
}   