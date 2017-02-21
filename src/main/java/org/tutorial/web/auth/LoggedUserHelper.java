package org.tutorial.web.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.tutorial.web.auth.dto.AuthSpecUser;

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
        return loggedUser.isRoleAdmin();
    }

    public static boolean isRoleManager()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.isRoleManager();
    }

    public static boolean isRoleEmployee()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.isRoleEmployee();
    }

    public static boolean isRoleCustomer()
    {
        AuthSpecUser loggedUser = getLoggedUser();
        return loggedUser.isRoleCustomer();
    }
}
