import java.lang.Math;
public class Player
{
  
  String cards[] = new String[30]; 
  public Player()
  {
    String card="";
     int number1 = 0;
    int colourRandomizer;
    int blackRandomizer;
    int randomizerRed;
    int number2 = 0;
     String colour1="";
    String colour2 = "";
    for (int x=1; x<=7; x++)
    { 
      
      
      number1 =(int)(Math.random()*12+1);
      colour1 = colourMaker(colour1); 
      number2 =(int)(Math.random()*10+1);
      int blackRandom;
      blackRandom=(int)(Math.random()*2+1);
      //  colour2 = colourMaker(colour2); 
      if (colour1.equals("black"))
      {
        
        card=(String)(colour1+blackRandom);
        
      }
      else 
      { 
        card=(String)(colour1+number1);
        
      }

      cards[x-1] =card ;
    }// end of loop
    for(int x = 7; x<=29; x++)
    {
       cards[x] = "";
    }
  }
  
  public String[] showCards()
  {
    return cards;
  }
  public String colourMaker(String y)
  {
    int colourRandomizer; 
    colourRandomizer=(int)(Math.random()*43+1);
    
    if (colourRandomizer >=1 && colourRandomizer<=10)
      y = "red"; 
    else if (10<colourRandomizer /*>10*/ && colourRandomizer<=20)
      y = "yellow";
    else if (20<colourRandomizer/* >20*/ && colourRandomizer<=30)
      y="blue";
    else if (30<colourRandomizer/* > 30*/ && colourRandomizer<=40)
      y = "green";
    else if (40 < colourRandomizer)
      y = "black";
    return y;
  }
  public String randomColour(String y1)
  {
    int colourRandomizer; 
    colourRandomizer=(int)(Math.random()*100+1);
    
    if (colourRandomizer >=1 && colourRandomizer<=10)
      y1 = "red"; 
    else if (10<colourRandomizer /*>10*/ && colourRandomizer<=20)
      y1 = "yellow";
    else if (20<colourRandomizer/* >20*/ && colourRandomizer<=30)
      y1="blue";
    else if (30<colourRandomizer/* > 30*/ && colourRandomizer<=40)
     y1 = "green";   
    return y1;
  }

  public void removeCard(int index)
  {
    for (int x=index; x<29; x++)
    {
      cards[x]=cards[x+1];
    }
    cards[29]="";
  }
  
  public void addCard(String card)
  {
    boolean empty = false;
    for(int x = 0; x<=29; x++)
    {
      if(empty == false && cards[x] == "")
      {
        cards[x] = card;
        empty = true;
      }
    }
  }
}