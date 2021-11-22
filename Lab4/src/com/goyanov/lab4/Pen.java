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
    private int cost;

    public Pen(String name, String fabricator, Color color, boolean automatic, int cost)
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

    public int getCost()
    {
        return cost;
    }
}
