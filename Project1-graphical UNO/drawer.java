import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image
import java.lang.Math;
public class drawer
{
  
  static Console c;
  static Console d;
  
  public static void main (String[] args)
  {
//***********Constants********************************
    String drawCard="";
    String drawColours="";
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
    String randomColour="";
    String  computerColour="";
    String cardColour="";
    Player player1= new Player ();
    Player player2 = new Player();
    String wildCard="";
    int drawNum=0;
    int numbers=0;
    c.println("Welcome to Uno! The rules are the following:");
    c.println("\nThe game starts off with a selection of 7 cards from the card deck.");
    c.println("The cards left over will be used as the rescue deck"); 
    c.println("After the cards have been distributed the first card on the deck is flipped and the first player takes their turn.");
    c.println("If a player doesn’t have a card that they can put down they take one card from the deck"); 
    c.println("Each player plays on until one player runs out of cards. That person wins the game.");
    
    c.println("\nPress enter to continue ");
    enter = c.readChar();
    c.clear();
    d= new Console(75,100);
    c.println("7 cards have been distrubuted, hit enter to turn them over");
    d.println("7 cards have been distrubuted, hit enter to turn them over");
    
    for (int x=0; x<=6; x++)
    { 
      
      for (double xs=0; xs<100000; xs++)
      {
      } 
      cardPrinter1("unocard.png",xy,100);
      cardPrinter2("unocard.png",xy,100); 
      
      xy+=100;
      
    }    
    
    
    
    enter=c.readChar();
    enter=d.readChar();
    
    
    c.println("\nThese are your cards:");
    d.println("\nThese are your cards:");
    
    
    numbers=(int)(Math.random()*9+1);
    String colours="";
    computerColour=player1.randomColour(colours);
    colours=computerColour;
    String cardz=(String)(randomColour+numbers+".png");
    latest = (String)(randomColour+numbers);
    cardPrinter1(cardz,350,600);
    cardPrinter2(cardz,350,600);
    
    
    for (int x=0; x<=6; x++)
    { 
      cardName1=player1.showCards()[x];
      cardName2=player2.showCards()[x];
//      for (double xs=0; xs<100000; xs++)
//      {
//      } 
      cardPrinter1(cardName1 + ".png",xy,100);
      cardPrinter2(cardName2 + ".png",xy,100); 
      
      xy+=100;
    }// end of loop
    
    while (!player1.showCards()[0].equals("") && !player2.showCards()[0].equals(""))
    {
      refresh(player1.showCards(), player2.showCards(), latest);
      
      
      if (block2==false)
      {
        c.println("press 1 to play a card  or 2 tp pick up a card: the colour is "+colours);
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
                for(int i = 1; i < 2; i++)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player2.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player2.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
              }
              else if (cardColour=="black" && cardNumber==1)
              {
                for(int i = 0; i < 4; i++)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player2.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player2.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
                refresh(player1.showCards(), player2.showCards(), latest);
                c.println("please enter in the colour name:");
                wildCard=c.readString();
                colours=wildCard;
                d.println("the colour is now "+colours);
                cardColour=colours;  
              }
              else if (cardColour=="black" && cardNumber==2)
              {
                refresh(player1.showCards(), player2.showCards(), latest);
                c.println("please enter in the colour name:");
                wildCard=c.readString();
                colours=wildCard;
                d.println("the colour is now "+colours);
                cardColour=colours;  
              }
              runLoop=true;
             
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
                
                
                
                latestPlayer1=player1.showCards()[cardNum-1];
                player1.removeCard(cardNum-1);
                
                refresh(player1.showCards(),player2.showCards(), latestPlayer1);
                runLoop=true;
                colours = cardColour;
                numbers = cardNumber;
                
                
              }
             
              else if (cardColour!=colours)
              {
                refresh(player1.showCards(),player2.showCards(),latest);
               
                c.println("invalid colour please try again! press 110 for extra card");
                d.println("the colour is "+colours);
                
                cardNum=c.readInt();
                if (cardNum==110)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player1.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                  refresh(player1.showCards(), player2.showCards(), latest);
                  runLoop=true;
                }  
                
              }
               else if (player1.cards[2]=="")
              {
                 double is=0;
                c.println("Quickly type in uno!! hurry");
                String uno=c.readString();
                for ( double i=0.0; i<10000000.0; i+=0.5)
                       {
                  is+=0.5;
                }
               if (uno=="uno" && is!=10000000.0)
               {
                 d.println("its player1s last card");
                 c.println("its your last card");
               }
               else 
               {
                   for(int i = 1; i < 2; i++)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player1.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
               }
                 
               if(!colours.equals(cardColour) || cardColour.equals("black"))
              {
                runLoop=false;
                c.clear();
                refresh(player1.showCards(),player2.showCards(), latest);
                cardPrinter1(cardz,350,400);
                cardPrinter2(cardz,350,400);
                c.println ("invalid card,please try again HEY! if you want u can press 110 for extra card");
                c.println("the colour is "+colours);
                if (cardNum==110)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player1.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                  refresh(player1.showCards(), player2.showCards(), latest);
                  runLoop=true;
                }  
                
                
              }
             
              
            }

          }
        }
        }
        else{
          drawNum =(int)(Math.random()*9+1);
          drawColours=player1.randomColour(colours);
          drawCard=(String)(drawColours+drawNum);
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
        
        d.println("press 1 to play a card  or 2 tp pick up a card: the colour is "+colours);
        int choice=d.readInt();
        if (choice == 1)
        {
          
          
          d.println("choose which card to put Ex(1 for first card) ");
          cardNum=d.readInt();
          runLoop=false;
          while (runLoop==false) 
          {
            String x=player2.showCards()[cardNum-1];
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
            String pickedCard=player2.showCards()[cardNum-1];
            int index1=cardColour.length();
            int index2=pickedCard.length();
            String numbers1=pickedCard.substring(index1,index2);
            
            
            int cardNumber=Integer.parseInt(numbers1);
            if (colours.equals(cardColour) || cardColour.equals("black"))
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
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player1.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
              }
              
              else if (cardColour=="black" && cardNumber==1)
              {
                for(int i = 0; i < 4; i++)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player2.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
                refresh(player1.showCards(), player2.showCards(), latest);
                d.println("please enter in the colour name:");
                wildCard=d.readString();
                colours=wildCard;
                d.println("the colour is now "+colours);
                cardColour=colours;  
              }
              else if (cardColour=="black" && cardNumber==2)
              {
                refresh(player1.showCards(), player2.showCards(), latest);
                d.println("please enter in the colour name:");
                wildCard=d.readString();
                colours=wildCard;
                
                cardColour=colours;  
              } 
              runLoop=true;
             
              latest=player2.showCards()[cardNum-1];
              player2.removeCard(cardNum-1);
              colours = cardColour;
              numbers=cardNumber;
              
              refresh(player1.showCards(), player2.showCards(), latest);
              c.println("the colour is now "+colours);  
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
              else if (cardColour!=colours)
              {
                refresh(player1.showCards(),player2.showCards(),latest);
                // c.println("the colour is now "+colours);
                d.println("invalid colour please try again! press 110 for extra card the colour is "+colours);
                
                cardNum=d.readInt();
                if (cardNum==110)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player1.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player2.addCard(drawCard);
                  refresh(player1.showCards(), player2.showCards(), latest);
                  runLoop=true;
                }  
                //runLoop=true;
              }
              
              else 
              {
                runLoop=false;
                d.clear();
                refresh(player1.showCards(),player2.showCards(),latest);
                cardPrinter1(cardz,350,400);
                cardPrinter2(cardz,350,400);
                d.println ("invalid card,please try again HEY! if you want u can press 110 for extra card ");
                d.println("the colour is "+colours);
                cardNum=d.readInt();
                
                if (cardNum==110)
                {
                  drawNum =(int)(Math.random()*9+1);
                  drawColours=player2.randomColour(colours);
                  drawCard=(String)(drawColours+drawNum);
                  player2.addCard(drawCard);
                  refresh(player1.showCards(), player2.showCards(), latest);
                  runLoop=true;
                }
              }
              
            }
          }
        }
        else 
        {
          drawNum =(int)(Math.random()*9+1);
          drawColours=player2.randomColour(colours);
          drawCard=(String)(drawColours+drawNum);
          player2.addCard(drawCard);
          refresh(player1.showCards(), player2.showCards(), latest);
        
        }
      }
     
      block1 = false;
      runLoop=false;
    }
    if (player1.showCards()[0]=="")
    {
      c.clear();
      d.clear();
      cardPrinter1("winner.png",200,300);
      cardPrinter2("loser.png",200,300); 
      
    }
    else
    {
      c.clear();
      d.clear();
//      cardPrinter2("winner.png",425,300);
//      cardPrinter1("loser.png",425,300);
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
    
    cardPrinter1(latest + ".png", 350, 600);
    cardPrinter2(latest + ".png", 350, 600);
    
  }//Method refresh
}
