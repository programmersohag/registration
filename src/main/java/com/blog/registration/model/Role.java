package com.blog.registration.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "user_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    private String name;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public String getName() {
        return name;
    }
}
