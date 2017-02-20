package org.tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutorial.core.entities.personalities.LoggableUser;
import org.tutorial.core.repositories.LoggableUserRepository;
import org.tutorial.core.services.UserService;

/**
 * Created by taras on 19.02.17.
 */

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private LoggableUserRepository loggableUserRepository;

    @Override
    public void saveProfile(LoggableUser loggableUser)
    {
        loggableUserRepository.save(loggableUser);
    }

    @Override
    public LoggableUser getProfileById(Long id)
    {
        LoggableUser user = loggableUserRepository.findById(id);
        return user;
    }
}
