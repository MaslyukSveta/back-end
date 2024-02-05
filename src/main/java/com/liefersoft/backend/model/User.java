package com.liefersoft.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class representing a User in the system.
 * This class is annotated with @Entity, indicating that it is a JPA entity.
 */
@Entity
public class User {
    /**
     * Entity class fields representing the attributes of a User.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;

    /**
     * Default constructor.
     * Required by the JPA framework.
     */
    public User() {
    }

    /**
     * Constructor to create a new User instance.
     *
     * @param firstName   the first name of the user
     * @param lastName    the last name of the user
     * @param phoneNumber the phone number of the user
     * @param gender      the gender of the user
     */
    public User(String firstName, String lastName, String phoneNumber, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Gets the user's ID.
     * @return A Long representing the user's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     * @param id A Long containing the user's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user's first name.
     * @return A String representing the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * @param firstName A String containing the user's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * @return A String representing the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * @param lastName A String containing the user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's phone number.
     * @return A String representing the user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     * @param phoneNumber A String containing the user's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's gender.
     * @return A String representing the user's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the user's gender.
     * @param gender A String containing the user's gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Provides a string representation of the User object.
     * @return A string that contains the user's details.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
