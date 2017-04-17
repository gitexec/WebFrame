package com.neybapps.apps.webframe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by wington on 4/2/17.
 */

public class WebSites {
    private static final Random RANDOM = new Random();

    public static int getRandomWebSiteDrawable() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return R.drawable.cheese_1;
            case 1:
                return R.drawable.cheese_2;
            case 2:
                return R.drawable.cheese_3;
            case 3:
                return R.drawable.cheese_4;
            case 4:
                return R.drawable.cheese_5;
        }
    }

    public static List<String> sUrlsStrings = new ArrayList<>( Arrays.asList(new String[]{
            "https://www.google.com/", "https://www.nytimes.com/", "http://www.cnn.com/", "https://www.reddit.com/", "https://www.wikipedia.org/",
            "http://www.ebay.com/", "https://www.amazon.com/"
    }));
}

