package com.company;

import java.util.Date;

/**
 * Created by Marcus on 28.05.2017.
 */
public class Player {
    final String name;
    final String email;
    final String Displayname;
    final Date memberSince;

    public Player(String name, String email, String displayname, Date memberSince) {
        this.name = name;
        this.email = email;
        Displayname = displayname;
        this.memberSince = memberSince;
    }
}
