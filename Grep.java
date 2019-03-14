

/**
 * LEGrep.java
 * 
 * Version:
 * $1.0$
 * 
 */

/**
 * A program implementing subset of grep's functionality
 * 
 * @author Aravind Vicinthangal Prathivaathi
 * @author Aishwarya Sunil Sawant
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * The functional interface to implement lambda expressions.
 * 
*/
interface Lambda{
	void variance(String filename, String line, int count);
}

/**
 * The class that implements the Grep's functionalities.  
**/
public class LEGrep {
	static final String PRECEDENCE = "wqlc";
	/**
	 * The method that implements (word) <File-Name> - <File-Name> feature.
	 * 
	 * @return void
	**/
	void findLine(String regEx, String[] fname, Lambda l) {
		
		for (int i = 0; i < fname.length; i++) {

			if (fname[i] != null) {
				if (fname[i].equals("-")) {

					Scanner inp = new Scanner(System.in);
					String input = inp.next();
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher(input);

					// if we find a match, get the group
					if (matcher.find()) {
						// we're only looking for one group, so get it
//						String theGroup = matcher.group(1);
//						count++;
						// print the group out for verification
						System.out.println(regEx + "\n" + "(Standard Input): " + input);
					}

				} else {
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher("");

					File f = new File(fname[i]);
					try {
						FileReader fr = new FileReader(f.getAbsolutePath());
						BufferedReader br = new BufferedReader(fr);
						String line;
						while ((line = br.readLine()) != null) {
							matcher.reset(line);
							if (matcher.find()) {
//								count++;
//								System.out.println(fname[i] + ": " + line);
								l.variance(fname[i], line , 0);
							}

						}
					} catch (IOException io) {
						System.out.println("The file cannot be opened");
					}
				}
			}
		}
//		System.out.println(count);


	}
	/**
	 * Method which counts the number of occurrences of a word in multiple files
	 * 
	 * @param regEx the word whose occurrence is to be counted fname array of files
	 *              which is checked for the word
	 * @return void
	 * 
	 */
	void count(String regEx, String[] fname, Lambda l) {
		int count = 0;

		for (int i = 0; i < fname.length; i++) {

			if (fname[i] != null) {
				if (fname[i].equals("-")) {

					Scanner inp = new Scanner(System.in);
					String input = inp.next();
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher(input);

					// if we find a match, get the group
					if (matcher.find()) {
						// we're only looking for one group, so get it
						String theGroup = matcher.group(1);
						count++;
						// print the group out for verification
						System.out.println(regEx + "\n" + "(Standard Input): " + input);
					}

				} else {
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher("");

					File f = new File(fname[i]);
					try {
						FileReader fr = new FileReader(f.getAbsolutePath());
						BufferedReader br = new BufferedReader(fr);
						String line;
						while ((line = br.readLine()) != null) {
							matcher.reset(line);
							if (matcher.find()) {
								count++;
							}

						}
					} catch (IOException io) {
						System.out.println("The file cannot be opened");
					}
				}
			}
		}
		l.variance("", "" , count);

	}

	/**
	 * Method which performs a match for a word and prints the name of the file in
	 * which the word is found
	 * 
	 * @param regEx the word whose occurrence is to be checked in a file fname array
	 *              of files which is checked for the word
	 * @return void
	 * 
	 */
	void list(String regEx, String[] fName, Lambda l) {

		for (int i = 0; i < fName.length; i++) {
			if (fName[i] != null) {
				if (fName[i].equals("-")) {

					Scanner inp = new Scanner(System.in);
					String input = inp.next();
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher(input);

					// if we find a match, get the group
					if (matcher.find()) {
						// we're only looking for one group, so get it
						String theGroup = matcher.group(1);
//						count ++;
						// print the group out for verification
						System.out.println(regEx + "\n" + "(Standard Input): " + input);
					}

				} else {

					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher("");

					File f = new File(fName[i]);
					int flag = 0;
					try {
						FileReader fr = new FileReader(f.getAbsolutePath());
						BufferedReader br = new BufferedReader(fr);
						String line;
						while ((line = br.readLine()) != null) {
							matcher.reset(line);
							if (matcher.find()) {
								flag = 1;
							}

						}
						if (flag == 1) {
							System.out.println(f.getName());
						}
					} catch (IOException io) {
						System.out.println("The file cannot be opened");
					}

				}

			}
		}

	}

