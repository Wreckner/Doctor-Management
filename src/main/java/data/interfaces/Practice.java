package data.interfaces;

import data.*;
import org.contract4j5.contract.Contract;
import org.contract4j5.contract.Post;
import org.contract4j5.contract.Pre;

import java.util.ArrayList;

/**
 * Created by Natasha Whitter on 02/05/2014.
 */
@Contract
public interface Practice {

    public int getId();

    public String getName();

    @Pre("$name != null")
    public void setName(String name);

    public String getTelephone();

    @Pre("$telephone != null")
    public void setTelephone(String telephone);

    public ArrayList<data.Doctor> getEmployedDoctors();

    @Pre("$this.employedDoctors.contains(doctor)")
    @Post("$this.employedDoctors.size() == $old($this.employedDoctors.size()) && !$employedDoctors.contains(doctor")
    public void removeDoctor(data.Doctor doctor);

    public void addDoctor(data.Doctor doctor);
}
