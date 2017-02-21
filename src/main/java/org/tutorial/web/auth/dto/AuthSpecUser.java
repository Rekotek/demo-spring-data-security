package org.tutorial.web.auth.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import static org.tutorial.core.entities.personalities.RoleName.*;

/**
 * Created by taras on 10.02.17.
 */

public class AuthSpecUser extends User
{
    private Long id;
    private String fullName;
    private String surnameWithInitials;

    private boolean isRoleAdmin;
    private boolean isRoleManager;
    private boolean isRoleEmployee;
    private boolean isRoleCustomer;

    AuthSpecUser(AuthBase baseUser)
    {
        super(baseUser.getUsername(), baseUser.getPassword(), baseUser.getRoles());
        this.id = baseUser.getId();
        this.fullName = baseUser.getFullName();
        this.surnameWithInitials = baseUser.getSurnameWithInitials();

        this.isRoleAdmin = baseUser.getRoles().contains(new SimpleGrantedAuthority(ROLE_ADMIN.toString()));
        this.isRoleManager = baseUser.getRoles().contains(new SimpleGrantedAuthority(ROLE_MANAGER.toString()));
        this.isRoleEmployee = baseUser.getRoles().contains(new SimpleGrantedAuthority(ROLE_EMPLOYEE.toString()));
        this.isRoleCustomer = baseUser.getRoles().contains(new SimpleGrantedAuthority(ROLE_CUSTOMER.toString()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getSurnameWithInitials()
    {
        return surnameWithInitials;
    }

    public void setSurnameWithInitials(String surnameWithInitials)
    {
        this.surnameWithInitials = surnameWithInitials;
    }

    public boolean isRoleAdmin()
    {
        return isRoleAdmin;
    }

    public boolean isRoleManager()
    {
        return isRoleManager;
    }

    public boolean isRoleEmployee()
    {
        return isRoleEmployee;
    }

    public boolean isRoleCustomer()
    {
        return isRoleCustomer;
    }
}
