//: io/ChannelCopy.java
package io; /* Added by Eclipse.py */

// Copying a file using channels and buffers
// {Args: ChannelCopy.java test.txt}

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class ChannelCopy {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		//只读访问，需要显式使用allocate()/allocateDirect()分配字节缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			buffer.flip(); // Prepare for writing
			out.write(buffer);
			buffer.clear(); // Prepare for reading
		}
	}
} /// :~
