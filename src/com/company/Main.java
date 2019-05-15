package com.company;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    private static List<Character> str = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of file:");
        String name = sc.next();
        TreeMap<Character, Integer> userList = new TreeMap<>();
        int tempCount = 0;
        try {
            FileReader fr = new FileReader(new File("D://Java/"+name));
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
                str.add((char) ch);
            }
            fr.close();
        }
catch (FileNotFoundException e1) {
    System.out.println("Error:" + e1);
       }
        catch (IOException e2) {
            System.out.println("Error:" + e2);
        }

        int i=0;
        for(Object element : str) {
            if (userList.containsKey(str.get(i))) {
                tempCount = userList.get(str.get(i)) + 1;
                userList.put(str.get(i), tempCount);
            } else {
                userList.put(str.get(i), 1);
            }
            i++;
        }
        System.out.println();
         System.out.println(userList);

        System.out.println("Input name of second file:");
        String name2 = sc.next();

        try
        {
            OutputStream f = new FileOutputStream("D://Java/"+name2);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);

            for(Map.Entry<Character, Integer> e : userList.entrySet())
            {
                writer.write(e.getKey());
                writer.write("=");
                writer.write(Integer.toString(e.getValue()));
                writer.write("; "+"\r\n");
            }
            out.close();
        }
        catch(IOException ex)
        {
            System.err.println("Error:" + ex);
        }
    }
}
