//: io/DirList3.java
package io; /* Added by Eclipse.py */

// Building the anonymous inner class "in-place."
// {Args: "D.*\.java"}

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList3 {
	public static void main(final String[] args) {
		File path = new File(".");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);

				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.asList(list));;
	}
} /*
	 * Output: DirectoryDemo.java DirList.java DirList2.java DirList3.java
	 */// :~
