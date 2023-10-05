package ma.youcode.Controllers;

import ma.youcode.Models.Entreprise;

import ma.youcode.Repositories.AgentRepo;
import ma.youcode.Repositories.EntrepriseRepo;

import ma.youcode.Views.AgentView;
import ma.youcode.Views.EntrepriseView;

import java.sql.Connection;



public class EntrepriseController {
    private static EntrepriseRepo model;

    public static EntrepriseView view;


    private Connection connection;

    public EntrepriseController(Connection connection) {
        this.connection = connection;
        model = new EntrepriseRepo();
        view = new EntrepriseView();
    }



    public void run() {
        view.displayMessage("Welcome to the Entreprise Console");

        boolean loggedIn = false;
        int failedLoginAttempts = 0; // Counter for failed login attempts

        while (!loggedIn && failedLoginAttempts < 3) {
            String name = view.getInput("Enter Entreprise Name: ");
            String password = view.getInput("Enter password: ");

            Entreprise entreprise = new Entreprise(0, name, password); // Create an Entreprise object

            if (model.isValidEntreprise(entreprise)) {
                loggedIn = true;
                view.displayMessage("Logged in as Entreprise.");
                EntrepriseView.displayEntrepriseOptions();
            } else {
                view.displayMessage("Invalid credentials. Please try again.");
                failedLoginAttempts++;
            }
        }
    }



    public static void addEmployeeOption() {
        String employeeName = view.getInput("Enter Employee Name: ");
        String employeePassword = view.getInput("Enter Employee Password: ");

        if (model.addEmployee(employeeName, employeePassword)) {
            view.displayMessage("Employee added successfully.");
        } else {
            view.displayMessage("Failed to add employee. Please try again.");
        }
    }


}
