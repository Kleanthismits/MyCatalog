//package mycatalog;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ReadFile {
//
//	private String[] nameTel = new String[50];
//
//	public ReadFile(String filename) {
//
//		File f = new File(filename);
//		BufferedReader br;
//
//		int count = 0;
//		try {
//			br = new BufferedReader(new FileReader(f));
//			String line = br.readLine();
//
//			while(line!=null) {
//				line = br.readLine();
//				count++;
//			}
//
//			nameTel = new String[count];
//			count = 0;
//			br = new BufferedReader(new FileReader(f));
//			line = br.readLine();
//
//			while(line!=null) {
//				nameTel[count] = line;
//				line = br.readLine();
//				count++;
//			}for (int i = 0; i<count; i++) {
//				//System.out.println(nameTel[i]);
//			}
//
//		} 
//
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public int SearchArray(String name) {
//		int index = -1;
//		String[] nameToFind = new String[2];
//		for (int i = 0; i<nameTel.length; i++) {
//
//			nameToFind = nameTel[i].split(",");
//			//System.out.println(nameToFind[1]);
//
//
//
//			if (name.matches("[0-9]+")) {
////				System.out.println("match");
////				System.out.println(nameToFind[1]);
////				System.out.println(name);
//				if (nameToFind[1].trim().equals(name)) 
//				{
//					index=i;
//					System.out.println("tifasi?");
//					return index+1;
//
//				}
//
//			}
//
//			if (name.matches("[A-Z]+")) {
//				if (nameToFind[0].equals(name) ) 
//				{
//					index=i;
//					System.out.println("tifasi2");
//					return index+1;
//				}
//
//			}
//
//		}
//		return index;
//	}
//
//}
//
//
//
//
