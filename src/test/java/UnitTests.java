import data.Doctor;
import data.Practice;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Natasha Whitter on 01/05/2014.
 */
public class UnitTests
{
    @Before
    public void setup() throws Exception
    {

    }

    @Test
    public void testAddDoctor()
    {
        Doctor doctor = new Doctor("John", "Smith");
        Practice practice = new Practice();
        practice.addDoctor(doctor);
        assertTrue(practice.getEmployedDoctors().contains(doctor));
    }

    @Test
    public void testTryAddExistingDoctor()
    {
        Doctor doctor = new Doctor("John", "Smith");
        Practice practice = new Practice();
        practice.addDoctor(doctor);
        assertTrue(practice.getEmployedDoctors().contains(doctor));
        assertEquals(1, practice.getEmployedDoctors().size());
        practice.addDoctor(doctor);
        assertEquals(1, practice.getEmployedDoctors().size());

    }
}
