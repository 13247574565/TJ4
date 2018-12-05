//: io/UsingBuffers.java
package io; /* Added by Eclipse.py */

import java.nio.*;
import static net.mindview.util.Print.*;

public class UsingBuffers {
	private static void symmetricScramble(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			buffer.mark();//mark设置为position
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();//将mark设置为position
			//put()跟get()方法都会使position位置往前移
			buffer.put(c2).put(c1);
		}
	}

	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		//打印缓冲器只能打印position跟limit之间的内容，所以调用rewind将position设置为起始位置，调用后mark则变为不明确
		print(cb.rewind());
		symmetricScramble(cb);
		print(cb.rewind());
		symmetricScramble(cb);
		print(cb.rewind());
	}
} /*
	 * Output: UsingBuffers sUniBgfuefsr UsingBuffers
	 */// :~
