package com.goyanov.lab2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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

        Arrays.stream(line.trim().split(" ")).map(Integer::parseInt).filter(num -> num > 0).forEach(nums::push);

        FileWriter writer = new FileWriter("src/output.txt");
        System.out.print("Чётные числа в стеке: ");
        nums.stream().filter(num -> num % 2 == 0).forEach(num ->
        {
            try {
                writer.write(num + " ");
            } catch (IOException e) { e.printStackTrace(); }
            System.out.print(num + "; ");
        });
        writer.close();

        System.out.println("\nОбщая сумма чисел в стеке: " + nums.stream().mapToInt(s -> s).sum());
    }
}
