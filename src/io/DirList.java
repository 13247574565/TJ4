//: io/DirList.java
package io; /* Added by Eclipse.py */

// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList {
	public static void main(String[] args) {
		File path = new File("F:\\TIJ4\\src\\io");
		String[] list;
		list = path.list(new DirFilter(".java"));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}
/**
 * 回调的意思就是，你实现一个接口（不一定非得是接口），但不去调用这个接口，而是让定义这个接口的一方（这里应该指Java类库）去调用你给的实现。
 * 这里DirFilter.accept(File dir, String name)在File里被FilenameFilter调用
 * @author Administrator
 *
 */
class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {//  dir - 被找到的文件所在的目录。 name - 文件的名称。
		return pattern.matcher(name).find();
	}
} /*
	 * Output: DirectoryDemo.java DirList.java DirList2.java DirList3.java
	 */// :~
