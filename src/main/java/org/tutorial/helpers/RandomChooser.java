package org.tutorial.helpers;

import java.util.List;
import java.util.Random;

/**
 * Created by taras on 07.02.17.
 */

public class RandomChooser
{
    private static final Random random = new Random(System.currentTimeMillis());

    public static String getRandom(List<String> strings)
    {
        return getRandom((String[]) strings.toArray());
    }

    public static String getRandom(String[] strings)
    {
        int length = strings.length;

        int index = random.nextInt(length);

        return strings[index];
    }
}
