package com.luedders.server;

import java.awt.Button;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

/*=====================================================================
 * parkingLotImage
 * A class that is used to hold the bufferedImage of a parking lot
 * image
 *=====================================================================*/
public class parkingLotImage
{
	//the actual image being stored
	public BufferedImage lotImage;
	public static boolean isReading = false;
	
	/*==============================================================
	 * default constructor
	 * Input: filename of image (String)
	 * Output: reads the file and stores it in a bufferedimage
	 * Return: None
	 * The constructor takes as an argument, the filename of an
	 * image, then reads the image in from the file as a bufferedImage.
	 *==============================================================*/
	parkingLotImage(String fileName) throws Exception
	{
		//enable this to go on Linux host!
		//String fullName = "/usr/local/tomcat/webapps/thesisApp/" + fileName;
		//for the laptop - hosted
		//String fullName = "C:/Users/Ryan Luedders/workspace/gwtThesis/www/com.luedders.thesisApp/" + fileName;
		//for the laptop - tomcat
		String fullName = "C:/xampp/tomcat/webapps/thesisApp/" + fileName;
		//read image in from file.
		lotImage = readAsBufferedImage(fullName);
	}
	
	/*==============================================================
	 * getHeight - gets the height of the image
	 * Input: none
	 * Output: none
	 * Return: the height of the image (int)
	 * This method uses the stored bufferedimage of the parking lot
	 * and returns the height, using the bufferedimage getheight method
	 *==============================================================*/
	public int getHeight()
	{
		//call the bufferedimage getheight method.
		return lotImage.getHeight();
	}
	
	/*==============================================================
	 * readAsBufferedImage - reads a file to a buffered image
	 * Input: filename (string)
	 * Output: none
	 * Return: the image from the file (Bufferedimage)
	 * This method takes a filename as an argument, then accesses the
	 * file and returns the image contents of the file, as a
	 * bufferedImage
	 *==============================================================*/
	public BufferedImage readAsBufferedImage(String filename) throws Exception
	{
		File f = new File(filename);
		FileImageInputStream fIn = new FileImageInputStream(f);
		BufferedImage rd = ImageIO.read(fIn);
		
		return rd;
	}
}
