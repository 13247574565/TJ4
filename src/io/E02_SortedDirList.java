package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class SortedDirList {
	private File file;

	public SortedDirList() {
		file = new File("F:\\TIJ4\\src\\io");
	}

	public SortedDirList(File file) {
		this.file = file;
	}

	public String[] list() {
		String[] list = file.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
	
	public String[] list(final String path) {
		String[] list = file.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(path);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
}

public class E02_SortedDirList{
	public static void main(String args[]) {
//		SortedDirList dir = new SortedDirList();
		SortedDirList dir = new SortedDirList(new File("F:\\TIJ4\\src\\io"));
		
		System.out.println(Arrays.asList(dir.list("E0[123]_.*\\.java")));
		}
}

