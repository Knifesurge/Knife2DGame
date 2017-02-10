package com.knifesurge.knife2dgame.handlers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileHandler {

	/**
	 * Reads in an internal (in the JAR file) file to be used by the game
	 * @param path - The path to the file to be loaded
	 */
	public static String readInternalFile(String path)
	{
		return readFile(new File(FileHandler.class.getClassLoader().getResource(path).getFile()));
	}
	/**
	 * Reads in an external (outside of the JAR file) file to be used by the game
	 * @param path - The path to the file to be loaded 
	 */
	public static String readExternalFile(String path)
	{
		return readFile(new File(path));
	}
	/**
	 * Read in a text file
	 * @param file - The file to be read in
	 */
	public static String readFile(File file)
	{
		StringBuilder src = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (IOException ex)
		{
			ex.printStackTrace();
			System.err.println("Error: Failed to read file " + file);
			System.exit(1);
		} finally
		{
			if(reader != null)
			{
				try{
					reader.close();
				} catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return src.toString();
	}
	/**
	 * Read in an image
	 * @param path - The path to the image to be read
	 */
	public BufferedImage readImage(String path)
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e){
			e.printStackTrace();
		}
		return image;
	}
}
