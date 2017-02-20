package org.tutorial.web.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutorial.core.entities.personalities.LoggableUser;
import org.tutorial.core.repositories.LoggableUserRepository;
import org.tutorial.web.auth.AuthSpecPersonFabric;
/**
 * Created by taras on 06.02.17.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private LoggableUserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {
        LoggableUser user = userRepository.findByLogin(login);
        if ((null == user) || (null == user.getRoles()) || (user.getRoles().size() == 0))
            throw new UsernameNotFoundException("User Not Found");

        return AuthSpecPersonFabric.build(user, user.getClass().getSimpleName());
    }

}
