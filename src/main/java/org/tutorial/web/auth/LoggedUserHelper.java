package org.tutorial.web.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.tutorial.web.auth.dto.AuthSpecUser;

import static org.tutorial.core.entities.personalities.RoleName.ROLE_ADMIN;
import static org.tutorial.core.entities.personalities.RoleName.ROLE_MANAGER;

/**
 * Created by taras on 20.02.17.
 */

public class LoggedUserHelper
{

    public static AuthSpecUser getLoggedUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (AuthSpecUser) auth.getPrincipal();
    }

    public static Long getLoggedUserId()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.getId();
    }

    public static boolean isRoleAdmin()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(ROLE_ADMIN.toString()));
    }

    public static boolean isRoleManager()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(ROLE_MANAGER.toString()));
    }
}
