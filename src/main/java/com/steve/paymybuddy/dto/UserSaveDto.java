package com.steve.paymybuddy.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserSaveDto {
    private String firstName;
    private String lastname;
    private String password;

    @Email
    @NotNull
    private String email;

    public UserSaveDto() {
    }

    public UserSaveDto(String firstName, String lastname, String password, @Email @NotNull String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
