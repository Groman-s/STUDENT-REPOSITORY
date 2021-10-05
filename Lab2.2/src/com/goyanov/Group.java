package com.goyanov;

public class Group
{
    private String name;
    private double srednBall;

    public Group(String name, double srednBall)
    {
        this.name = name;
        this.srednBall = srednBall;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSrednBall()
    {
        return srednBall;
    }

    public void setSrednBall(double srednBall)
    {
        this.srednBall = srednBall;
    }
}
