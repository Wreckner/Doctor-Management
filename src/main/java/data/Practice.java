package data;

import java.util.ArrayList;


/**
 * Created by Natasha Whitter on 01/05/2014.
 * @inv removeDoctor() implies employedDoctors.size() > 0
 * @inv addDoctor() implies employedDoctor.size() <= 0
 */
public class Practice
{
    private int id;
    private String name;
    private String telephone;
    private ArrayList<Doctor> employedDoctors = new ArrayList<Doctor>();
    private static int addId = 1;

    public Practice()
    {
        this.id = addId++;
    }

    public int getId() {
        assert this.id != 0 : "Id must not be null: value = " + id;
        return id;
    }

    public void setId(int id)
    {
        assert id != 0 : "Id must not be null: value = " + id;
        this.id = id;
    }

    public String getName() {
        assert this.name != null : "Name must not be null: value = " + name;
        return name;
    }

    public void setName(String name) {
        assert name != null : "Name must not be null: value = " + name;
        assert name.matches("^[a-zA-Z ]+$") : "Name must only contain letters: value = " + name;
        this.name = name;
    }

    public String getTelephone() {
        assert this.telephone != null : "Telephone must not be null: value = " + telephone;
        return telephone;
    }

    public void setTelephone(String telephone) {
        assert telephone != null : "Telephone must not be null: value = " + telephone;
        assert telephone.matches("^[0-9]+$") : "Telephone must only contain numbers: value = " + telephone;
        assert telephone.length() == 11 : "Telephone length must be 11: value = " + telephone.length();
        this.telephone = telephone;
    }

    public ArrayList<Doctor> getEmployedDoctors() {
        assert employedDoctors != null : "Doctor list must not be null: value = " + employedDoctors.toString();
        return employedDoctors;
    }

    /**
     * If the doctor passed is an employed doctor at the practice, the doctor will be removed from the list of
     * employed doctors, else the doctor won't be removed from the list as there not employed doctors
     *
     * @param doctor - the doctor to be removed from the list of employed doctors
     */
    public void removeDoctor(Doctor doctor)
    {
        //assert employedDoctors.contains(doctor) : "Doctor must be in the list: value = " + employedDoctors.toString();
        assert doctor != null : "Doctor must not be null: value = " + doctor;
            if (employedDoctors.contains(doctor))
            {
                employedDoctors.remove(doctor);
            }
        assert !employedDoctors.contains(doctor) : "Doctor shouldn't be in the list: value = " + employedDoctors.toString();
    }

    /**
     * If the doctor passed isn't an employed doctor at the practice, the doctor will be added to the list of
     * employed doctors, else the doctor won't be added to the list as they are already in the list
     *
     * @param doctor - the doctor to be added to list of employed doctors
     */
    public void addDoctor(Doctor doctor)
    {
        //assert !employedDoctors.contains(doctor) : "Doctor must not be in the list: value = " + employedDoctors.toString();
        assert doctor != null : "Doctor must not be null: value = " + doctor;
        if (!employedDoctors.contains(doctor))
        {
            employedDoctors.add(doctor);
        }
        assert employedDoctors.contains(doctor) : "Doctor should be in the list value = " + employedDoctors.toString();
    }

    @Override
    public String toString() {
        return "Practice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", employedDoctors=" + employedDoctors +
                '}';
    }
}
