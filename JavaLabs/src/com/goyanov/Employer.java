package com.goyanov;

import java.util.Date;

public class Employer
{
    private String surname;
    private String name;
    private String phone;
    private int stag;
    private Date birth;
    private boolean high;

    public Employer(String a1, String a2, String a3, int a4, Date a5, boolean a6)
    {
        this.surname = a1;
        this.name = a2;
        this.phone = a3;
        this.stag = a4;
        this.birth = a5;
        this.high = a6;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public int getStag()
    {
        return stag;
    }

    public Date getBirth()
    {
        return birth;
    }

    public boolean getHigh()
    {
        return high;
    }
}
