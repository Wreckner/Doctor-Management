package data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private static int addId = 1; // Sets id for each new doctor object

    public Doctor(String firstName, String surname)
    {
        this.id = addId++;
        this.firstName = firstName;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        assert id != 0 : "Id must not be null: value = " + id;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert title != null : "Title must not be null: value = " + title;
        assert title.matches("^[a-zA-Z ]+$") : "Name must only contain letters: value = " + title;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        assert firstName != null : "First Name must not be null: value = " + firstName;
        assert firstName.matches("^[a-zA-Z ]+$") : "Name must only contain letters: value = " + firstName;
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        assert surname != null : "Surname must not be null: value = " + surname;
        assert surname.matches("^[a-zA-Z ]+$") : "Name must only contain letters: value = " + surname;
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        assert dateOfBirth != null : "Date must not be null: value = " + dateOfBirth;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Works out the age of the doctor using the date of birth. If the date calculated is less than 0, then
     * the age is set to 0, else the estimated age is passed back to the calling class.
     *
     * @return the age of the doctor
     */
    public int getAge()
    {
        assert dateOfBirth != null : "Date must not be null: value = " + dateOfBirth;

        Calendar birthDate = new GregorianCalendar();
        birthDate.setTime(dateOfBirth);

        Calendar todayDate = new GregorianCalendar();

        int factor = 0;

        if (todayDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR))
        {
            factor = -1;
        }

        int age = todayDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR) + factor;

        if (age < 0)
        {
            age = 0;
        }

        assert age > -1 : "Age cannot be negative: value = " + age;

        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        assert gender != null : "Name must not be null: value = " + gender;
        assert gender.matches("^[a-zA-Z ]+$") : "Name must only contain letters: value = " + gender;
        this.gender = gender;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        assert office != null : "Office must not be null: value = " + office;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}
