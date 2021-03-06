package org.tutorial.web.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.tutorial.core.entities.personalities.LoggableUser;
import org.tutorial.core.entities.personalities.Role;
import org.tutorial.web.auth.dto.*;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by taras on 14.02.17.
 */

public class AuthSpecPersonFabric
{
    public static UserDetails build(final LoggableUser user, final String userClassName)
    {
        UserDetails authSpecUser;

        String fullName = buildFullName(user);
        String surnameWithInitials = buildSurnameWithInitials(user);

        AuthBase baseUser = new AuthBase(
                user.getLogin(),
                user.getPassword(),
                mapToGrantedAuthority(user.getRoles()),
                user.getId(),
                fullName,
                surnameWithInitials);

        if ("Manager".equals(userClassName)) {
            authSpecUser = new AuthSpecManager(baseUser);
        } else if ("Admin".equals(userClassName)) {
            authSpecUser = new AuthSpecAdmin(baseUser);
        } else if ("Employee".equals(userClassName)) {
            authSpecUser = new AuthSpecEmployee(baseUser);
        } else if ("Customer".equals(userClassName)) {
            authSpecUser = new AuthSpecCustomer(baseUser);
        } else
            throw new IllegalArgumentException("Not found class " + userClassName);

        return authSpecUser;
    }

    public static String buildFullName(LoggableUser user)
    {
        return user.getFirstName() + ' ' + user.getSurname();
    }

    public static String buildSurnameWithInitials(LoggableUser user)
    {
        String name = user.getSurname() + ' ' + user.getFirstName().substring(0, 1) + '.';
        if (!StringUtils.isEmpty(user.getSecondName())) {
            name = name + user.getSecondName().substring(0, 1) + '.';
        }

        return name;

    }

    private static Set<GrantedAuthority> mapToGrantedAuthority(Set<Role> roles)
    {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(toSet());
    }
}
