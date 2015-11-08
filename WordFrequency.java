import java.io.*;
import java.util.*;
import java.util.LinkedList;

/*
 * Program Assignment2
 * @author Nasa Iwai
 * @version July 11th, 2015
 * Student ID: A91431033
 *
 * The WordFrequency program counts how many times each word from the input appears, and then
 * outputs sequence of word/count pairs in various orderings.
 * 
 */

public class WordFrequency {
	public static String number = "0";		
	public static Integer strToNum = 0;
	public static TreeMap<String, Integer> map;
	public static List<String> list;
	public static Map<String, Integer> original;
	public static ArrayList<String> listKey;
	public static ArrayList<Integer> listValue;
	public static Map<String, Integer> frequency;

	public static void main(String[] args) {
		String myfile = "";
		try {

			WordFrequency app = new WordFrequency();
			if(args.length ==0 || args.length == 1) { 
				System.err.printf("Error: Mode and filename expected. %n");
				System.out.println("Usage: java WordFrequency <MODE> [--threshold=NUM] <TEXTFILE>");

				System.out.println("Utility to count the occurences of each word in a text file.");

				System.out.println("MODE is one of:");

				System.out.println("  --by-freq  sort by frequency count, from highest to lowest");
				System.out.println("  --by-word  sort by words, alphabetically");
				System.out.println("  --by-orig  show words in order of first appearance");
			}	
			else if(args.length == 2)
			{
				int i = 0;
				switch(args[0])
				{	
					case "--by-freq":
						myfile = args[1];
						app.execute(myfile);
						SortByWord(list);
						SortByFreq(map);
						PrintFreq(listKey, listValue);
						break;
					case "--by-word":
						myfile = args[1];
						app.execute(myfile);
						SortByWord(list);
						PrintWords(map);
						break;
					case "--by-orig":
						myfile = args[1];
						app.execute(myfile);
						SortByOrig(list);
						PrintWords(original);
						break;
					default:
						break;
				}
			}
			else if(args.length == 3)
			{	
				int i = 0;
				switch(args[0])
				{
					case "--by-freq":
						number = args[1];			
						myfile = args[2];	
						app.execute(myfile);
						SortByWord(list);
						SortByFreq(map);
						PrintFreq(listKey, listValue);
						break;
					case "--by-word":
						number = args[1];
						myfile = args[2];
						app.execute(myfile);
						SortByWord(list);
						PrintWords(map);
						break;
					case "--by-orig":
						number = args[1];
						myfile = args[2];
						app.execute(myfile);
						SortByOrig(list);
						PrintWords(original);
						break;
					default:
						break;
				}
			}
		} catch (IOException e) {
			System.err.printf("Error: %s%n", e.getMessage());
			System.exit(1);
		}
	}

	/* Take out NUM from --threshold=NUM */
	public static void ExtractNumber(String n) {
		n = n.replaceAll("[^0-9]", "");
		strToNum = Integer.valueOf(n);
		return;
	}


	public void execute(String file) throws IOException {	
		ReadFile(file);
	}



	/* Read file and store data into List */
	public void ReadFile(String read) throws IOException {
		Scanner file = new Scanner(new File(read)).useDelimiter("[^A-Za-z']+");
		list = new ArrayList<String>();
		do
		{
			list.add(file.next());
		} while(file.hasNext());
	}



	/* Sort words as found in order of appearance in the text */
	public static void SortByOrig(List<String> list) {
		original = new LinkedHashMap<String, Integer>();
		for(int i=0; i<list.size(); i++) {
			String key = list.get(i).toLowerCase();
			if(list.size() > 1) {
				if(original.get(key) == null) original.put(key, 1);
				else {
					int value = original.get(key).intValue();
					value++;
					original.put(key, value);
				}
			}
		}
	}	


	/*  Sort by words alphabetically */
	public static void SortByWord(List<String> list) {
		map = new TreeMap<String, Integer>();
		for(int i=0; i<list.size(); i++) {
			String key = list.get(i).toLowerCase();
			if(list.size() > 1) {
				if(map.get(key) == null) map.put(key, 1);
				else {
					int value = map.get(key).intValue();
					value++;
					map.put(key, value);
				}
			}
		}
	}


	/* Sort words from most frequent to least frequent */
	/* Use alphabetical order When two words have the same frequency count */
	public static void SortByFreq(TreeMap<String, Integer> map) {
		listKey = new ArrayList<String>();
		listValue = new ArrayList<Integer>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String rKey = entry.getKey();
			Integer rValue = entry.getValue();
			listKey.add(rKey);
			listValue.add(rValue);
		}
		
		for(int i=0; i < map.size() - 1; ++i) {
			for(int j = 1; j < map.size() - i; j++){
				if(listValue.get(j-1) < listValue.get(j)) {
					int tempV = listValue.get(j-1);
					listValue.set(j-1, listValue.get(j));
					listValue.set(j,tempV);

					String tempK = listKey.get(j-1);
					listKey.set(j-1, listKey.get(j));
					listKey.set(j,tempK);
				}
			}
		}

	}


	/* Print words after sorting */
	public static void PrintWords(Map<String, Integer> print) {
		ExtractNumber(number);
		for (Map.Entry<String, Integer> entry : print.entrySet())
			if(entry.getValue() > strToNum)
				System.out.printf("%18s: %d%n", entry.getKey(), entry.getValue());	
	}

	/* Print words after SortByFreq */
	public static void PrintFreq(ArrayList<String> str, ArrayList<Integer> in) {
		ExtractNumber(number);
		for(int i=0; i < str.size(); i++)
			if(in.get(i) > strToNum)
				System.out.printf("%18s: %d%n", str.get(i), in.get(i));	
	}


}

