package org.tutorial.web.auth.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * Created by taras on 18.02.17.
 */

public class AuthBase
{
    private String username;
    private String password;
    private Set<GrantedAuthority> roles;

    private Long id;
    private String fullName;
    private String surnameWithInitials;

    public AuthBase(String username,
                    String password,
                    Set<GrantedAuthority> roles,
                    Long id,
                    String fullName,
                    String surnameWithInitials)
    {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.id = id;
        this.fullName = fullName;
        this.surnameWithInitials = surnameWithInitials;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public Set<GrantedAuthority> getRoles()
    {
        return roles;
    }

    public Long getId()
    {
        return id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getSurnameWithInitials()
    {
        return surnameWithInitials;
    }
}
