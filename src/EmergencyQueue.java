public class EmergencyQueue {
    private static class QueueNode {
        Patient patient;
        QueueNode next;
        QueueNode(Patient patient) { this.patient = patient; }
    }

    private QueueNode front;
    private QueueNode rear;

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Patient dequeue() {
        if (front == null) return null;
        Patient patient = front.patient;
        front = front.next;
        if (front == null) rear = null;
        return patient;
    }

    public boolean isEmpty() { return front == null; }

    public boolean containsPatient(int patientId) {
        QueueNode current = front;
        while (current != null) {
            if (current.patient.getPatientId() == patientId) return true;
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patients are waiting in the emergency queue.");
            return;
        }
        System.out.println("\n--- Emergency Waiting Queue (FIFO) ---");
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            position++;
            current = current.next;
        }
    }
}
