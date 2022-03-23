package com.goyanov;

import java.util.Scanner;

public class Main
{
    private static String[] romes = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static boolean isRome(String operand)
    {
        return operand.matches("[XVI]+");
    }

    public static boolean isArabian(String operand)
    {
        try
        {
            Integer.parseInt(operand);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static int romeToArabian(String rome)
    {
        int xCount = (int)rome.chars().filter(ch -> ch == 'X').count();
        int vCount = (int)rome.chars().filter(ch -> ch == 'V').count();
        int iCount = (int)rome.chars().filter(ch -> ch == 'I').count();
        return xCount * 10 + vCount * 5 + iCount - (rome.endsWith("I") ? 0 : 2);
    }

    public static String arabianToRome(int arabian)
    {
        if (arabian == 100) return "C";
        // допустим 99
        int lAmount = arabian / 50; // пятидесятков: 99 /  50 = 1
        int xAmount = arabian % 50 / 10; // десятков: 99 % 50 = 49 / 10 = 4
        int lastNum = arabian % 50 % 10; // последняя цифра: 9

        return "L".repeat(lAmount) + "X".repeat(xAmount) + romes[lastNum];
    }

    public static int getResult(int num1, int num2, String operator) throws Exception
    {
        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10))
        {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        switch (operator)
        {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            default: return num1 / num2;
        }
    }

    public static void printResult(String operand1, String operand2, String operator) throws Exception
    {
        if (!operator.matches("[+*/-]"))
        {
            throw new Exception("Неверный оператор!");
        }

        if (isArabian(operand1) && isArabian(operand2))
        {
            int num1 = Integer.parseInt(operand1);
            int num2 = Integer.parseInt(operand2);

            System.out.println(getResult(num1, num2, operator));
        }
        else if (isRome(operand1) && isRome(operand2))
        {
            int num1 = romeToArabian(operand1);
            int num2 = romeToArabian(operand2);

            System.out.println(arabianToRome(getResult(num1, num2, operator)));
        }
        else
        {
            throw new Exception("Оба числа должны быть одного типа (либо оба арабскими, либо оба римскими)");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] vals = text.split(" ");
        String operand1 = vals[0];
        String operand2 = vals[2];
        String operator = vals[1];

        try
        {
            printResult(operand1, operand2, operator);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
