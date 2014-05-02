package data.interfaces;

import org.contract4j5.contract.Contract;

import java.util.Date;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
@Contract
public interface Doctor {
    public int getId();

    public String getTitle();

    public void setTitle(String title);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getSurname();

    public void setSurname(String surname);

    public Date getDateOfBirth();

    public void setDateOfBirth(Date dateOfBirth);

    public int getAge();

    public String getGender();

    public void setGender(String gender);

    public String getOffice();

    public void setOffice(String office);
}
