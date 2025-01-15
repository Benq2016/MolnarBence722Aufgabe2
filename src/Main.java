package src;

import src.Domain.*;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Controller controller = new Controller();

    public void UI() {
        System.out.println("Welcome! Please choose an option:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    0-Exit
                    1-Create Medkament
                    2-Remove Medikament
                    3-Update Medikament
                    4-Get Medikament
                    5-Get All Medikamente
                    6-Create Patient
                    7-Remove Patient
                    8-Update Patient
                    9-Get Patienten
                    10-Get All Patienten
                    11-Filter Patienten nach Diagnose
                    """);
            String input = scanner.nextLine();
            switch (input) {
                case "0": {
                    System.out.println("Goodbye!");
                    return;
                }
                case "1": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the price:");
                    String price = scanner.nextLine();
                    System.out.println("Please enter the krankheit:");
                    String krankheit = scanner.nextLine();
                    controller.createMedicament(Integer.parseInt(id), name, Integer.parseInt(price), krankheit);
                    break;
                }
                case "2": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    controller.removeMedicament(Integer.parseInt(id));
                    break;
                }
                case "3": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the price:");
                    String price = scanner.nextLine();
                    System.out.println("Please enter the krankheit:");
                    String krankheit = scanner.nextLine();
                    controller.updateMedicament(Integer.parseInt(id), name, Integer.parseInt(price), krankheit);
                    break;
                }
                case "4": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    Medikamente medikamente = controller.getMedicament(Integer.parseInt(id));
                    if (medikamente != null)
                        System.out.println(medikamente);
                    else
                        System.out.println("No Medikamente with this ID found!");
                    break;
                }
                case "5": {
                    controller.getAllMedicaments().forEach(System.out::println);
                    break;
                }
                case "6": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the age:");
                    String age = scanner.nextLine();
                    System.out.println("Please enter the diagnose:");
                    String diagnose = scanner.nextLine();
                    System.out.println("Please enter the the medicine-IP(0 to stop):");
                    controller.getAllMedicaments().forEach(System.out::println);
                    List<Medikamente> medicamente = new ArrayList<>();
                    String option = scanner.nextLine();
                    while (!option.equals("0")) {
                        medicamente.add(controller.getMedicament(Integer.parseInt(option)));
                        option = scanner.nextLine();
                    }
                    controller.createPatient(Integer.parseInt(id), name, Integer.parseInt(age), diagnose, medicamente);
                    break;
                }
                case "7": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    controller.removePatient(Integer.parseInt(id));
                    break;
                }
                case "8": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the age:");
                    String age = scanner.nextLine();
                    System.out.println("Please enter the diagnose:");
                    String diagnose = scanner.nextLine();
                    System.out.println("Please enter the the medicine-IP(0 to stop):");
                    controller.getAllMedicaments().forEach(System.out::println);
                    List<Medikamente> medicamente = new ArrayList<>();
                    String option = scanner.nextLine();
                    while (!option.equals("0")) {
                        medicamente.add(controller.getMedicament(Integer.parseInt(option)));
                        option = scanner.nextLine();
                    }
                    controller.updatePatient(Integer.parseInt(id), name, Integer.parseInt(id), diagnose, medicamente);
                    break;
                }
                case "9": {
                    System.out.println("Please enter the ID:");
                    String id = scanner.nextLine();
                    Patienten patienten = controller.getPatient(Integer.parseInt(id));
                    if (patienten != null)
                        System.out.println(patienten);
                    else
                        System.out.println("No Patienten with this ID found!");
                    break;
                }
                case "10": {
                    controller.getAllPatients().forEach(System.out::println);
                    break;
                }
                case "11": {
                    System.out.println("Please enter the diagnose:");
                    String diagnose = scanner.nextLine();
                    controller.filterDiagnose(diagnose).forEach(System.out::println);
                    break;
                }
                default: {
                    System.out.println("Invalid input!");
                }
            }
        }
    }


    public static void main(String[] args) {
        controller.createMedicament(1, "Nurofen", 20, "febra");
        controller.createMedicament(2, "Algocalmin", 26, "durer de cap");
        List<Medikamente> med1 = new ArrayList<>();
        med1.add(controller.getMedicament(1));
        List<Medikamente> med2 = new ArrayList<>();
        med2.add(controller.getMedicament(1));
        med2.add(controller.getMedicament(2));
        controller.createPatient(1, "bence", 20, "febra", med1);
        controller.createPatient(2, "balazs", 25, "durere de cap", med2);
        Main main = new Main();
        main.UI();
    }
}