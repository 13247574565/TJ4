//: io/GZIPcompress.java
package io; /* Added by Eclipse.py */

// {Args: GZIPcompress.java}

import java.util.zip.*;

import static net.mindview.util.Print.print;

import java.io.*;

public class GZIPcompress {
	public static void main(String[] args) throws IOException {
		
//		if (args.length == 0) {
//			System.out.println(
//					"Usage: \nGZIPcompress file\n" + "\tUses GZIP compression to compress " + "the file to test.gz");
//			System.exit(1);
//		}
//		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		
//		BufferedReader in = new BufferedReader(new FileReader("./test/aaaa.txt"));
//		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("./test/test.zip")));
//		System.out.println("Writing file");
//		int c;
//		while ((c = in.read()) != -1)
//			out.write(c);
//		in.close();
//		out.close();
//		System.out.println("Reading file");
//		BufferedReader in2 = new BufferedReader(
//				new InputStreamReader(new GZIPInputStream(new FileInputStream("./test/test.zip"))));
//		String s;
//		while ((s = in2.readLine()) != null)
//			System.out.println(s);
		
		
		
		
		BufferedReader in = new BufferedReader(new FileReader("./test/aaa.txt"));
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("./test/test.zip"));
		zos.putNextEntry(new ZipEntry("./test/aaa.txt"));
		BufferedOutputStream out = new BufferedOutputStream(zos);
		System.out.println("Writing file");
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream("./test/test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream ziStream =  new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(ziStream);
		ZipEntry ze;
		while ((ze = ziStream.getNextEntry()) != null) {
			print("Reading file " + ze);
			int x;
			while ((x = bis.read()) != -1)
				System.out.write(x);
		}
		
		
		
		
		
		
	}
} /* (Execute to see output) */// :~
