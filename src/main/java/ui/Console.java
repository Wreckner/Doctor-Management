package ui;

import data.Doctor;
import data.Practice;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
public class Console
{
    public static void main(String[] args)
    {
        Practice GreenwichPractice = new Practice();
        GreenwichPractice.setName("Greenwich Practice");
        GreenwichPractice.setTelephone("01758493741");
        GreenwichPractice.addDoctor(new Doctor("John", "Smith"));
        GreenwichPractice.getTelephone();
    }
}
