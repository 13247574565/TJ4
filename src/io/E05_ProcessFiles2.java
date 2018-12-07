package io;

import java.io.File;
import java.io.IOException;

import net.mindview.util.Directory;
import net.mindview.util.ProcessFiles;

class ProcessFiles2 {
	public interface Strategy {
		void process(File file);
	}

	private ProcessFiles.Strategy strategy;
	private String reg;

	public ProcessFiles2(ProcessFiles.Strategy strategy, String reg) {
		this.strategy = strategy;
		this.reg = reg;
	}

	public void start(String[] args) {
		try {
			System.out.println(new File(".").getCanonicalPath());
			if (args.length == 0)
				processDirectoryTree(new File("."));
			else
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						if (arg.matches(reg)) {
							processDirectoryTree(fileArg.getCanonicalFile());
						}
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), reg))
			strategy.process(file.getCanonicalFile());
	}

}

public class E05_ProcessFiles2 {
// Demonstration of how to use it:
public static void main(String[] args) {
	new ProcessFiles(new ProcessFiles.Strategy() {
		public void process(File file) {
			System.out.println(file);
		}
	}, "java").start(args);
}
}
