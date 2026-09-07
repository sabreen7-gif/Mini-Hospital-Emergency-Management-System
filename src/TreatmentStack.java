public class TreatmentStack {
    private static class StackNode {
        TreatmentRecord record;
        StackNode next;
        StackNode(TreatmentRecord record) { this.record = record; }
    }

    private StackNode top;

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (top == null) return null;
        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public boolean isEmpty() { return top == null; }

    public void display() {
        if (isEmpty()) {
            System.out.println("No completed treatment records available.");
            return;
        }
        System.out.println("\n--- Completed Treatment History (LIFO) ---");
        StackNode current = top;
        int number = 1;
        while (current != null) {
            System.out.println("\nRecord " + number);
            current.record.display();
            current = current.next;
            number++;
        }
    }
}
