package ui;

import data.Doctor;
import data.Practice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
public class Console
{
    public static void main(String[] args)
    {
        Practice greenwichPractice = new Practice();
        greenwichPractice.setName("Greenwich Practice");
        greenwichPractice.setTelephone("01758493741");

        Doctor doctor = new Doctor("John", "Smith");
        Calendar calendar = new GregorianCalendar();
        calendar.set(1960, 1, 1);
        doctor.setDateOfBirth(calendar.getTime());

        Doctor doctor1 = new Doctor("Mary", "Smith");
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(1980, 1, 1);
        doctor1.setDateOfBirth(calendar1.getTime());

        greenwichPractice.addDoctor(doctor);
        greenwichPractice.addDoctor(doctor1);

        ArrayList<Doctor> doctors = greenwichPractice.getDoctorsOlderByAge(20);
        System.out.print(doctors);
        System.out.print(doctor.getAge());
        System.out.print(doctor1.getAge());
    }
}
