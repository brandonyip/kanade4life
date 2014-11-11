/*
Author: Brandon Yip
CPSC501 Assignment3
 A class that will prompt the user to create an object. There are 5 types of objects
 	1) Contain only primitive fields
	2) Contain references to other objects
	3) Contain an array of primitives
	4) Contain an array of object references
	5) Contains a java collection.
	
Then it will call serializer to serialize the object created. This will return a doc as well 
as outport an xml file into the directory called output.xml.

*/

import java.lang.reflect.*;
import java.util.*;
import org.jdom.Document;

public class ObjectCreator {

	private Scanner in;
	public Object myObj;
	public Foo1 foo1;
	public Foo2 foo2;
	public Foo3 foo3;
	public Serializer serializer = new Serializer();
	public Deserializer deserializer = new Deserializer();
	public Visualizer visualizer = new Visualizer();
	

	public ObjectCreator() {
		in = new Scanner(System.in);
	}


	public void display() {
		System.out.println("Hi, welcome to the object creator. You can create an object:");
		System.out.println(" 1) Contain only primitive fields");
		System.out.println(" 2) Contain references to other objects");
		System.out.println(" 3) Contain an array of primitives");
		System.out.println(" 4) Contain an array of object references");
		System.out.println(" 5) Contains a java collection.");
		System.out.println(" Enter 'Q' to quit");
		System.out.println("Input the corresponding number to your desire.");
	}


	// This method makes an instance of an object that only has primitive fields
	// This method makes an instance of an object that only has primitive fields
	public void object1() {
		//Simple object with only primitives for instance variables
		System.out.println("You have selected: Object with primitive fields.");
		System.out.println("Info: This object has two primitive fields:\n"
			+ "  1) Integer field called 'value' \n"
			+ "  2) String field called 'punchphrase' \n"
			+ " Enter them one after the other:");
		System.out.print("First input (Integer): ");
		int value = Integer.parseInt(in.nextLine());
		System.out.print("Second input (String): ");
		String message = in.nextLine();
		foo1 = new Foo1();
		foo1.setPunchphrase(message);
		foo1.setValue(value);
		myObj = foo1;
	}

	// This method makes an instance of an object that has references to other objects
	public void object2() {
		//Object that contains references to other objects.
		System.out.println("You have selected: Object with object references.");
		System.out.println("Info: This object has three fields:\n"
			+ "  1) Integer field called 'value2'\n"
			+ "  2) String field called 'punchphrase2'\n"
			+ "  3) Object Foo1. Foo1 has two primitives, the first an integer and the second a string.\n"
			+ " Enter them one after the other:");
		System.out.print("First input (Integer): ");
		int value = Integer.parseInt(in.nextLine());
		System.out.print("Second input (String): ");
		String message = in.nextLine();
		System.out.print("Third input (Integer): ");
		int value2 = Integer.parseInt(in.nextLine());
		System.out.print("Fourth input (String): ");
		String message2 = in.nextLine();
		
		foo2 = new Foo2();
		foo2.setPunchphrase2(message);
		foo2.setValue2(value);
		foo2.foo1.setPunchphrase(message2);
		foo2.foo1.setValue(value2);
		myObj = foo2;
	}

	//This method makes an instance of an object that has an array of primitives
	public void object3() {
		//An object that contains array of primitives
		System.out.println("You have selected: Object with an array of primitives.");
		System.out.println("Info: This object has two fields:\n"
				+ "  1) Integer array called 'values'. Length = 3\n"
				+ "  2) String array called 'punchphrases. Length = 2'\n"
				+ " Enter the inputs one after the other:");
		System.out.print("First input (values, index 0): ");
		int value1 = Integer.parseInt(in.nextLine());
		System.out.print("Second input (values, index 1): ");
		int value2 = Integer.parseInt(in.nextLine());
		System.out.print("Third input (values, index 2): ");
		int value3 = Integer.parseInt(in.nextLine());
		System.out.print("Fourth input (punchphrases, index 0): ");
		String message = in.nextLine();
		System.out.print("Fifth input (punchphrases, index 1): ");
		String message2 = in.nextLine();
		
		foo3 = new Foo3();
		foo3.fillValues(value1, value2, value3);
		foo3.fillPunches(message, message2);
		myObj = foo3;
	
	}

	
	//This method makes an instance of an object that has an array of objects
	public void object4() {
		//An object that contains an array of object references
		System.out.println("You have selected: Object with an array of objects.");

	}


	public void start() {
		String input;
		do {
			display();
			input = in.nextLine();
			if(input.equals("1")){
				object1();		
				Document doc = serializer.serialize(myObj);
				Object myobj = deserializer.deserialize(doc);
				visualizer.inspect(myobj);
			}
			else if(input.equals("2")) {
				object2();
				Document doc = serializer.serialize(myObj);
				Object myobj = deserializer.deserialize(doc);
				visualizer.inspect(myobj);
			}
			else if(input.equals("3")) {
				object3();
				Document doc = serializer.serialize(myObj);
				Object myobj = deserializer.deserialize(doc);
				visualizer.inspect(myobj);
			}
			else if(input.equals("4")) {

			}
			else if(input.equalsIgnoreCase("q")) {
				System.out.println("Quitting program....");
			}
				
			else {
				System.out.println("You did not enter a number that is listed here.");
			}
		} while(!input.equalsIgnoreCase("q"));
	}
	
}
