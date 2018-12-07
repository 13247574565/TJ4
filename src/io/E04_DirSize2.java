package io;

import java.io.File;

import net.mindview.util.Directory;

public class E04_DirSize2 {
	public static void main(String[] args) {
		Directory.TreeInfo treeInfo;
		if (args.length  == 0) {
			treeInfo = Directory.walk(".");
		} else {
			treeInfo = Directory.walk(".", args[0]);
		}
		long total = 0;
		for (File file : treeInfo) {
			total += file.length();
		}
		
		System.out.println("Total length:"+ total);
	}
}
