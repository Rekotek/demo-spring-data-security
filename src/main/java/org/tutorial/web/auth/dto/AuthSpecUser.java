package org.tutorial.web.auth.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by taras on 10.02.17.
 */

public class AuthSpecUser extends User
{
    private Long id;
    private String fullName;

    public AuthSpecUser(String username, String password,
                        boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                        boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
                        Long id, String fullName)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.fullName = fullName;
    }

    public AuthSpecUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                        Long id, String fullName)
    {
        super(username, password, authorities);
        this.id = id;
        this.fullName = fullName;
    }

    public AuthSpecUser(AuthBase baseUser)
    {
        super(baseUser.getUsername(), baseUser.getPassword(), baseUser.getRoles());
        this.id = baseUser.getId();
        this.fullName = baseUser.getFullName();
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
}
