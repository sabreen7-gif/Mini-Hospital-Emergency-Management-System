# Mini Hospital Emergency Management System

## Module
CIT300 - Data Structures and Algorithms

## Assignment
Individual Mid Assignment

## Description
A console-based Java application that simulates basic hospital patient and emergency management using four required data structures.

## Data Structures
1. **Binary Search Tree (BST)** - Patient records keyed by Patient ID.
   - Insert
   - Search
   - Delete
   - In-order traversal
2. **Queue** - Emergency waiting list using FIFO.
   - Enqueue
   - Dequeue
   - Display
   - Empty queue handling
3. **Stack** - Completed treatment history using LIFO.
   - Push
   - Pop
   - Display
   - Empty stack handling
4. **Singly Linked List** - Visit history for each patient.
   - Add visit
   - Remove visit
   - Search visit
   - Display visits

## Project Structure
```
MiniHospitalEmergencySystem/
├── src/
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   └── VisitLinkedList.java
└── README.md
```

## Compile and Run
From the project folder:

### Windows PowerShell / VS Code Terminal
```powershell
javac -d out src\*.java
java -cp out Main
```

### macOS / Linux
```bash
javac -d out src/*.java
java -cp out Main
```

## Recommended Git Commit History
- Created project structure
- Implemented patient BST insertion
- Added BST search and deletion
- Implemented emergency queue
- Implemented treatment stack
- Implemented patient visit linked list
- Added menu and input validation
- Added system testing
- Updated README documentation

## Student Details
Name: __________________________
Index Number: __________________

> Replace the placeholders with your own details and make sure you understand the code before the demonstration.
