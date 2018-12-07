//: io/SerialCtl.java
package io; /* Added by Eclipse.py */

// Controlling serialization by adding your own
// writeObject() and readObject() methods.

import java.io.*;

public class SerialCtl implements Serializable {
	private static final long serialVersionUID = 3587339559164696206L;
	//非transient字段在defaultWriteObject/defaultReadObject中保存
	//transient字段必须显式保存和恢复 
	private String a;
	private transient String b;

	public SerialCtl(String aa, String bb) {
		a = "Not Transient: " + aa;
		b = "Transient: " + bb;
	}

	public String toString() {
		return a + "\n" + b;
	}

	//这里是添加的方法，不是override，方法签名固定
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(b);
	}
	//这里是添加的方法，不是override，方法签名固定
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Before:\n" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		//序列化执行
		o.writeObject(sc);
		// Now get it back:
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After:\n" + sc2);
	}
} /*
	 * Output: Before: Not Transient: Test1 Transient: Test2 After: Not
	 * Transient: Test1 Transient: Test2
	 */// :~
