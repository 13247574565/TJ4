package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.mindview.util.TextFile;

public class E01_SearchWords {
	public static void main(final String[] args) {
		File path = new File("F:\\TIJ4");
		String[] param = new String[]{".txt"};
		String[] list;
		if (param.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private String ext = param[0].toLowerCase();

				public boolean accept(File dir, String name) {
					// Only analyze source files with the specified // extension
					// (given as the first command line // argument)
					if (name.toLowerCase().endsWith(ext)) {
						// Only filter upon file extension?
						if (param.length == 1){
							return true;
						}
						Set<String> words = new HashSet<String>(
								new TextFile(new File(dir, name).getAbsolutePath(), "\\W+"));
						for (int i = 1; i < param.length; i++)
							if (words.contains(param[i]))
								return true;
					}
					return false;
				}
			});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}
