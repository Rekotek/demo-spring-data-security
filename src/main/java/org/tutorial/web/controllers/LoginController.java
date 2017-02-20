package org.tutorial.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by taras on 09.02.17.
 */

@Controller
public class LoginController
{
    @RequestMapping(value = "/login", method = GET)
    public String showLoginForm()
//            @RequestParam(required = false) String error,
//                                @RequestParam(required = false) String logout)
    {
        return "login";
    }


}
