import data.Doctor;
import data.Practice;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class AlgebraicTests
{
    @Test
    public void testAddDoctorId(int id)
    {
        Doctor doctor = new Doctor("John", "Whitter");
        doctor.setId(id);

        assertEquals(id, doctor.getId());
    }

    @Test
    public void testGetDoctorMoreThanAge(int age)
    {
        Practice practice = new Practice();

        Doctor doctor = new Doctor("John", "Smith");
        Calendar calendar = new GregorianCalendar();
        calendar.set(1960, 1, 1); // 54
        doctor.setDateOfBirth(calendar.getTime());

        Doctor doctor1 = new Doctor("Mary", "Smith");
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(1980, 1, 1); // 34
        doctor1.setDateOfBirth(calendar1.getTime());

        practice.addDoctor(doctor);
        practice.addDoctor(doctor1);

        if (age < 34) {
            assertEquals(2, practice.getDoctorsOlderByAge(age).size());
        }
        else if (age >= 34 && age < 54) {
            assertEquals(1, practice.getDoctorsOlderByAge(age).size());
        }
        else if (age > 54) {
            assertEquals(0, practice.getDoctorsOlderByAge(age).size());
        }
    }

    @Test
    public void testGetDoctorLessThanAge(int age)
    {
        Practice practice = new Practice();

        Doctor doctor = new Doctor("John", "Smith");
        Calendar calendar = new GregorianCalendar();
        calendar.set(1960, 1, 1); // 54
        doctor.setDateOfBirth(calendar.getTime());

        Doctor doctor1 = new Doctor("Mary", "Smith");
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(1980, 1, 1); // 34
        doctor1.setDateOfBirth(calendar1.getTime());

        practice.addDoctor(doctor);
        practice.addDoctor(doctor1);

        if (age <= 34) {
            assertEquals(0, practice.getDoctorsYoungerByAge(age).size());
        }
        else if (age > 34 && age < 54) {
            assertEquals(1, practice.getDoctorsYoungerByAge(age).size());
        }
        else if (age > 54) {
            assertEquals(2, practice.getDoctorsYoungerByAge(age).size());
        }
    }

}
