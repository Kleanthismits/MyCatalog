package mycatalog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyCatalog {

	static String[] nameTel = new String[50];
	static String[] entryToFind = new String[2];
	static String newEntry = "";
	static Scanner sc = new Scanner(System.in);
	public MyCatalog() {
	}

	public static void main(String[] args) {

		//  1. Read the file telcatalog.txt
		//  2. The structure of the file is NAME,TEL
		//  3. Get from each line the NAME, TEL and store them to an array
		readFile("C:\\Users\\klean\\eclipse-workspace\\MyCatalog\\telcatalog.txt");
		printEntries();
		//  4. Create the method SearchArray(String name) that searches the array based on name
		//  5. Create the method SearchArray(String tel) that searches the array based on name

		// *********I Created only one find method that searches the array for name or tel depending on what the user types**********

		//SearchArray("JOHN");
		//SearchArray("67890");


		//  6. Create the method CreateEntry(String name, String tel) that inserts a new name,tel entry
		//************* Method inserts the new entry at the first null place it finds************* 

		//		DeleteEntry("12567");
		//		CreateEntry("KLEANTHIS", "55555");
		//		printEntries();
		//  7. Create the method UpdateEntry(String name) that returns true if the method did the update 
		//  8. Create the method UpdateEntry(String tel) that returns true if the method did the update

		UpdateEntry("DANIEL");
		printEntries();
		// *********I Created only one update method that searches the array for name or tel depending on what the user types**********


		//UpdateEntry("WILLIAM");
		UpdateEntry("67890");
		updateTextFile();
		//printEntries();

		//  9. Create the method DeleteEntry(String name) that returns true if the method did the delete
		// 10. Create the method DeleteEntry(String tel) that returns true if the method did the delete

		//***************The method DeleteEntry also lets the user type what he wants to delete tel or name**************
		//		DeleteEntry("DANIEL");
		//		printEntries();
		//		DeleteEntry("23456");
		//		//printEntries();



		//*********The method updateTextFile updates the text file with the changes occurred. For
		//*********Convenience reasons the method creates a new text file telcatalog2.txt 



		// A. Do we need to create any new classes?

		/* We do not need to create new classes although we can.*/


		// B. Do we have to create any new classes?

		/* We don't have to create new classes because we have to deal with only one file. If we had more than one
		 * files we could still do that with one class and the user should be able to choose which catalogue he wants to
		 *  edit
		 *  Finally if we had to create new catalogues with different properties 
		 *  (size, professional or civilian, land lines or mobile phones etc.) 
		 *  it would be much more efficient to use a class for the catalogue creation */

	}

	public static void readFile(String filename) {

		File f = new File(filename);
		BufferedReader br;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();

			while(line!=null) {
				line = br.readLine();
				count++;
			}

			count = 0;
			br = new BufferedReader(new FileReader(f));
			line = br.readLine();

			while(line!=null) {
				nameTel[count] = line;
				line = br.readLine();
				count++;
			}
		} 

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	static int SearchArray(String searchEntry) {
		int index = -1;
		for (int i = 1; i<=nameTel.length; i++) {

			if (nameTel[i-1]!=null) {
				entryToFind = nameTel[i-1].split(",");
			}

			if (searchEntry.matches("[0-9]+")) {
				if (entryToFind[1].trim().equals(searchEntry)) {
					index=i;
					if (index !=-1) {
						System.out.println("Tel number found at position: " + (index) + ", under the name : " + entryToFind[0] );
					}
					return index;
				}

			}

			if (searchEntry.matches("[A-Z]+")) {
				if (entryToFind[0].equals(searchEntry) ) {
					index=i;
					if (index !=-1) {
						System.out.println("Name found at position: " + (index) + ", with Tel number: " + entryToFind[1] );
					}
					return index+1;
				}
			}

		}
		System.out.println("No entry matches your search criteria!");	
		return index;

	}

	static void printEntries() {
		int i = 0;

		for (i=0; i<nameTel.length; i++) {
			if (nameTel[i]!=null) {
				System.out.println(nameTel[i]);
			}
		}
		System.out.println();

	}
	static void CreateEntry(String name, String tel) {
		for (int i=0; i<nameTel.length; i++) {
			if (nameTel[i]==null) {
				nameTel[i] = name + "," + tel;
				break;
			}
		}
	}

	static boolean UpdateEntry(String updateEntry) {
		boolean updateSuccesfull = false;
		int index = -1;
		for (int i = 1; i<=nameTel.length; i++) {

			if (nameTel[i-1]!=null) {
				entryToFind = nameTel[i-1].split(",");
			}

			if (updateEntry.matches("[0-9]+")) {
				if (entryToFind[1].trim().equals(updateEntry)) {
					index=i;
					System.out.println("Tel number found at position: " + (index) + ", under the name : " + entryToFind[0]);
					System.out.println("Enter the new tel number");
					//Scanner sc = new Scanner(System.in);
					int newnum = sc.nextInt();
					newEntry = entryToFind[0] + "," + newnum;
					nameTel[i-1] = newEntry;
					updateSuccesfull=true;

					return updateSuccesfull;
				}

			}

			if (updateEntry.matches("[A-Z]+")) {
				if (entryToFind[0].equals(updateEntry) ) {
					index=i;
					System.out.println("Name found at position: " + (index) + ", with Tel number: " + entryToFind[1] );
					System.out.println("Enter the new name:");
					String newname = sc.nextLine();
					newEntry = newname + "," + entryToFind[1];
					nameTel[i-1] = newEntry;
					updateSuccesfull=true;
					return updateSuccesfull;
				}
			}

		}
		System.out.println("There is no such entry!");
		return updateSuccesfull;
	}

	static boolean DeleteEntry(String entry) {
		boolean deleteSuccesfull = false;
		boolean check = true;
		int index = -1;
		String choice ="";
		String choice2 ="";
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i<=nameTel.length; i++) {

			if (nameTel[i-1]!=null) {
				entryToFind = nameTel[i-1].split(",");
			}

			if (entry.matches("[0-9]+")) {
				if (entryToFind[1].trim().equals(entry)) {
					index=i;
					System.out.println("Tel number found at position: " + (index) + ", under the name : " + entryToFind[0]);
					System.out.println("Do you want to delete the whole entry or just the number?");
					System.out.println("1.Whole entry");
					System.out.println("2.Just the number");
					choice = sc.nextLine();
					if (choice.equals("2")){
						System.out.println("Are you sure you want to delete only the number?\n\"Y\" for Yes\nAnything else for No");
						choice= sc.nextLine();
						if(choice.equalsIgnoreCase("y"))  {
							newEntry = entryToFind[0].trim() + ",";
							nameTel[i-1] = newEntry;
							deleteSuccesfull=true;

							return deleteSuccesfull;
						}else {
							System.out.println("First thought is usually the best!");
							check=false;
						}
					}else  if(choice.equals("1")){

						nameTel[i-1] = null;
						check=false;
					}else {
						System.out.println("Wrong input");
						check=false;
					}
				}
			}
			if (entry.matches("[A-Z]+")) {

				if (entryToFind[0].equals(entry) ) {
					index=i;
					System.out.println("Name found at position: " + (index) + ", with Tel number: " + entryToFind[1] );
					System.out.println("Do you want to delete the whole entry or just the name?");
					System.out.println("1.Whole entry");
					System.out.println("2.Just the name");
					Scanner sc2 = new Scanner(System.in);
					choice2 = sc2.nextLine();
					if (choice2.equals("2")){
						System.out.println("Are you sure you want to delete only the name?\n\"Y\" for Yes\nAnything else for No");
						choice= sc2.nextLine();
						if(choice2.equalsIgnoreCase("y"))  {
							newEntry = "," + entryToFind[1].trim();
							nameTel[i-1] = newEntry;
							deleteSuccesfull=true;
							return deleteSuccesfull;
						}else {
							System.out.println("First thought is usually the best!");
							check=false;
						}
					}else  if(choice2.equals("1")){
						nameTel[i-1] = null;
						check=false;
					}else {
						System.out.println("Wrong input");
						check=false;
					}
				}
			}

		}if (check) {System.out.println("There is no such entry!");}
		return deleteSuccesfull;
	}

	static void updateTextFile() {
		int i = 0;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("telcatalog2.txt"));
			for (i=0; i<nameTel.length; i++) {
				if (nameTel[i]!=null) {
					bw.append(nameTel[i]);
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

	}
}
