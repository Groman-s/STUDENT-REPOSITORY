package com.goyanov.lab4;

public class Pen
{
    enum Color
    {
        СИНИЙ, ЧЁРНЫЙ, КРАСНЫЙ, ЗЕЛЁНЫЙ;
    }

    private String name;
    private String fabricator;
    private Color color;
    private boolean automatic;
    private double cost;

    public Pen(String name, String fabricator, Color color, boolean automatic, double cost)
    {
        this.name = name;
        this.fabricator = fabricator;
        this.color = color;
        this.automatic = automatic;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public String getFabricator()
    {
        return fabricator;
    }

    public Color getColor()
    {
        return color;
    }

    public boolean isAutomatic()
    {
        return automatic;
    }

    public double getCost()
    {
        return cost;
    }
}
