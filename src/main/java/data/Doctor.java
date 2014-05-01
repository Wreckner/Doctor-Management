package data;

import java.util.Date;

/**
 * Created by Natasha Whitter on 01/05/2014.
 */
public class Doctor
{
    private int id;
    private String title;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String gender;
    private String office;
    private static int addId = 0;

    public Doctor(String firstName, String surname)
    {
        this.id = addId++;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Doctor()
    {
        this.id = addId++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
