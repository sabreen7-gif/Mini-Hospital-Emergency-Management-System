public class PatientBST {
    private static class Node {
        Patient patient;
        Node left;
        Node right;
        Node(Patient patient) { this.patient = patient; }
    }

    private Node root;

    public boolean insert(Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return true;
        }
        Node current = root;
        while (true) {
            if (patient.getPatientId() == current.patient.getPatientId()) return false;
            if (patient.getPatientId() < current.patient.getPatientId()) {
                if (current.left == null) {
                    current.left = new Node(patient);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(patient);
                    return true;
                }
                current = current.right;
            }
        }
    }

    public Patient search(int patientId) {
        Node current = root;
        while (current != null) {
            if (patientId == current.patient.getPatientId()) return current.patient;
            current = patientId < current.patient.getPatientId() ? current.left : current.right;
        }
        return null;
    }

    public boolean delete(int patientId) {
        if (search(patientId) == null) return false;
        root = deleteRecursive(root, patientId);
        return true;
    }

    private Node deleteRecursive(Node node, int patientId) {
        if (node == null) return null;
        if (patientId < node.patient.getPatientId()) {
            node.left = deleteRecursive(node.left, patientId);
        } else if (patientId > node.patient.getPatientId()) {
            node.right = deleteRecursive(node.right, patientId);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = minNode(node.right);
            node.patient = successor.patient;
            node.right = deleteRecursive(node.right, successor.patient.getPatientId());
        }
        return node;
    }

    private Node minNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        System.out.println("\n--- Patients in Ascending Patient ID Order ---");
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.patient);
        inOrder(node.right);
    }
}
