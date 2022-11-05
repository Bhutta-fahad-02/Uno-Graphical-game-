import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image
import java.lang.Math;
public class drawingImages1
{
  
  static Console c;
  static Console d;
  
  public static void main (String[] args)
  {
//***********Constants********************************
    boolean runLoop=false;
    String latest="";
    String latestPlayer1="";
    String latestPlayer2="";
    String cardName1="";
    String cardName2="";
    int xy=0;
    c = new Console(75,100);
    String userName="";
    char enter=' ';
    String cardNumbers="0123456789";
    boolean block1=false;
    boolean block2= false;
    int cardNum=0;
    String cardColour2="";
    String colours2="";
    String cardColour="";
    Player player1= new Player ();
    Player player2 = new Player();
    String colours="";
    
    c.println("Welcome to Uno! The rules are the following:");
    c.println("\nThe game starts off with a selection of 7 cards from the card deck.");
    c.println("The cards left over will be used as the rescue deck"); 
    c.println("After the cards have been distributed the first card on the deck is flipped and the first player takes their turn.");
    c.println("If a player doesn’t have a card that they can put down they take one card from the deck"); 
    c.println("Each player plays on until one player runs out of cards. That person wins the game.");
    
    c.println("\nPress enter to continue ");
    enter = c.readChar();
    c.clear();
    c.println("7 cards have been distrubuted, hit enter to turn them over");
    
    c.println(" ___ " + "" + " ___ " + " ___ " + "" + " ___" + "  ___ " + "" + " ___ " + " ___ ");
    c.println("|   |" + "" + "|   |" + "|   |" + "" + "|   |" + "|   |" + "" + "|   |" + "|   |");
    c.println("|   |" + "" + "|   |" + "|   |" + "" + "|   |" + "|   |" + "" + "|   |" + "|   |");
    c.println("|___|" + "" + "|___|" + "|___|" + "" + "|___|" + "|___|" + "" + "|___|" + "|___|");
    c.println("please hit enter");
    c.clear();
    d= new Console(75,100);
    c.println("\nThese are your cards:");
    d.println("\nThese are your cards:");
    
    
    
    //randomizerRed=(int)(Math.random()*0+10);
    
    int numbers; //INITILZEE ON TOP
    numbers=(int)(Math.random()*9+1);
    
    colours=player1.colourMaker(colours);
    colours2=player2.colourMaker(colours2);
    String cardz1=(String)(colours+numbers+".png");
    String cardz=(String)(colours2+numbers+".png");
    latest = (String)(colours+numbers);
    cardPrinter1(cardz1,350,400);
    cardPrinter2(cardz,350,400);
    
    
    for (int x=0; x<=6; x++)
    { 
      cardName1=player1.showCards()[x];
      cardName2=player2.showCards()[x];
      for (double xs=0; xs<100000; xs++)
      {
      } 
      cardPrinter1(cardName1 + ".png",xy,100);
      cardPrinter2(cardName2 + ".png",xy,100); 
      
      xy+=100;
    }// end of loop
    
    while (!player1.showCards()[0].equals("") && !player2.showCards()[0].equals(""))
    {
      if (block2==false)
      {
      c.println("1 or 2");
      int choice=c.readInt();
      if (choice == 1)
      {
        c.println("choose which card to put Ex(1 for first card) ");
        cardNum=c.readInt();
        runLoop=false;
    
      while (runLoop==false) 
      {
        String x=player1.showCards()[cardNum-1];
        // checks if the 
        
        if (x.substring(0,3).equals("red"))
        {
          
          cardColour="red";
        }
        else if (x.substring(0,4).equals("blue"))
        {
          cardColour="blue";
        }
        else if (x.substring(0,5).equals("green"))
        {
          cardColour="green";
        }
        else if (x.substring(0,6).equals("yellow"))
        {
          cardColour="yellow";
        }
        else 
        {
          cardColour="black";
        }         
        String pickedCard=player1.showCards()[cardNum-1];
          int index1=cardColour.length();
          int index2=pickedCard.length();
          String numbers1=pickedCard.substring(index1,index2);
             
          int cardNumber=Integer.parseInt(numbers1);
        if (colours.equals(cardColour) || cardColour.equals("black"))
        {
          if (cardNumber==10 || cardNumber==11)
          {
            block1=true;
            d.println(" too bad you got blocked");
          }
          else if (cardNumber==12)
          {
            block1=true;
            for(int i = 0; i < 2; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player2.colourMaker(colours);
              String drawCard=(String)(drawColours+drawNum);
              player2.addCard(drawCard);
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else if (cardColour=="black")
          {
            if (cardNumber==1)
            {
            block1=true;
            for(int i = 0; i < 4; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player2.colourMaker(colours);
              String drawCard=(String)(drawColours+drawNum);
              player2.addCard(drawCard);
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else 
          {
            c.println("what colour do you want to change it to?");
            String colour=c.readString();
            colours=colour;
            //if (!colour.equals(
          }
          
          runLoop=true;
          putCards(cardNum);
          latest=player1.showCards()[cardNum-1];
          player1.removeCard(cardNum-1);
          colours = cardColour;
          numbers=cardNumber;
          
          refresh(player1.showCards(), player2.showCards(), latest);
        }
        
        else 
        {

            if ((int)(cardNumber)==numbers)
            {
              
              //putCards(cardNum);
              
              latestPlayer1=player1.showCards()[cardNum-1];
              player1.removeCard(cardNum-1);
             
              refresh(player1.showCards(),player2.showCards(), latestPlayer1);
              runLoop=true;
              colours = cardColour;
              numbers = cardNumber;
              
              
            }
            
            
            else 
            {
              runLoop=false;
              c.clear();
              refresh(player1.showCards(),player2.showCards(), latest);;
              cardPrinter1(cardz,350,400);
              cardPrinter2(cardz,350,400);
              c.println ("invalid card,please try again");
              cardNum=c.readInt();
//            
            
            
          }
           
          //} 
          
        }
//        String pickedNum = player1.showCards()[cardNum-1];
//     
//      for (int x=0; x<pickedNum[cardNum-1]; x++)
//      {
//        for (intx; x<
//        
//        if ( (int)pickedNum.charAt(x)==1
//      
//      {
//        
//      }
      }
      }
      }
      else{
        int drawNum =(int)(Math.random()*9+1);
        String drawColours=player1.colourMaker(colours);
        String drawCard=(String)(drawColours+drawNum);
        player1.addCard(drawCard);
        refresh(player1.showCards(), player2.showCards(), latest);
        
        /*for (int x = 0; x <= 29; x++)
        {
          c.println(player1.showCards()[x]);
        }*/
      }
      }
      block2 = false;
      
      
      if (block1==false)
      {
      d.println("1 or 2");
      int choice=d.readInt();
      if (choice == 1)
      {
    
      // plus2Cards (cards,xy);
      d.println("choose which card to put Ex(1 for first card) ");
      cardNum=d.readInt();
      runLoop=false;
     while (runLoop==false) 
      {
        String x=player2.showCards()[cardNum-1];
        // checks if the 
        
        if (x.substring(0,3).equals("red"))
        {
          
          cardColour2="red";
        }
        else if (x.substring(0,4).equals("blue"))
        {
          cardColour2="blue";
        }
        else if (x.substring(0,5).equals("green"))
        {
          cardColour2="green";
        }
        else if (x.substring(0,6).equals("yellow"))
        {
          cardColour2="yellow";
        }
        else 
        {
          cardColour2="black";
        }         
        String pickedCard=player2.showCards()[cardNum-1];
          int index1=cardColour2.length();
          int index2=pickedCard.length();
          String numbers1=pickedCard.substring(index1,index2);
             
          int cardNumber=Integer.parseInt(numbers1);
        if (colours2.equals(cardColour) || colours.equals("black"))
        {
          if (cardNumber==10 || cardNumber==11)
          {
            block2=true;
            c.println(" too bad you got blocked");
          }
          else if (cardNumber==12)
          {
            block2=true;
            for(int i = 0; i < 2; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player1.colourMaker(colours2);
              String drawCard=(String)(drawColours+drawNum);
              player1.addCard(drawCard);
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else if (cardColour=="black" && cardNumber==1)
          {
            block2=true;
            for(int i = 0; i < 4; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player1.colourMaker(colours2);
              String drawCard=(String)(drawColours+drawNum);
              player1.addCard(drawCard);
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else if (cardColour=="black")
          {
            cardColour2=cardColour;
            d.println(cardColour+" is now the colour");
           
          runLoop=true;
          putCards(cardNum);
          latest=player2.showCards()[cardNum-1];
          player2.removeCard(cardNum-1);
          colours2 = cardColour2;
          numbers=cardNumber;
              
          refresh(player1.showCards(), player2.showCards(), latest);
          
         
            
          }
        }
        
        else 
        {
          
            
            if ((int)(cardNumber)==numbers)
            {
              
              //putCards(cardNum);
              
              latestPlayer2=player2.showCards()[cardNum-1];
              player2.removeCard(cardNum-1);
             
              refresh(player1.showCards(),player2.showCards(), latestPlayer2);
              runLoop=true;
              colours2 = cardColour2;
              numbers = cardNumber;
              
              
            }
            else 
            {
              runLoop=false;
             // d.clear();
              //refresh(player1.showCards(),player2.showCards(), latest);
              cardPrinter1(cardz,350,400);
              cardPrinter2(cardz,350,400);
              d.println ("invalid card,please try again");
              cardNum=d.readInt();
          }
          //} 
          
        }
        
//        String pickedNum = player2.showCards()[cardNum-1];
//     
//      for (int x=0; x<pickedNum[cardNum-1]; x++)
//      {
//        for (intx; x<
//        
//        if ( (int)pickedNum.charAt(x)==1
//      
//      {
//        
//      }
      }
      }
       
      else{
        int drawNum =(int)(Math.random()*9+1);
        String drawColours=player2.colourMaker(colours);
        String drawCard=(String)(drawColours+drawNum);
        player2.addCard(drawCard);
        refresh(player1.showCards(), player2.showCards(), latest);
        
        /*for (int x = 0; x <= 29; x++)
        {
          c.println(player1.showCards()[x]);
        }*/
      }
      }
//      else
//      {
//      }      
      //block1 = false;
    }
    
    
    
  
    
  }
  
  
  
  
  
  
  
//************************************************************************************************
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
    
  }
//************************************************************************************************
  public static void refresh (String[] cards1, String[] cards2, String latest)
{
  c.clear();
  d.clear();
  
  int x = 0;
  int level=0;
  int y=125;
  for (int position = 0; position <= 29; position++)
  {
    cardPrinter1(cards1[position] + ".png", x, y);
    cardPrinter2(cards2[position] + ".png", x, y);
    if (x>=700)
    {
      x = 0;
      
      y+=150;
      
    }
    else
    x += 100;
  }//rof
  
  cardPrinter1(latest + ".png", 350, 425);
  cardPrinter2(latest + ".png", 350, 425);
  
}//Method refresh
//************************************************************************************************
  public static void putCards (int i)
  {
    c.println(i+" card was played ");
    
  }  
//************************************************************************************************
  
//************************************************************************************************
  
  
//************************************************************************************************
//  public static void plus2Cards ( String[] cards, int xy)
//  {
//    int blackRandom=0;
//    int random=0;
//    String y="";
//    String extraCards;
//    String cardName="";
//  for (int x=0; x<28; x++)
//    
//  {
//    cardPrinter (cardName+".png",xy,100);
//     
//    xy+=100;
//    blackRandom=(int)(Math.random()*2+1);
//    random=(int)(Math.random()*12+1);
//    y= player1.colourMaker(y);
//    c.println(x);
//    if (cards[x].equals("green12"))
//    {
//      if (y.equals("black"))
//      {
//       cardName=(String)(y+blackRandom);
//        cards[x]=cardName;
//        cardPrinter (cardName+".png",xy,100);
//      }
//      else
//      {
//      cardName=(String)(y+random);
//        cards[x]=cardName;
//      cardPrinter (cardName+".png",xy,100);
//      }
//    }
//   else  if (cards[x+1].equals("blue12"))
//    {
//      if (y.equals("black"))
//      {
//       cardName=(String)(y+blackRandom);
//        cards[x]=cardName;
//        cardPrinter (cardName+".png",xy,100);
//      }
//      else
//      {
//      cardName=(String)(y+random);
//        cards[x]=cardName;
//      cardPrinter (cardName+".png",xy,100);
//      }
//    }
//   if (cards[x].equals("yellow12"))
//    {
//      if (y.equals("black"))
//      {
//       cardName=(String)(y+blackRandom);
//        cards[x]=cardName;
//        cardPrinter (cardName+".png",xy,100);
//      }
//      else
//      {
//      cardName=(String)(y+random);
//        cards[x]=cardName;
//      cardPrinter (cardName+".png",xy,100);
//      }
//    }
//   if (cards[x].equals("red12"))
//    {
//      if (y.equals("black"))
//      {
//       cardName=(String)(y+blackRandom);
//        cards[x]=cardName;
//        cardPrinter (cardName+".png",xy,100);
//      }
//      else
//      {
//      cardName=(String)(y+random);
//        cards[x]=cardName;
//      cardPrinter (cardName+".png",xy,100);
//      }
//      }
//    else 
//    {
//      c.println("hello");
//    }
////*******************************************************
//   
//  }
//}
}