import java.util.*;
import java.io.*;

public class TestLinkedHashSet  {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();

		set.add("George");
		set.add("Jim");
		set.add("John");
		set.add("Blake");
		set.add("Kevin");
		set.add("Michael");

		Set<String> set2 = new LinkedHashSet<>();

		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michelle");
		set2.add("Ryan");

		Set<String> c1 = new LinkedHashSet<>();
		c1.addAll(set);


		System.out.println("1st Set: " + set);
		System.out.println();
		System.out.println("2nd Set: " + set2);

		System.out.println();

		System.out.println("1st set size: " + set.size());
		System.out.println("\n2st set size: " + set2.size());

		System.out.println();

		set.retainAll(set2);
		System.out.println("Unions between Set and Set2: " + set);


		System.out.println();

		System.out.println("Is it equals set and set2? " + set.equals(set2));

		System.out.println();

		System.out.println("New clone on set: " + c1);
		System.out.println();

		c1.addAll(set2);
		System.out.println("c1 and set2 is: " + c1);

		System.out.println();


		c1.removeAll(set);
		System.out.println("c1.removeAll(set): " +c1);


	}
}