import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Device d = new Device();
        Scanner in = new Scanner(System.in);
        Boolean running = true;
        String option = "";
        while (running){
            System.out.print("Please enter an option (type 'help' for options): ");
            option = in.nextLine();
            switch(option) {
                case "help":
                    help("initial");
                    break;
                case "lr":
                    d.loginOrRegister();
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void help(String stage) {
        if (stage.equals("initial")) {
            System.out.println("Enter 'quit' to exit the application.");
            System.out.println("Enter 'lr' to logon/register.");
        }
    }
}   