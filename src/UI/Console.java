package UI;

import Domain.Eveniment;
//import Domain.Client;
//import Domain.Transaction;
import Service.EvenimentService;
//import Service.ClientService;
//import Service.TransactionService;

import java.util.Scanner;

public class Console {

    private EvenimentService evenimentService;
    private Scanner scanner;

    public Console(EvenimentService evenimentService) {
        this.evenimentService = evenimentService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Eveniment CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Transaction CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runCakeCrud();
                    break;
//                case "2":
//                    runClientCrud();
//                    break;
//                case "3":
//                    runTransactionCrud();
//                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }


    private void runCakeCrud() {
        while (true) {
            System.out.println("1. Add or update a cake");
            System.out.println("2. Remove a cake");
            System.out.println("3. View all cakes");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateCake();
                    break;
                case "2":
                    handleRemoveCake();
                    break;
                case "3":
                    handleViewCakes();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewCakes() {
        for (Eveniment eveniment : evenimentService.getAll()) {
            System.out.println(eveniment);
        }
    }

    private void handleRemoveCake() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            evenimentService.remove(id);

            System.out.println("Eveniment removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateCake() {

        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name (empty to not change for update): ");
            String name = scanner.nextLine();
            System.out.print("Enter ingredients (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter calories (0 to not change for update): ");
            String duration = scanner.nextLine();
            System.out.print("Enter calories (0 to not change for update): ");
            String startingTime = scanner.nextLine();
            System.out.print("Enter calories (0 to not change for update): ");


            evenimentService.addOrUpdate(id, name, date, duration, startingTime);

            System.out.println("Eveniment added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}
