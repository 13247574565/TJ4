//: io/ZipCompress.java
package io; /* Added by Eclipse.py */

// Uses Zip compression to compress any
// number of files given on the command line.
// {arr: ZipCompress.java}

import java.util.zip.*;
import java.io.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class ZipCompress {
	public static void main(String[] args) throws IOException {
		FileOutputStream f = new FileOutputStream("./test/testZip.zip");
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");//设置压缩文件注释
		String[] arr = {"./test/aaa.txt","./test/bbb.txt"};
		// No corresponding getComment(), though.
		for (String arg : arr) {
			print("Writing file " + arg);
			//设置流的同时要给ZipOutputStream设置ZipEntry对象不然要报错no current ZIP entry
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.flush();
		}
		out.close();
		// Checksum valid only after the file has been closed!
		print("Checksum: " + csum.getChecksum().getValue());
		// Now extract the files:
		print("Reading file");
		FileInputStream fi = new FileInputStream("./test/testZip.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while ((ze = in2.getNextEntry()) != null) {
			print("Reading file " + ze);
			int x;
			while ((x = bis.read()) != -1){
				System.out.write(x);
			}
				
		}
		if (arr.length == 1)
			print("Checksum: " + csumi.getChecksum().getValue());
		bis.close();
		// Alternative way to open and read Zip files:
		ZipFile zf = new ZipFile("./test/testZip.zip");
		Enumeration e = zf.entries();
		while (e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry) e.nextElement();
			print("File: " + ze2);

			// ... and extract the data as before
		}
		/* if(arr.length == 1) */
	}
} /* (Execute to see output) */// :~
