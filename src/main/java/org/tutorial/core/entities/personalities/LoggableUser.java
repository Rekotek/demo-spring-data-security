package org.tutorial.core.entities.personalities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class LoggableUser extends PersonCore
{
    private String login;
    private String password;
    @Transient
    private String confirmPassword;

    private Date lastAccess;

    private boolean inStaff;
    private boolean active;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    @Override
    public String toString()
    {
        return "LoggableUser{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", lastAccess=" + lastAccess +
                ", inStaff=" + inStaff +
                ", active=" + active +
                ", roles=" + roles +
                "} " + super.toString();
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public Date getLastAccess()
    {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess)
    {
        this.lastAccess = lastAccess;
    }

    public boolean isInStaff()
    {
        return inStaff;
    }

    public void setInStaff(boolean inStaff)
    {
        this.inStaff = inStaff;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
}
