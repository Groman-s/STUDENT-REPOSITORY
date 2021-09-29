package com.goyanov.lab2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String line = "";

        try (FileReader reader = new FileReader("src/input.txt"))
        {
            int c;
            while ((c = reader.read()) != -1)
            {
                line += (char)c;
            }
        }

        Stack<Integer> nums = new Stack<>();

        for (String numString : line.trim().split(" "))
        {
            int num = Integer.parseInt(numString);
            if (num > 0)
            {
                nums.push(num);
            }
        }

        FileWriter writer = new FileWriter("src/output.txt");
        System.out.print("Чётные числа в стеке: ");
        Iterator<Integer> iterator = nums.iterator();
        int sum = 0;
        while (iterator.hasNext())
        {
            int num = iterator.next();
            sum += num;
            if (num % 2 == 0)
            {
                System.out.print(num + "; ");
                writer.write(num + " ");
            }
        }
        writer.close();

        System.out.println("\nОбщая сумма чисел в стеке: " + sum);
    }
}
