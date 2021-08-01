package hu.ulyssys.java.course.maven.entity;

import java.util.Date;

public class Author extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String username;

    public Author(){

    }

    public Author(Long id, Date createdDate, Date lastModifiedDate, String firstName, String lastName, String username) {
        super(id, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
