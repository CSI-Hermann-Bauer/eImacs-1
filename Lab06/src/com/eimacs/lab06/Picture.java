package com.eimacs.lab06;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @version 2.0 (April 25, 2014) IMACS Curriculum Development Group
 */
public class Picture extends SimplePicture
{
      ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int width, int height)
    {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

      ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;
    }

    /**
     * Method to set the blue component to 0
     */
    public void zeroBlue()
    {
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }
    /**
     * fixUnderwater
     */
    public void fixUnderwater()
    {
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(pixelObj.getRed() * 5);
            }
        }
    }
    /**
     * negate
     */

    public void negate()
    {
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(255 - pixelObj.getBlue());
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                
            }
        }
    }
    
    /**
     * grayscale
     */
    
    public void grayscale(){
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
            	int avg = (int)Math.round(pixelObj.getAverage());
                pixelObj.setBlue(avg);
                pixelObj.setRed(avg);
                pixelObj.setGreen(avg);
                
            }
        }
    }
    /**
     * Method that mirrors the left half of a picture onto the
     * right half as though reflecting in a mirror placed on 
     * the vertical center line of the picture
     */
    public void mirrorLeftOntoRight()
    {
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel, rightPixel;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(width - 1) - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public void mirrorTopOntoBottom(){
    	 Pixel[][] pixels = getPixels2D();
         Pixel leftPixel, rightPixel;
         int width = pixels[0].length;
         for (int col = 0; col < width; col++)
         {
             for (int row = 0; row < pixels.length / 2; row++)
             {
                 leftPixel = pixels[row][col];
                 rightPixel = pixels[pixels.length - 1 - row][col];
                 rightPixel.setColor(leftPixel.getColor());
             }
         }
    }
    public void flipLeftAndRight()
    {
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel, rightPixel;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(width - 1) - col];
                Color c = rightPixel.getColor();
                rightPixel.setColor(leftPixel.getColor());
                leftPixel.setColor(c);
            }
        }
    }
    public void fixTemple(){
    	int apexCol = 292;
    	int endCopy = 289;
    	int	startRow = 33;
    	int endRow = 137;
    	int lastPixL = 29;
    	int lastPixR = 560;
    }
} // this } is the end of class Picture, put all new methods before this