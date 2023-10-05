package ma.youcode.Views;

import ma.youcode.Controllers.EntrepriseController;

import java.util.Scanner;

import static ma.youcode.Controllers.EntrepriseController.view;

public class EntrepriseView {

    private Scanner scanner;

    public EntrepriseView() {
        scanner = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }


    public static void displayEntrepriseOptions() {
        while (true) {
            view.displayMessage("Options:");
            view.displayMessage("1. Add Employee");
            view.displayMessage("2. Modify Employee");
            view.displayMessage("3. Delete Employee");
            view.displayMessage("4. Monthly check-ins");
            view.displayMessage("5. Exit");

            String choice = view.getInput("Enter your choice: ");
            switch (choice) {
                case "1":
                    EntrepriseController.addEmployeeOption();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    view.displayMessage("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Invalid choice.");
            }
        }
    }
}
