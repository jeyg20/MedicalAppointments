package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public final static String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    userAuth(1);
                    break;
                case 2:
                    System.out.println("Patient");
                    response = 0;
                    userAuth(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }
    private static void userAuth(int userType) {
        // UserType = 1 : Doctor
        // UserType = 2 : Patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Carlos Herrera", "Herrera@email.com"));
        doctors.add(new Doctor("Rosa Maria", "Maria@email.com"));
        doctors.add(new Doctor("Hugo Contreras", "Contreras@email.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Jeison Guerrero", "jeisson.g8620@gmail.com"));
        patients.add(new Patient("Roberto Gomez", "gomez@gmail.com"));
        patients.add(new Patient("Carlos Sanchez", "Sanchez@gmail.com"));

        boolean correctEmail = false;
        do {
            System.out.println("Insert your email: ejemplo@ejemplo.com");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1) {
                for (Doctor d: doctors) {
                    if(d.getEmail().equals(email)) {
                        correctEmail = true;
                        // Get logged user date
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }

                }
            }
            if(userType == 2) {
                for (Patient p : patients) {
                    if(p.getEmail().endsWith(email)) {
                        correctEmail = true;
                        // Get logged user date
                        patientLogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }

        } while (!correctEmail);
    }
    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
