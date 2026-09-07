public class VisitLinkedList {
    private static class VisitNode {
        Visit visit;
        VisitNode next;
        VisitNode(Visit visit) { this.visit = visit; }
    }

    private VisitNode head;

    public boolean addVisit(Visit visit) {
        if (searchVisit(visit.getVisitId()) != null) return false;
        VisitNode newNode = new VisitNode(visit);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        return true;
    }

    public Visit searchVisit(String visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visit.getVisitId().equalsIgnoreCase(visitId)) return current.visit;
            current = current.next;
        }
        return null;
    }

    public boolean removeVisit(String visitId) {
        if (head == null) return false;
        if (head.visit.getVisitId().equalsIgnoreCase(visitId)) {
            head = head.next;
            return true;
        }
        VisitNode current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId().equalsIgnoreCase(visitId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() { return head == null; }

    public void displayVisits() {
        if (isEmpty()) {
            System.out.println("No visit history available for this patient.");
            return;
        }
        System.out.println("\n--- Patient Visit History ---");
        VisitNode current = head;
        int number = 1;
        while (current != null) {
            System.out.println("\nVisit " + number);
            current.visit.display();
            current = current.next;
            number++;
        }
    }
}
