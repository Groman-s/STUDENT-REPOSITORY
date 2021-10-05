package com.goyanov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Group> groups = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/input.txt"); BufferedReader reader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] arg = line.split(",");
                groups.add(new Group(arg[0], Double.parseDouble(arg[1])));
            }
        }

        System.out.println("\t  Таблица групп");
        System.out.println("=========================");
        System.out.println("Группа\t\tСредний балл");
        System.out.println("=========================");
        groups.forEach(g -> System.out.printf("%s\t\t%5.2f\n", g.getName(), g.getSrednBall()));
        System.out.println("=========================");

        System.out.print("\nВведите первую букву группы: ");
        Scanner inp = new Scanner(System.in);
        String groupFirstLetter = inp.nextLine();
        inp.close();

        System.out.println("\nИнформация о группах, названия которых начинаются с '" + groupFirstLetter + "':");
        boolean found = false;
        try (PrintStream fileWriter = new PrintStream("src/output.txt"))
        {
            System.out.println("=========================");
            System.out.println("Группа\t\tСредний балл");
            System.out.println("=========================");
            for (Group group : groups)
            {
                if (group.getName().startsWith(groupFirstLetter))
                {
                    fileWriter.println(group.getName() + "," + group.getSrednBall());
                    found = true;
                    System.out.printf("%s\t\t%5.2f\n", group.getName(), group.getSrednBall());
                }
            }
            if (!found) System.out.println("-- Таких групп нет!");
            System.out.println("=========================");
        }
    }
}