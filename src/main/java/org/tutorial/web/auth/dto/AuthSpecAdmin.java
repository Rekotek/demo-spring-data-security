package org.tutorial.web.auth.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by taras on 14.02.17.
 */

public class AuthSpecAdmin extends AuthSpecUser
{
    public AuthSpecAdmin(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long id, String fullName)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, id, fullName);
    }

    public AuthSpecAdmin(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String fullName)
    {
        super(username, password, authorities, id, fullName);
    }

    public AuthSpecAdmin(AuthBase baseUser)
    {
        super(baseUser);
    }
}
