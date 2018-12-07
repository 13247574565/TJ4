package io;
import java.io.*;
import static net.mindview.util.Print.*;

class Blip9 implements Externalizable {
	public Blip9() {
		print("Blip9 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		print("Blip9.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		print("Blip9.readExternal");
	}
}

public class E28_BlipCheck implements Externalizable {
//	 E28_BlipCheck() {
//	 print("BlipCheck Constructor");
//	 }
	public void writeExternal(ObjectOutput out) throws IOException {
		print("E28_BlipCheck.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		print("E28_BlipCheck.readExternal");
	}

	public static void main(String[] args) throws Exception {
		// To make it run with Ant.
		Blips.main(args);
	}
}

class Blips1 {
	// Throw exceptions to console:
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		print("Constructing objects:");
		Blip9 b1 = new Blip9();
		E28_BlipCheck b2 = new E28_BlipCheck();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
		print("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
		print("Recovering b1:");
		b1 = (Blip9) in.readObject();
		// OOPS! Throws an exception:
		print("Recovering b2:");
		b2 = (E28_BlipCheck) in.readObject();
	}
}