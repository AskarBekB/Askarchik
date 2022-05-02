import java.util.*;
import java.io.*;


public class EX2006{

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.println("End iterator");
   
        System.out.println("Start .get()");
        for (int i = 0; i < 500000; i++) {
            list.get(i);
        }
        System.out.println("End .get()");
    }
}