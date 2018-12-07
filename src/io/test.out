//: io/Redirecting.java
package io; /* Added by Eclipse.py */

// Demonstrates standard I/O redirection.

import java.io.*;

public class Redirecting {
	public static void main(String[] args) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(".\\src\\io\\Redirecting.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(".\\src\\io\\test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);//将"Redirecting.java"文件的内容写入"test.out"文件 
		out.close(); // Remember this!
	}
} /// :~
