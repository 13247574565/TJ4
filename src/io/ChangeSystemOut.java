//: io/ChangeSystemOut.java
package io; /* Added by Eclipse.py */

// Turn System.out into a PrintWriter.

import java.io.*;

public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		out.println("Hello, world");
		out.flush();
	}
} /*
	 * Output: Hello, world
	 */// :~
