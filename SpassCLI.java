import java.util.Random;
import java.util.Scanner;

public class SpassCLI {

    
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        printBanner();

        while (isRunning) {
            System.out.println(CYAN + "\n=== MAIN MENU ===" + RESET);
            System.out.println("1. Validate Password Strength");
            System.out.println("2. Generate Secure Password");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            try {
                
                String input = scanner.nextLine(); 
                int choice = Integer.parseInt(input); 

                if (choice == 1) {
                    System.out.print("Enter password to check: ");
                    String password = scanner.nextLine();
                    checkStrength(password);

                } else if (choice == 2) {
                    System.out.print("Enter desired length (e.g., 12): ");
                    try {
                        int length = Integer.parseInt(scanner.nextLine());
                        String newPass = generatePassword(length);
                        System.out.println(GREEN + "GENERATED PASSWORD: " + RESET + newPass);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Error: Please enter a valid number for length." + RESET);
                    }

                } else if (choice == 3) {
                    isRunning = false;
                    System.out.println(PURPLE + "Au revoir!" + RESET);
                } else {
                    System.out.println(RED + "Invalid option. Please choose 1, 2, or 3." + RESET);
                }

            } catch (NumberFormatException e) {
                System.out.println(RED + "Error: Invalid input! Please enter a number." + RESET);
            }
        }
        scanner.close();
    }

    public static void printBanner() {
        String logo = """
              _____                      
             / ____|                     
            | (___  _ __   __ _ ___ ___  
             \\___ \\| '_ \\ / _` / __/ __| 
             ____) | |_) | (_| \\__ \\__ \\ 
            |_____/| .__/ \\__,_|___/___/ 
                   | |                   
                   |_|                   
        """;
        System.out.println(PURPLE + logo + RESET);
        System.out.println("   v2.0 - Colors");
    }

    public static String generatePassword(int length) {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    public static void checkStrength(String password) {
        if (password.length() < 8) {
            System.out.println(RED + "RESULT: Weak... (Too short)" + RESET);
            return;
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        if (hasUpper && hasDigit && hasSpecial) {
            System.out.println(GREEN + "RESULT: Strong Password!" + RESET);
        } else {
            System.out.println(RED + "RESULT: Weak Password..." + RESET);
            System.out.println(CYAN + "Tip: Use uppercase, numbers, and symbols." + RESET);
        }
    }
}