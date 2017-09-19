package edu.matc.entity;

// [done] TODO Add instance variable for the date of birth
// [done] TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only.

import edu.matc.utility.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity
@Table(name = "users")
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private String userid;

    @Column(name = "date_of_birth")
    @Convert(converter = LocalDateAttributeConverter.class)
    private Date dateOfBirth;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     */
    public User(String firstName, String lastName, String userid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets dateOfBirth.
     *
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth.
     *
     * @param dateOfBirth the dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Calculates age.
     *
     * @return the age of User
     */
    public int calculateAge() {

        Calendar present = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();

        birth.setTime(dateOfBirth);

        int years = 0;

        while(birth.before(present)) {
            birth.add(Calendar.YEAR, 1);
            if (birth.before(present)) {
                years++;
            }
        }

        return years;
    }




    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age='" + calculateAge() + '\'' +
                '}';
    }


}