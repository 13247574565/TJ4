//: io/GetChannel.java
package io; /* Added by Eclipse.py */

// Getting channels from streams

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		// Write a file:
		FileChannel fc = new FileOutputStream(".\\src\\io\\data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		fc.close();
		
		// Add to the end of the file:
		fc = new RandomAccessFile(".\\src\\io\\data.txt", "rw").getChannel();
		fc.position(fc.size()); // Move to the end
		fc.write(ByteBuffer.wrap("Some more".getBytes()));//wrap()将一个字节数组封装到一个缓冲区中
		fc.close();
		// Read the file:
		fc = new FileInputStream(".\\src\\io\\data.txt").getChannel();
		//只读访问，需要显式使用allocate()/allocateDirect()分配字节缓冲区
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);//分配一个新的字节缓冲区
		fc.read(buff);//从通道往缓冲区存储字节
		buff.flip();
		while (buff.hasRemaining())
			System.out.print((char) buff.get());
	}
} /*
	 * Output: Some text Some more
	 */// :~
