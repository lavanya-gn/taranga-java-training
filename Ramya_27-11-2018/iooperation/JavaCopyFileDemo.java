package com.tharanga.iooperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class JavaCopyFileDemo {

	public static void main(String[] args) throws InterruptedException,
			IOException {

		File source = new File("D:\\a.txt");
		File dest = new File("D:\\b.txt");

		// copy file using FileStreams
		long start = System.nanoTime();
		long end;
		copyFileUsingFileStreams(source, dest);
		System.out.println("Time taken by FileStreams Copy = "
				+ (System.nanoTime() - start));

		// copy files using java.nio.FileChannel
		source = new File("D:\\c.txt");
		dest = new File("D:\\testin.txt");
		start = System.nanoTime();
		copyFileUsingFileChannels(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by FileChannels Copy = " + (end - start));

		// copy file using Java 7 Files class
		source = new File("D:\\d.txt");
		dest = new File("D:\\out.txt");
		start = System.nanoTime();
		copyFileUsingJava7Files(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by Java7 Files Copy = " + (end - start));
/*
		// copy files using apache commons io
		source = new File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile4.txt");
		dest = new File("C:\\Users\\nikos7\\Desktop\\files\\destfile4.txt");
		start = System.nanoTime();
		copyFileUsingApacheCommonsIO(source, dest);
		end = System.nanoTime();
		System.out.println("Time taken by Apache Commons IO Copy = "
				+ (end - start));   */

	}

	private static void copyFileUsingFileStreams(File source, File dest)
			throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
	}

	private static void copyFileUsingFileChannels(File source, File dest)
			throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	private static void copyFileUsingJava7Files(File source, File dest)
			throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}
/*
	private static void copyFileUsingApacheCommonsIO(File source, File dest)
			throws IOException {
		FileUtils.copyFile(source, dest);
	}
*/
}