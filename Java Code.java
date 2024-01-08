import java.util.*;
public class Main {
    private static final String admin = "Prabhas";
    private static final String adminpass = "22501a4452";
    private static Voter current;
    private static final List<Voter> database = new ArrayList<>();

    static {
        Voter adm = new Voter("Prabhas", "22501a4452","Prabhas Reddy Puli");
        database.add(adm);
    }

    private static void printMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Vote");
        System.out.println("4. Voting Status");
        System.out.println("5. Quit");
        System.out.println("6. Admin Login");
        System.out.println("7: See Voters details");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice(Scanner scanner) {
        int choice = 0;
        try {
            choice = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Input must be a positive integer value.");
            scanner.next();
        }
        return choice;
    }

    private static void register(Scanner scanner) {
        System.out.println("Enter a username: ");
        String username = scanner.next();
        System.out.println("Enter a password: ");
        String password = scanner.next();
        System.out.println("Enter your name: ");
        String name = scanner.next();
        Voter newUser = new Voter(username, password, name);
        database.add(newUser);
        System.out.println("Registration completed successfully.");
    }

    private static void login(Scanner scanner) {
        if (current != null) {
            System.out.println("You are already logged in as " + current.getName());
            return;
        }
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        for (Voter u : database) {
            if (u.getUser().equals(username) && u.getPassword().equals(password)) {
                current = u;
                System.out.println("Logged in successfully as " + current.getName());
                return;
            }
        }
        System.out.println("Invalid details or you need to register first.");
    }
    private static void vote() {
        if (current == null) {
            System.out.println("You need to log in first");
            return;
        }
        if (current.voted())
            System.out.println("You have already voted");
        else {
            current.setIsvoted(true);
            System.out.println("Vote cast successfully");
        }
    }

    private static void checkVotingStatus() {
        if (current == null)
            System.out.println("You need to log in first");
        else if (current.voted())
            System.out.println("You have already voted");
        else
            System.out.println("You have not voted yet");
    }
    private static void AdminLogin(Scanner sc){
        System.out.println("Enter user ID: ");
        String u = sc.next();
        System.out.println("Enter password: ");
        String p = sc.next();
        if(u.equals(admin) && p.equals(adminpass))
        {
            System.out.println("you are logged in as Admin");
            current = database.get(0);
        }

    }
    public static void printdatabase(){
        if(current == database.get(0)) {
            for( Voter v : database){
                System.out.println("Voter Name: "+v.getName());
                System.out.println("Voter Id: "+v.getUser());
            }
            return;
        }
        else
            System.out.println("You Need to log in as Admin");
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getChoice(sc);

            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    vote();
                    break;
                case 4:
                    checkVotingStatus();
                    break;
                case 5:
                    System.out.println("Goodbye baby!");
                    System.exit(0);
                case 6:
                    AdminLogin(sc);
                    break;
                case 7:
                    printdatabase();
                    break;
                default:
                    System.out.println("Invalid input please choose a valid option");
            }
        }
    }
}