	/**
	 * Method which performs an exact match for the word
	 * 
	 * @param regEx the word whose occurrence is to be checked in a file fname array
	 *              of files which is checked for the word
	 * @return String
	 * 
	 */
	String word(String regEx, String[] fName, Lambda l) {
		String newRegEx = "\\b" + regEx + "\\b";
		for (int i = 0; i < fName.length; i++) {
			if (fName[i] != null) {
				if (fName[i].equals("-")) {

					Scanner inp = new Scanner(System.in);
					String input = inp.next();
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher(input);

					// if we find a match, get the group
					if (matcher.find()) {
						// we're only looking for one group, so get it
						String theGroup = matcher.group(1);
//						count++;
						// print the group out for verification
						System.out.println(regEx + "\n" + "(Standard Input): " + input);
					}

				} else {

					Pattern pattern = Pattern.compile(newRegEx);
					Matcher matcher = pattern.matcher("");

					File f = new File(fName[i]);
					try {
						FileReader fr = new FileReader(f.getAbsolutePath());
						BufferedReader br = new BufferedReader(fr);
						String line;
						while ((line = br.readLine()) != null) {
							matcher.reset(line);
							if (matcher.find()) {
								System.out.println(line);
							}

						}
					} catch (IOException io) {
						System.out.println("The file cannot be opened");
					}

				}
			}

		}
		return newRegEx;
	}

	/**
	 * Method used to exit once a match is found
	 * 
	 * @param regEx the word whose occurrence is to be checked in a file fname array
	 *              of files which is checked for the word * @return void
	 * @return void
	 * 
	 */
	void quit(String regEx, String[] fName, Lambda l) {

		for (int i = 0; i < fName.length; i++) {
			if (fName != null) {
				Pattern pattern = Pattern.compile(regEx + "\\s");
				Matcher matcher = pattern.matcher("");

				File f = new File(fName[i]);
				try {
					FileReader fr = new FileReader(f.getAbsolutePath());
					BufferedReader br = new BufferedReader(fr);
					String line;
					while ((line = br.readLine()) != null) {
						matcher.reset(line);
						if (matcher.find()) {
							System.exit(0);
						}

					}
					System.exit(1);
				} catch (IOException io) {
					System.out.println("The file cannot be opened");
				}

			}

		}
	}

	/**
	 * Main method : Checks for the command used to implement the grep functionality
	 * and implements the given functionalities if the command was correct.
	 * 
	 * @throws IOException @param args @throws
	 * @param args command line arguments (ignored)
	 */
	public static void main(String args[]) throws IOException {
		LEGrep g = new LEGrep();
		String[] options = new String[args.length];
		String[] fileName = new String[args.length];
		int index = 2;
		int j = 0;
		int k = 0;
		int flag = 0;
		for (int i = 0; i < args.length; i++) {
			if (Pattern.matches("-[lqwc]", args[i])) {
				//Adding options
				options[PRECEDENCE.indexOf(args[i].substring(1))] = args[i].substring(1);
				j++;
				index++;
				flag = 1;
			}
			if (i + 1 > index) {
				//Adding file name
				fileName[k] = args[i];
				k++;
			}

		}

		String regEx = args[index - 1];
		boolean mark = true;
		for (int i = 0; i < options.length; i++) {
			if (options[i] != null) {
				mark = false;
				if (options[i].equals("w")) {
					Lambda l = (String filename, String line, int count) -> {System.out.println(filename);}  ;
					regEx = g.word(args[index - 1], fileName, l);
					continue;
				}
				switch (options[i]) {
				case "l":{
					Lambda l = (String filename, String line, int count) -> {System.out.println(filename + ": " + line);}  ;
					g.list(regEx, fileName, l);
					System.exit(0);
					break;
				}
				case "c":
				{
					Lambda l = (String filename, String line, int count) -> {System.out.println(count);}  ;
					g.count(regEx, fileName, l);
					System.exit(0);
					break;
				}
				case "w":
				{
					Lambda l = (String filename, String line, int count) -> {System.out.println(filename);}  ;
					g.word(regEx, fileName, l);
					System.exit(0);
					break;
					
				}
				case "q":
					Lambda l = (String filename, String line, int count) -> {System.exit(1);}  ;
					g.quit(regEx, fileName, l);
					break;

				}
			}

		}
		if (mark) {
			Lambda l = (String filename, String line, int count) -> {System.out.println(line);}  ;
			g.findLine(regEx, fileName, l);
		}
	}
}
