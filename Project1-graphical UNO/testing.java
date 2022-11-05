import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image
import java.lang.Math;
public class testing
{
  
  static Console c;
  static Console d;
  
  public static void main (String[] args)
  {
    c=new Console(75,100);
  d=new Console(75,100);
  
    cardPrinter1("winner.png",200,200);
      cardPrinter2("loser.png",150,100);
  }
   public static void cardPrinter1 (String x, int xy,int y)
  {
    
    Image img;  //The image to draw
    
    //Try to import the image from the file
    
    try{
      
      img = ImageIO.read(new File(x));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    
    
    //Draw the image (Image, x location, y location, null)
    
    c.drawImage(img,xy,y,null);
    
  }
  
  public static void cardPrinter2 (String x, int xy,int y)
  {
    
    Image img;  //The image to draw
    
    //Try to import the image from the file
    
    try{
      
      img = ImageIO.read(new File(x));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    
    
    //Draw the image (Image, x location, y location, null)
    
    d.drawImage(img,xy,y,null);
    
  }}