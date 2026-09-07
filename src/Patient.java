public class Patient {
    private int patientId;
    private String patientName;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private VisitLinkedList visitHistory;

    public Patient(int patientId, String patientName, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalCondition() { return medicalCondition; }
    public VisitLinkedList getVisitHistory() { return visitHistory; }

    public void display() {
        System.out.println("Patient ID       : " + patientId);
        System.out.println("Patient Name     : " + patientName);
        System.out.println("Age              : " + age);
        System.out.println("Contact Number   : " + contactNumber);
        System.out.println("Medical Condition: " + medicalCondition);
    }

    @Override
    public String toString() {
        return patientId + " - " + patientName + " (" + medicalCondition + ")";
    }
}
