import data.Doctor;
import data.Practice;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Natasha Whitter on 01/05/2014.
 */
public class UnitTests
{
    Doctor doctor;
    private String testTitle = "Dr";
    private String testFirstName = "John";
    private String testSurname = "Smith";
    private Date testDate = new Date(126230400);
    private String testGender = "Male";
    private String testOffice = "C100";
    private String testName = "Greenwich Practice";
    private String testPhone = "01849647921";

    @Before
    public void setup() throws Exception
    {
        doctor = new Doctor(testFirstName, testSurname);
    }

    @Test
    public void testAddDoctor()
    {
        Practice practice = new Practice();

        practice.addDoctor(doctor);

        assertTrue(practice.getEmployedDoctors().contains(doctor));
        assertEquals(1, practice.getEmployedDoctors().size());
    }

    @Test
    public void testRemoveDoctor()
    {
        Practice practice = new Practice();

        practice.addDoctor(doctor);

        assertTrue(practice.getEmployedDoctors().contains(doctor));
        assertEquals(1, practice.getEmployedDoctors().size());

        practice.removeDoctor(doctor);

        assertTrue(!practice.getEmployedDoctors().contains(doctor));
        assertEquals(0, practice.getEmployedDoctors().size());
    }

    @Test
    public void testTryAddExistingDoctor()
    {
        Practice practice = new Practice();

        practice.addDoctor(doctor);

        assertTrue(practice.getEmployedDoctors().contains(doctor));
        assertEquals(1, practice.getEmployedDoctors().size());

        practice.addDoctor(doctor);

        assertEquals(1, practice.getEmployedDoctors().size());

    }

    @Test
    public void testTryRemoveNonExistingDoctor()
    {
        Practice practice = new Practice();

        practice.addDoctor(doctor);

        assertTrue(practice.getEmployedDoctors().contains(doctor));
        assertEquals(1, practice.getEmployedDoctors().size());

        practice.removeDoctor(doctor);

        assertTrue(!practice.getEmployedDoctors().contains(doctor));
        assertEquals(0, practice.getEmployedDoctors().size());

        practice.removeDoctor(doctor);

        assertTrue(!practice.getEmployedDoctors().contains(doctor));
        assertEquals(0, practice.getEmployedDoctors().size());
    }

    @Test
    public void testAddDoctorDetails()
    {
        Doctor doctor = new Doctor(testFirstName, testSurname);
        doctor.setTitle(testTitle);
        doctor.setFirstName(testFirstName);
        doctor.setSurname(testSurname);
        doctor.setDateOfBirth(testDate);
        doctor.setGender(testGender);
        doctor.setOffice(testOffice);

        assertEquals(testTitle, doctor.getTitle());
        assertEquals(testFirstName, doctor.getFirstName());
        assertEquals(testSurname, doctor.getSurname());
        assertEquals(testDate, doctor.getDateOfBirth());
        assertEquals(testGender, doctor.getGender());
        assertEquals(testOffice, doctor.getOffice());
    }

    @Test
    public void testAddPracticeDetails()
    {
        Practice practice = new Practice();
        practice.setName(testName);
        practice.setTelephone(testPhone);
        practice.addDoctor(doctor);

        ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList.add(doctor);

        assertEquals(testName, practice.getName());
        assertEquals(testPhone, practice.getTelephone());
        assertEquals(doctorList, practice.getEmployedDoctors());
    }

    @Test
    public void testCorrectDoctorAge()
    {
        doctor.setDateOfBirth(testDate);
        assertEquals(44, doctor.getAge());
    }

    @Test
    public void testNegativeDoctorAge()
    {
        doctor.setDateOfBirth(new GregorianCalendar().getTime());
        assertEquals(0, doctor.getAge());
    }
}
