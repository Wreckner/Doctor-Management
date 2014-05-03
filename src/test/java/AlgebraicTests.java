import data.Doctor;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class AlgebraicTests
{
    @Test
    public void testAddDoctorDetails(int id)
    {
        Doctor doctor = new Doctor("John", "Whitter");
        doctor.setId(id);

        assertEquals(id, doctor.getId());
    }
}
