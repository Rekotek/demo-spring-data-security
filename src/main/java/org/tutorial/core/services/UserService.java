package org.tutorial.core.services;

import org.tutorial.core.entities.personalities.LoggableUser;

/**
 * Created by taras on 19.02.17.
 */

public interface UserService
{
    void saveProfile(LoggableUser loggableUser);

    LoggableUser getProfileById(Long id);
}
