import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image
import java.lang.Math;
public class drawingImages21
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
    boolean block1=false;
    boolean block2= false;
    int cardNum=0;
    String wildCard="";
    String wildCount="";
    String cardColour="";
    Player player1= new Player ();
    Player player2 = new Player();
    String cardColour2="";
    String wildCard2="";
    String wildCount2="";
    String computerColour="";
    c.println("Welcome to Uno! The rules are the following:");
    c.println("\nThe game starts off with a selection of 7 cards from the card deck.");
    c.println("The cards left over will be used as the rescue deck"); 
    c.println("After the cards have been distributed the first card on the deck is flipped and the first player takes their turn.");
    c.println("If a player doesn?t have a card that they can put down they take one card from the deck"); 
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
    String colours="";
    computerColour=player1.colourMaker(colours);
    colours=computerColour;
    String cardz=(String)(colours+numbers+".png");
    latest = (String)(colours+numbers);
    cardPrinter1(cardz,350,400);
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
            if  (cardNumber==1)
            {
            block1=true;
            for(int i = 0; i < 4; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player2.colourMaker(colours);
              String drawCard=(String)(drawColours+drawNum);
              player2.addCard(drawCard);
            }
            
          }
            else
            {
              refresh(player1.showCards(), player2.showCards(), latest);
              c.println("please enter in the colour name:");
              wildCard=c.readString();
             // colours=wildCard;
              wildCount="black";
              cardColour=wildCard;
              
            }
          }
               else if (wildCount2.equals("black"))
          {
            refresh(player1.showCards(), player2.showCards(), pickedCard);
          c.println(" the car dcolour now i s "+wildCard2);
          //latest=wildCard;
          colours=wildCard2;
          runLoop=true;
          //putCards(cardNum);
          latest=player1.showCards()[cardNum-1];
          player1.removeCard(cardNum-1);
          colours = cardColour;
          numbers=cardNumber;
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
        }
             // refresh(player1.showCards(), player2.showCards(), latest);
          
          runLoop=true;
          //putCards(cardNum);
          latest=player1.showCards()[cardNum-1];
          player1.removeCard(cardNum-1);
          colours = cardColour;
          numbers=cardNumber;
          refresh(player1.showCards(), player2.showCards(), latest);
          }
          
        }
      
        
      
      } else if(choice == 2) {
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
          int index1=cardColour.length();
          int index2=pickedCard.length();
          String numbers1=pickedCard.substring(index1,index2);
             
          int cardNumber=Integer.parseInt(numbers1);
        if (colours.equals(cardColour) || cardColour.equals("black") || cardColour==colours)
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
              String drawColours=player1.colourMaker(colours);
              String drawCard=(String)(drawColours+drawNum);
              player1.addCard(drawCard);
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else if (cardColour=="black")
          {
            if ( cardNumber==1)
          {
            block2=true;
            for(int i = 0; i < 4; i++)
            {
              int drawNum =(int)(Math.random()*9+1);
              String drawColours=player1.colourMaker(colours);
              String drawCard=(String)(drawColours+drawNum);
              player1.addCard(drawCard);
            }
            }
             else if (cardNumber==2)
            {
              refresh(player1.showCards(), player2.showCards(), latest);
              d.println("please enter in the colour name:");
              wildCard2=c.readString();
             // colours=wildCard;
              wildCount2="black";
              cardColour=wildCard;
              
            }
            refresh(player1.showCards(), player2.showCards(), latest);
          }
          else if (wildCount=="black")
          {
            refresh(player1.showCards(), player2.showCards(), pickedCard);
          d.println(" the car dcolour now i s "+wildCard);
          //latest=wildCard;
          colours=wildCard;
          runLoop=true;
          //putCards(cardNum);
          latest=player2.showCards()[cardNum-1];
          player2.removeCard(cardNum-1);
          colours = cardColour;
          numbers=cardNumber;
          
        }
          runLoop=true;
          //putCards(cardNum);
          latest=player2.showCards()[cardNum-1];
          player2.removeCard(cardNum-1);
          colours = cardColour;
          numbers=cardNumber;
              
          refresh(player1.showCards(), player2.showCards(), latest);
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
              colours = cardColour;
              numbers = cardNumber;
              
              
            }
            else 
            {
              runLoop=false;
              d.clear();
              refresh(player1.showCards(),player2.showCards(), latest);;
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
      
//      else
//      {
//      }      
      block1 = false;
      wildCount=null;
      wildCount2=null;
      }
    if (player1.showCards()[0].equals(""))
    {
      c.clear();
      d.clear();
      d.println("maybe next time you would win ");
      c.println("YOW WON YOURE A WINNER !");
    }  
     else if (  player2.showCards()[0].equals(""))
     {
        c.clear();
      d.clear();
      c.println("maybe next time you would win ");
      d.println("YOW WON YOURE A WINNER !");
    
  
    
  }
  
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
 
}