package org.tutorial.core.entities.personalities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by taras on 07.02.17.
 */

@Entity
public class Role
{
    @Id @GeneratedValue
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<LoggableUser> users;

    public Role()
    {
    }

    public Role(RoleName roleName)
    {
        this.roleName = roleName;
    }

    @Override
    public String toString()
    {
        return "Role{" +
                "id=" + id +
                ", roleName=" + roleName +
                ", usersCount=" + users.size() +
                '}';
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public RoleName getRoleName()
    {
        return roleName;
    }

    public void setRoleName(RoleName roleName)
    {
        this.roleName = roleName;
    }

    public Set<LoggableUser> getUsers()
    {
        return users;
    }

    public void setUsers(Set<LoggableUser> users)
    {
        this.users = users;
    }
}
