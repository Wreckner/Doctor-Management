import data.Doctor;
import data.Practice;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Natasha Whitter on 01/05/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockTests
{
    private String testTitle = "Dr";
    private String testFirstName = "John";
    private String testSurname = "Smith";
    private Date testDate = new Date(126230400);
    private String testGender = "Male";
    private String testOffice = "C100";
    private String testName = "Greenwich Practice";
    private String testPhone = "01849647921";

    @Mock
    Doctor doctor;

    @Mock
    Practice practice;

    @Before
    public void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetDoctorFields()
    {
        assertEquals(doctor.getId(), 0);
        doctor.setTitle(testTitle);
        Mockito.verify(doctor).setTitle(testTitle);
        doctor.setFirstName(testFirstName);
        Mockito.verify(doctor).setFirstName(testFirstName);
        doctor.setSurname(testSurname);
        Mockito.verify(doctor).setSurname(testSurname);
        doctor.setDateOfBirth(testDate);
        Mockito.verify(doctor).setDateOfBirth(testDate);
        doctor.setGender(testGender);
        Mockito.verify(doctor).setGender(testGender);
        doctor.setOffice(testOffice);
        Mockito.verify(doctor).setOffice(testOffice);
    }

    @Test
    public void testSetPracticeFields()
    {
        assertEquals(practice.getId(), 0);
        practice.setName(testName);
        Mockito.verify(practice).setName(testName);
        Mockito.verify(practice).setName(Mockito.<Doctor>anyString());
        practice.setTelephone(testPhone);
        Mockito.verify(practice).setTelephone(testPhone);
        Mockito.verify(practice).setTelephone(Mockito.<Doctor>anyString());
        practice.addDoctor(doctor);
        Mockito.verify(practice).addDoctor(doctor);
        Mockito.verify(practice).addDoctor(Mockito.<Doctor>any());
        practice.removeDoctor(doctor);
        Mockito.verify(practice).removeDoctor(doctor);
        Mockito.verify(practice).removeDoctor(Mockito.<Doctor>any());
    }

    @Test
    public void testGetDoctors()
    {
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor(testFirstName, testSurname));
        doctors.add(new Doctor("Mary", "Smith"));
        doctors.add(new Doctor("Gary", "James"));

        Mockito.when(practice.getDoctors()).thenReturn(doctors);
        ArrayList<Doctor> employedDoctors = practice.getDoctors();
        Mockito.verify(practice).getDoctors();
        assertEquals(doctors, employedDoctors);

        assertEquals(doctors.get(0), practice.getDoctors().get(0));
        assertEquals(doctors.get(1), practice.getDoctors().get(1));
        assertEquals(doctors.get(2), practice.getDoctors().get(2));
    }

    @Test
    public void testGetDoctorFields()
    {
        Mockito.when(doctor.getId()).thenCallRealMethod();
        Mockito.when(doctor.getTitle()).thenReturn(testTitle);
        Mockito.when(doctor.getFirstName()).thenReturn(testFirstName);
        Mockito.when(doctor.getSurname()).thenReturn(testSurname);
        Mockito.when(doctor.getDateOfBirth()).thenReturn(testDate);
        Mockito.when(doctor.getGender()).thenReturn(testGender);
        Mockito.when(doctor.getOffice()).thenReturn(testOffice);
        Mockito.when(doctor.getAge()).thenReturn(44);

        assertEquals(doctor.getId(), 0);
        assertEquals(doctor.getTitle(), testTitle);
        assertEquals(doctor.getFirstName(), testFirstName);
        assertEquals(doctor.getSurname(), testSurname);
        assertEquals(doctor.getDateOfBirth(), testDate);
        assertEquals(doctor.getGender(), testGender);
        assertEquals(doctor.getOffice(), testOffice);
        assertEquals(doctor.getAge(), 44);

        Mockito.verify(doctor).getId();
        Mockito.verify(doctor).getTitle();
        Mockito.verify(doctor).getFirstName();
        Mockito.verify(doctor).getSurname();
        Mockito.verify(doctor).getDateOfBirth();
        Mockito.verify(doctor).getGender();
        Mockito.verify(doctor).getOffice();
        Mockito.verify(doctor).getAge();

    }

    @Test
    public void testGetPracticeFields()
    {
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor(testFirstName, testSurname));
        doctors.add(new Doctor("Mary", "Smith"));
        doctors.add(new Doctor("Gary", "James"));

        Mockito.when(practice.getId()).thenReturn(1);
        Mockito.when(practice.getName()).thenReturn(testName);
        Mockito.when(practice.getTelephone()).thenReturn(testPhone);
        Mockito.when(practice.getDoctors()).thenReturn(doctors);

        assertEquals(practice.getId(), 1);
        assertEquals(practice.getName(), testName);
        assertEquals(practice.getTelephone(), testPhone);
        assertEquals(practice.getDoctors(), doctors);

        Mockito.verify(practice).getId();
        Mockito.verify(practice).getName();
        Mockito.verify(practice).getTelephone();
        Mockito.verify(practice).getDoctors();
    }
}
