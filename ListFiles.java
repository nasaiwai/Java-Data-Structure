/*
 * Assignment  1
 * This program list the names and sizes of all "normal files" from a given set of directories.
 * @author Nasa Iwai
 * @version July 28th, 2015 
 */

import java.io.*;
import java.util.*;

public class ListFiles {
	private static File f;
	private static File[] paths;
	private static ArrayList<String> fileName;
	private static ArrayList<Long> fileSize;
	private static int count;	

	public ListFiles() {
		this.f = null;
		this.paths = null;
		this.fileName = new ArrayList<String>();
		this.fileSize = new ArrayList<Long>();
		this.count = 0;
	}

	public static void main(String[] args) throws IOException {
		ListFiles list = new ListFiles();
		String myFile = "";
	
		try {
			if(args.length ==0);
			else if(args.length == 1) {	
				if(args[0].equals("-size"));
				else if(args[0].equals("-gather"));
				else {
					myFile = args[0];
					list.ReadFile(myFile);
					list.SortByName();
					list.Print(fileName, fileSize);
				}
			}
			else if(args.length == 2) {	
				switch(args[0]) {
					case "-size":
						if(args[1].equals("-gather")) break;
						else {
							myFile = args[1];
							list.ReadFile(myFile);      
							list.SortByName();
							list.SortBySize();
							list.Print(fileName, fileSize);
						}	
						break;
					case "-gather":
						if(args[1].equals("-size"));
						else {
							myFile = args[1];
							list.ReadFile(myFile);
							list.SortByName();      
							list.Print(fileName, fileSize);
						}
						break;
					default:
						for(int i=0; i < args.length; i++) {
							myFile = args[i];
							list.ReadFile(myFile);
							list.SortByName();
							list.Print(fileName, fileSize);
						}
						break;
				}
			}
			else {
				switch(args[0]) {
					case "-size":
						if(args[1].equals("-gather")) {
							for(int i=2; i < args.length; i++) {
								myFile = args[i];
								list.ReadFileByGather(myFile);      
							}
							list.SortByNameByGather();
							list.SortBySizeByGather();
							list.Print(fileName, fileSize);
						}
						else { 
							for(int i=1; i < args.length; i++) {
								myFile = args[i];
								list.ReadFile(myFile);
								list.SortByName();      
								list.SortBySize();
								list.Print(fileName, fileSize);
							}
						}
						break;
					case "-gather":
						if(args[1].equals("-size"));
						else {
							for(int i=1; i < args.length; i++) {
								myFile = args[i];
								list.ReadFileByGather(myFile);      
								//list.Print(fileName, fileSize);
							}
							list.SortByNameByGather();
							list.Print(fileName, fileSize);
						}
						break;
					default:
						for(int i=0; i < args.length; i++) {
							myFile = args[i];
							list.ReadFile(myFile);
							list.Print(fileName, fileSize);
							break;
						}
				}
			}
		} catch (IOException e) {
			System.err.printf("Error: %s%n", e.getMessage());
			System.exit(1);
		}
	}

	public void ReadFile(String myFile) throws IOException {
		f = new File(myFile);
		paths = f.listFiles();
		if(!f.isDirectory()) System.err.println("Not a directory: " + myFile);
		else {
			fileName = new ArrayList<String>();
			fileSize = new ArrayList<Long>();
			for(int i=0; i < paths.length; i++) {
				fileName.add(paths[i].getName());
				fileSize.add(paths[i].length());
				count++;
			}
		}
	}

	public void ReadFileByGather(String myFile) throws IOException {
		f = new File(myFile);
		paths = f.listFiles();
		if(!f.isDirectory()) System.err.println("Not a directory: " + myFile);
		else {
			for(int i=0; i < paths.length; i++) {
				fileName.add(paths[i].getName());
				fileSize.add(paths[i].length());
				count++;
			}
		}
	}

	public void SortByNameByGather() {	
		for(int i=0; i < count - 1; ++i) {
			for(int j = count - 1; i < j; --j) {
				if(fileName.get(j-1).compareTo(fileName.get(j)) > 0) {
					long tempV = fileSize.get(j-1);
					fileSize.set(j-1, fileSize.get(j));
					fileSize.set(j,tempV);

					String tempK = fileName.get(j-1);
					fileName.set(j-1, fileName.get(j));
					fileName.set(j,tempK);
				}
			}
		}
	}
	
	public void SortByName() throws IOException{	
		if(!f.isDirectory());
		else {for(int i=0; i < paths.length - 1; ++i) {
			for(int j = paths.length - 1; i < j; --j) {
				if(fileName.get(j-1).compareTo(fileName.get(j)) > 0) {
					long tempV = fileSize.get(j-1);
					fileSize.set(j-1, fileSize.get(j));
					fileSize.set(j,tempV);

					String tempK = fileName.get(j-1);
					fileName.set(j-1, fileName.get(j));
					fileName.set(j,tempK);
				}
			}
		}
		}
		
	}
	
	public void SortBySizeByGather() {
		for(int i = count - 1; i > 0; --i) {
			for(int j = 0; j < i; j++){
				if(fileSize.get(j) < fileSize.get(j+1)) {
					long tempV = fileSize.get(j);
					fileSize.set(j, fileSize.get(j+1));
					fileSize.set(j+1,tempV);

					String tempK = fileName.get(j);
					fileName.set(j, fileName.get(j+1));
					fileName.set(j+1,tempK);
				}
			}
		}

	}
	public void SortBySize() {
		if(!f.isDirectory());
		else {
			for(int i = paths.length - 1; i > 0; --i) {
				for(int j = 0; j < i; j++){
					if(fileSize.get(j) < fileSize.get(j+1)) {
						long tempV = fileSize.get(j);
						fileSize.set(j, fileSize.get(j+1));
						fileSize.set(j+1,tempV);
	
						String tempK = fileName.get(j);
						fileName.set(j, fileName.get(j+1));
						fileName.set(j+1,tempK);
					}
				}
			}
		}
	}

	public static void Print(ArrayList<String> str, ArrayList<Long> in) throws IOException {
		if(!f.isDirectory());
		else {
			for(int i=0; i < str.size(); i++)
				System.out.printf("%12s %s %n", fileSize.get(i), fileName.get(i));
		}
	}
}

