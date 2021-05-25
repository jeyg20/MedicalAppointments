package ui;

import com.sun.xml.internal.ws.server.ServerRtException;
import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

	public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

	public static void showDoctorMenu() {
		int response = 0;
		do {
			System.out.println("\n\n");
			System.out.println("Doctor");
			System.out.println("Welcome " + UIMenu.doctorLogged.getName());
			System.out.println("1. Add available appointment");
			System.out.println("2. My schedule appointment");
			System.out.println("0. Logout");

			Scanner sc = new Scanner(System.in);
			response = Integer.parseInt(sc.nextLine());

			switch (response) {
				case 1:

					break;
				case 2:
					break;
				case 0:
					UIMenu.showMenu();
					break;
			}
		} while (response != 0);
	}

	private static void showAddAvailableAppointment() {
		int response = 0;
		do {
			System.out.println();
			System.out.println(":: Add available appointment");
			System.out.println(":: Select a Mont");
			System.out.println();

			for (int i = 0; i < 3; i++) {
				int j = i + 1;
				System.out.println(j + ". " + UIMenu.MONTHS[i]);
			}
			System.out.println("0. Return");

			Scanner sc = new Scanner(System.in);
			response = Integer.parseInt(sc.nextLine());

			if (response > 0 && response < 4) {
				// 1,2,3
				int monthSelected = response;
				System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected]);

				System.out.println("Insert the date available: [dd/mm/yyyy]");
				String date = sc.nextLine();

				System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
				int responseDate = Integer.valueOf(sc.nextLine());
				if (response == 2) continue;

				int responseTime = 0;
				String time = "";
				do {
					System.out.println("Insert the avalaible time for date: " + date + "[16:00]");
					time = sc.nextLine();
					System.out.println("Your time is: " + time + "\n1. Correct \n 2. Change time");
					responseTime = Integer.valueOf(sc.nextLine());

				} while (responseTime == 2);

				UIMenu.doctorLogged.addAvailableAppointment(date, time);
				checkDoctorAvailableAppointment(UIMenu.doctorLogged);

			} else if(response == 0) {
				showDoctorMenu();
			}
		} while (response != 0);
	}

	private static void checkDoctorAvailableAppointment(Doctor doctor) {
		if(doctor.getAvailableAppointments().size() > 0
			&& !doctorsAvailableAppointments.contains(doctor)) {
			doctorsAvailableAppointments.add(doctor);
		}
	}

}
