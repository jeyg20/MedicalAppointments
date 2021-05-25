package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;

    public Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del model.Doctor asignado es: " + name);
    }

    @Override
    public void showUserDate() {
        System.out.println("Hospital: Cruz roja");
        System.out.println("Departamento: Cardiologia");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    // Array list for creation of appointments
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return super.toString() + "Available Appointments \nDate: " + date + "\nTime: " + time;
        }
    }

}