package com.UserAcces.UsersGateway.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserGateway")
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    int id;
    @Column(name = "FirstName",length = 50)
    @NotEmpty(message = "FirstName Cannot Be Empty")
    String firstname;
    @Column(name = "LastName",length = 50)
    @NotEmpty(message = "LastName Cannot Be Empty")
    String lastname;
    @Column(name = "Username",length = 50,unique = true)
    @NotEmpty(message = "UserName Cannot Be Empty")
    String username;
    @Column(name = "Password")
    @NotEmpty(message = "password is Required")
    @Pattern(regexp = "^[a-zA-Z0-9@]{8,12}$",message = "PassWord Cannot Contain Special Characters And Can Be Of 8 to 12 Words")
    String password;
    @Column(name = "EmailId",unique = true,nullable = false)
    @NotEmpty(message = "Please Enter an Email Address!")
    @Pattern(regexp = "^[a-z0-9@.]$",message = "Please Enter An Valid Email Address!")
    String email;
    @Column(name = "PhoneNo",unique = true,nullable = false)
    @NotEmpty(message = "Please Enter an Phone Number!")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Please Enter An Valid Phone Number!")
    String phoneno;
    @Column(name = "Address",nullable = false)
    @NotEmpty(message = "Please Provide An Address!")
    String address;
    LocalDateTime openingDate;

    public Signup() {
        this.openingDate=LocalDateTime.now();
    }

    public Signup(int id, String firstname, String lastname, String username, String password, String email, String phoneno, String address, LocalDateTime openingDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneno = phoneno;
        this.address = address;
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return "Signup{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", address='" + address + '\'' +
                ", openingDate=" + openingDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }
}
