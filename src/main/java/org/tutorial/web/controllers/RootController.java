package org.tutorial.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tutorial.core.repositories.LoggableUserRepository;
import org.tutorial.web.auth.dto.AuthSpecManager;
import org.tutorial.web.auth.dto.AuthSpecUser;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.tutorial.core.entities.personalities.RoleName.ROLE_MANAGER;

/**
 * Created by taras on 10.02.17.
 */

@Controller
public class RootController
{
    @Autowired
    private LoggableUserRepository loggableUserRepository;


    @RequestMapping(value = "/", method = GET)
    public String redirectToIndex()
    {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = GET)
    public String home(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isRoleManager = auth.getAuthorities().contains(new SimpleGrantedAuthority(ROLE_MANAGER.toString()));
        model.addAttribute("isRoleManager", isRoleManager);

        AuthSpecUser user = (AuthSpecUser) auth.getPrincipal();
        model.addAttribute("user", user);

        boolean isTypeManager = user instanceof AuthSpecManager;
        model.addAttribute("isTypeManager", isTypeManager);

        return "index";
    }
}
