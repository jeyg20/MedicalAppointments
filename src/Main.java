import model.Doctor;
import model.Nurse;
import model.Patient;
import model.User;

import javax.print.Doc;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Doctor myDoctor = new Doctor("Anahí Salgado", "Pediatria");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");


        User user = new Patient("Jeison", "jeisson.g8620@gmail.com");
        user.showUserDate();

        /*
            To instantiate and abstract class without using its child classes.
            we can create and anonym class:
            This instance will only exists once.
         */
        User user1 = new User("Raul", "rrejs@fdsf.com") {
            @Override
            public void showUserDate() {
                System.out.println("Doctor temporal");
            }
        };

        /*
        for (Doctor.AvailableAppointment availableAppointment: myDoctor.getAvailableAppointments()) {
            System.out.println(availableAppointment.getDate() + " " + availableAppointment.getTime());
        }


        System.out.println();
        System.out.println();
        Patient patient = new Patient("Alejandra", "alejandra@mail.com");
        Patient patient2 = new Patient("Anahi", "anahi@mail.com");

        System.out.println(patient.toString());
        */
    }


}
