package com.mk.recipeproject.model.user;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email")
    @Email(message = "Please enter a valid Email")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Password can't be empty")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name can't be empty")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
