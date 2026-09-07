public class TreatmentRecord {
    private String treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatmentDate;
    private String treatmentDetails;

    public TreatmentRecord(String treatmentId, int patientId, String patientName,
                           String doctorName, String treatmentDate, String treatmentDetails) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatmentDate = treatmentDate;
        this.treatmentDetails = treatmentDetails;
    }

    public String getTreatmentId() { return treatmentId; }

    public void display() {
        System.out.println("Treatment ID     : " + treatmentId);
        System.out.println("Patient ID       : " + patientId);
        System.out.println("Patient Name     : " + patientName);
        System.out.println("Doctor Name      : " + doctorName);
        System.out.println("Treatment Date   : " + treatmentDate);
        System.out.println("Treatment Details: " + treatmentDetails);
    }
}
