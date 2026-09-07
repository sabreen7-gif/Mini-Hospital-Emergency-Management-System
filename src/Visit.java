public class Visit {
    private String visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public Visit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getVisitId() { return visitId; }

    public void display() {
        System.out.println("Visit ID : " + visitId);
        System.out.println("Date     : " + visitDate);
        System.out.println("Doctor   : " + doctorName);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Treatment: " + treatment);
    }
}
