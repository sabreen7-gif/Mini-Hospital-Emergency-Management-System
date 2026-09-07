import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        int choice;
        do {
            displayMenu();
            choice = readInt("Enter your choice: ");
            System.out.println();
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientBST.displayInOrder();
                case 5 -> addToEmergencyQueue();
                case 6 -> treatNextEmergencyPatient();
                case 7 -> emergencyQueue.display();
                case 8 -> addCompletedTreatment();
                case 9 -> removeLatestTreatment();
                case 10 -> treatmentStack.display();
                case 11 -> addPatientVisit();
                case 12 -> searchPatientVisit();
                case 13 -> removePatientVisit();
                case 14 -> displayPatientVisitHistory();
                case 0 -> System.out.println("Thank you. System closed successfully.");
                default -> System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1.  Register Patient");
        System.out.println("2.  Search Patient");
        System.out.println("3.  Delete Patient");
        System.out.println("4.  Display All Patients (BST In-order)");
        System.out.println("5.  Add Patient to Emergency Queue");
        System.out.println("6.  Treat Next Emergency Patient");
        System.out.println("7.  Display Emergency Queue");
        System.out.println("8.  Add Completed Treatment Record");
        System.out.println("9.  Remove Latest Treatment Record");
        System.out.println("10. Display Treatment History");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Remove Patient Visit");
        System.out.println("14. Display Patient Visit History");
        System.out.println("0.  Exit");
        System.out.println("-------------------------------------------");
    }

    private static void registerPatient() {
        int id = readInt("Enter Patient ID: ");
        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }
        String name = readNonEmpty("Enter Patient Name: ");
        int age = readInt("Enter Age: ");
        String contact = readNonEmpty("Enter Contact Number: ");
        String condition = readNonEmpty("Enter Medical Condition: ");
        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient registered successfully.");
    }

    private static void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("Patient found:");
            patient.display();
        }
    }

    private static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");
        if (patientBST.delete(id)) System.out.println("Patient deleted successfully.");
        else System.out.println("Patient not found.");
    }

    private static void addToEmergencyQueue() {
        int id = readInt("Enter registered Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found. Register the patient first.");
            return;
        }
        if (emergencyQueue.containsPatient(id)) {
            System.out.println("Patient is already waiting in the emergency queue.");
            return;
        }
        emergencyQueue.enqueue(patient);
        System.out.println(patient.getPatientName() + " added to the emergency queue.");
    }

    private static void treatNextEmergencyPatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient == null) {
            System.out.println("Emergency queue is empty. No patient to treat.");
        } else {
            System.out.println("Next patient selected for treatment:");
            patient.display();
        }
    }

    private static void addCompletedTreatment() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        String treatmentId = readNonEmpty("Enter Treatment ID: ");
        String doctor = readNonEmpty("Enter Doctor Name: ");
        String date = readNonEmpty("Enter Treatment Date (YYYY-MM-DD): ");
        String details = readNonEmpty("Enter Treatment Details: ");
        TreatmentRecord record = new TreatmentRecord(treatmentId, patientId,
                patient.getPatientName(), doctor, date, details);
        treatmentStack.push(record);
        System.out.println("Completed treatment record added successfully.");
    }

    private static void removeLatestTreatment() {
        TreatmentRecord record = treatmentStack.pop();
        if (record == null) {
            System.out.println("Treatment stack is empty.");
        } else {
            System.out.println("Most recently completed treatment removed:");
            record.display();
        }
    }

    private static void addPatientVisit() {
        Patient patient = getPatientFromInput();
        if (patient == null) return;
        String visitId = readNonEmpty("Enter Visit ID: ");
        String date = readNonEmpty("Enter Visit Date (YYYY-MM-DD): ");
        String doctor = readNonEmpty("Enter Doctor Name: ");
        String diagnosis = readNonEmpty("Enter Diagnosis: ");
        String treatment = readNonEmpty("Enter Treatment: ");
        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        if (patient.getVisitHistory().addVisit(visit))
            System.out.println("Visit added successfully.");
        else
            System.out.println("Visit ID already exists for this patient.");
    }

    private static void searchPatientVisit() {
        Patient patient = getPatientFromInput();
        if (patient == null) return;
        String visitId = readNonEmpty("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit == null) System.out.println("Visit not found.");
        else {
            System.out.println("Visit found:");
            visit.display();
        }
    }

    private static void removePatientVisit() {
        Patient patient = getPatientFromInput();
        if (patient == null) return;
        String visitId = readNonEmpty("Enter Visit ID to remove: ");
        if (patient.getVisitHistory().removeVisit(visitId))
            System.out.println("Visit removed successfully.");
        else
            System.out.println("Visit not found.");
    }

    private static void displayPatientVisitHistory() {
        Patient patient = getPatientFromInput();
        if (patient == null) return;
        System.out.println("Visit history for " + patient.getPatientName() + ":");
        patient.getVisitHistory().displayVisits();
    }

    private static Patient getPatientFromInput() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) System.out.println("Patient not found.");
        return patient;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("This field cannot be empty.");
        }
    }
}
