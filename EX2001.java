import java.util.*;
import java.io.*;

public class EX2001{
    public static void main(String[] args) throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream(("temp.dat")));
        output.writeUTF("Miami");
        output.writeUTF("Texas");
        output.writeUTF("London");
        output.writeUTF("Chicago");
        output.writeUTF("Moscow");

        try(
            DataInputStream input = new DataInputStream(
                new FileInputStream("temp.dat"));
            ){
             PriorityQueue<String> queue1 = new PriorityQueue<>();
             queue1.offer(input.readUTF());
             queue1.offer(input.readUTF());
             queue1.offer(input.readUTF());
             queue1.offer(input.readUTF());
             queue1.offer(input.readUTF());

             while (queue1.size() > 0) {
 System.out.print(queue1.remove() + " ");
 }
        }
    }
}
