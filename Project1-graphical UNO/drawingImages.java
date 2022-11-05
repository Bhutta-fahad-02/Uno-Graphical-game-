import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image
import java.lang.Math;
public class drawingImages
{
  
  static Console c;
  static Console d;
  
  public static void main (String[] args)
  {
//***********Constants********************************
    boolean runLoop=false; //determiens if the user had  played a valid card or not 
    String latest="";      //  is the last card played
    String latestPlayer1="";
    String latestPlayer2="";
    String cardName1="";    // saves each card to the array and prints the pciture out 
    String cardName2="";    // does the same as cardName1 but for player 2
    int xy=0;               // is used to dtermine the y cordinate
    c = new Console(75,100); // generates a console 
    char enter=' ';         // allows the user to hit enter and continue to play teh game 
    boolean block1=false;   // deterines if player 1 gets blocked
    boolean block2= false;  // deterines if player 2 gets blocked
    int cardNum=0;          // the card the user played 
    String randomCard="";   // is used to save 
    String lastCard="";       // is used to save the last card 
    String cardColour="";   // the colour of teh card played 
    Player player1= new Player (); // creates a new object called player1
    Player player2 = new Player();  // creates a new object called player2
    int numbers=0;           // generataes a random card to start off the game
    String randomColours=""; // generates \ random colour 
    String colours="";    // stores the colour played and the random generaated card colour.
    String wildColour="";
    int cardNumber=0;
//*******************************************************************************************************************
    
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
    c.println("\nThese are your cards:");
    d.println("\nThese are your cards:");
    
   
    numbers=(int)(Math.random()*9+1); 
    colours=player1.colourMaker(randomColours);
    lastCard=(String)(colours+numbers+".png");
    latest = (String)(colours+numbers);
    cardPrinter1(lastCard,350,400);
    cardPrinter2(lastCard,350,400);
    
    
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
        c.println("press 1to play a card  or 2 to pick up a card ");
        int choice=c.readInt();
        if (choice == 1)
        {
          c.println("choose which card to put Ex(1 for first card) ");
          cardNum=c.readInt();
          runLoop=false;
          
          while (runLoop==false) 
          {
            String x=player1.showCards()[cardNum-1];
           
            
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
            
            cardNumber=Integer.parseInt(numbers1);
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
              else if (cardColour=="black" && cardNumber==1)
              {
                block1=true;
                for(int i = 0; i < 4; i++)
                {
                  int drawNum =(int)(Math.random()*9+1);
                  String drawColours=player2.colourMaker(colours);
                  String drawCard=(String)(drawColours+drawNum);
                  player2.addCard(drawCard);
                }
//                
//               c.println("what colour do you want it to be: ");
//               cardColour=c.readString();
//              d.println("The colour is now " + cardColour);
//              colours = cardColour;
//              latestP1 = player1.playerHand()[cardPosition-1];
            }
            else if(cardNumber == 2)
            {
              
//              cardColour = plusFour1(cardNumber, colour);
//              d.println("The colour is now " + cardColour);
//              colour = cardColour;
//              latestP1 = player1.playerHand()[cardPosition-1];
            }
           
                refresh(player1.showCards(), player2.showCards(), latest);
            }
              
              runLoop=true;
              putCards(cardNum);
              latest=player1.showCards()[cardNum-1];
              player1.removeCard(cardNum-1);
              colours = cardColour;
              numbers=cardNumber;
              
              refresh(player1.showCards(), player2.showCards(), latest);
            }
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
              
              
              else 
              {
                runLoop=false;
                c.clear();
                refresh(player1.showCards(),player2.showCards(), latest);;
                cardPrinter1(lastCard,350,400);
                cardPrinter2(lastCard,350,400);
                c.println ("invalid card,please try again");
                cardNum=c.readInt();          
              }
          
              
            }
          }
        
        else{
          int drawNum =(int)(Math.random()*9+1);
          String drawColours=player1.colourMaker(colours);
          String drawCard=(String)(drawColours+drawNum);
          player1.addCard(drawCard);
          refresh(player1.showCards(), player2.showCards(), latest);
        }
      }
      block2 = false;
      
      
      if (block1==false)
      {
        d.println("1 or 2");
        int choice=d.readInt();
        if (choice == 1)
        {
          
        
          d.println("choose which card to put Ex(1 for first card) ");
          cardNum=d.readInt();
          runLoop=false;
          while (runLoop==false) 
          {
            String x=player2.showCards()[cardNum-1];
           
            
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
            
            cardNumber=Integer.parseInt(numbers1);
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
                  int drawNum =(int)(Math.random()*9+1);
                  String drawColours=player1.colourMaker(colours);
                  String drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
              }
              else if (cardColour=="black" && cardNumber==1)
              {
                c.println("what colour do you wan tot set it to ?");
               wildColour=c.readString();
                wildColour=colours;
                d.print(wildColour +" is the colour");
                block2=true;
                for(int i = 0; i < 4; i++)
                {
                  int drawNum =(int)(Math.random()*9+1);
                  String drawColours=player1.colourMaker(colours);
                  String drawCard=(String)(drawColours+drawNum);
                  player1.addCard(drawCard);
                }
                refresh(player1.showCards(), player2.showCards(), latest);
              }
              else if (cardColour=="black" && cardNumber==2)
              {
                c.println("what colour do you wan tot set it to ?");
               wildColour=c.readString();
                wildColour=colours;
                refresh(player1.showCards(), player2.showCards(), latest);
                
              } 
              else 
              {
              runLoop=true;
              putCards(cardNum);
              latest=player2.showCards()[cardNum-1];
              player2.removeCard(cardNum-1);
              colours = cardColour;
              numbers=cardNumber;
              
              refresh(player1.showCards(), player2.showCards(), latest);
            }
            }
            
            else {
              if ((int)(cardNumber)==numbers)
              {
                
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
                cardPrinter1(lastCard,350,400);
                cardPrinter2(lastCard,350,400);
                d.println ("invalid card,please try again");
                cardNum=d.readInt();
              }
              
              
            }
          }
        }
        
        else{
          int drawNum =(int)(Math.random()*9+1);
          String drawColours=player2.colourMaker(colours);
          String drawCard=(String)(drawColours+drawNum);
          player2.addCard(drawCard);
          refresh(player1.showCards(), player2.showCards(), latest);
        }
      }
      block1 = false;
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