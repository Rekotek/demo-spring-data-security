package org.tutorial.core.entities.helpers;

/**
 * Created by taras on 20.02.17.
 */

public class GenderHelper
{
    public static String getGenderString(Gender gender)
    {
        switch (gender) {
            case UNKNOWN:
                return "Неизвестно";
            case MAN:
                return "Мужчина";
            case WOMAN:
                return "Женщина";
            default:
                return "Хипстер";
        }
    }
}
