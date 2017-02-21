package org.tutorial.web.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tutorial.core.entities.helpers.Address;
import org.tutorial.core.entities.helpers.Gender;
import org.tutorial.core.entities.helpers.GenderHelper;
import org.tutorial.core.entities.personalities.LoggableUser;
import org.tutorial.core.repositories.LoggableUserRepository;
import org.tutorial.web.auth.AuthSpecPersonFabric;
import org.tutorial.web.auth.dto.AuthSpecUser;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.tutorial.web.auth.LoggedUserHelper.getLoggedUser;
import static org.tutorial.web.auth.LoggedUserHelper.getLoggedUserId;

/**
 * Created by taras on 14.02.17.
 */
@Controller
@RequestMapping(value = "/users")
@PreAuthorize("hasRole('ADMIN') OR hasRole('MANAGER') OR hasRole('EMPLOYEE')")
public class UserController
{
    @Autowired
    private LoggableUserRepository loggableUserRepository;

    @RequestMapping(value = "/{id}", method = GET)
    public String getProfilePage(@PathVariable Long id, Model model)
    {
        if (null == id) {
            throw new IllegalArgumentException("User id must be specified");
        }

        AuthSpecUser loggedUser = getLoggedUser();
        Long loggedUserId = loggedUser.getId();

        if (loggedUserId != id) {
            throw new IllegalArgumentException("User id did not match!");
        }

        /*
            Look at this: we have base class repository and get information
            about any child objects. Very cool!
         */
        LoggableUser userProfile = loggableUserRepository.findById(id);


        model.addAttribute("userClassName", loggedUser.getClass().getName());
        model.addAttribute("user", userProfile);
        model.addAttribute("genderValues", Gender.values());
        model.addAttribute("genderHelper", GenderHelper.class);
        return "users/profile";
    }

    @RequestMapping(value = "/profile", method = POST)
    public String updateProfile(@ModelAttribute("user") LoggableUser userForm, Model model)
    {
        Long loggedUserId = getLoggedUserId();

        if (loggedUserId != userForm.getId()) {
            throw new IllegalArgumentException("User id did not match!");
        }

        /*
            As it's seen above, we can don't care about call to
            concrete repository when we update common data
         */
        LoggableUser originalUser = loggableUserRepository.findById(userForm.getId());

        originalUser.setFirstName(userForm.getFirstName());
        originalUser.setSecondName(userForm.getSecondName());
        originalUser.setSurname(userForm.getSurname());

        originalUser.setGender(userForm.getGender());

        Address passportAddress = new Address();
        passportAddress.setAddressLine1(userForm.getPassportAddress().getAddressLine1());
        passportAddress.setAddressLine2(userForm.getPassportAddress().getAddressLine2());
        passportAddress.setCity(userForm.getPassportAddress().getCity());
        passportAddress.setPostCode(userForm.getPassportAddress().getPostCode());
        originalUser.setPassportAddress(passportAddress);

        Address shippingAddress = new Address();
        shippingAddress.setAddressLine1(userForm.getShippingAddress().getAddressLine1());
        shippingAddress.setAddressLine2(userForm.getShippingAddress().getAddressLine2());
        shippingAddress.setCity(userForm.getShippingAddress().getCity());
        shippingAddress.setPostCode(userForm.getShippingAddress().getPostCode());
        originalUser.setShippingAddress(shippingAddress);

        loggableUserRepository.save(originalUser);

        AuthSpecUser authPrincipal = getLoggedUser();
        authPrincipal.setFullName(AuthSpecPersonFabric.buildFullName(originalUser));
        authPrincipal.setSurnameWithInitials(AuthSpecPersonFabric.buildSurnameWithInitials(originalUser));

        return "redirect:/index";
    }


}
