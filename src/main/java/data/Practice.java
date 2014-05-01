package data;

import java.util.ArrayList;

/**
 * Created by Natasha Whitter on 01/05/2014.
 */
public class Practice
{
    private int id;
    private String name;
    private String telephone;
    private ArrayList<Doctor> employedDoctors = new ArrayList<Doctor>();
    private static int addId = 0;

    public Practice()
    {
        this.id = addId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ArrayList<Doctor> getEmployedDoctors() {
        return employedDoctors;
    }

    public void removeDoctor(Doctor doctor)
    {
            if (employedDoctors.contains(doctor))
            {
                employedDoctors.remove(doctor);
            }
    }

    public void addDoctor(Doctor doctor)
    {
        if (!employedDoctors.contains(doctor))
        {
            employedDoctors.add(doctor);
        }
    }
}
