package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E07_FileIntoList {
	public static List<String>
	read(String filename) throws IOException {
		LinkedList<String> list = new LinkedList<>();
		String s;
		
		BufferedReader bReader = new BufferedReader(new FileReader(filename));
		
		while ((s=bReader.readLine())!=null) {
			list.add(s);
		}
		bReader.close();
		return list;
	}
	
	public static void main(String[] args) {
		try {
			List<String> list = read("F:\\TIJ4\\src\\io\\E07_FileIntoList.java");
			for (ListIterator<String> iterator =  list.listIterator(list.size());iterator.hasPrevious();) {
				System.out.println(iterator.previous());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
