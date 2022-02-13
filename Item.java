package testclass;

import java.io.Serializable;
import java.util.*;  
public abstract class Item implements Serializable{

protected int displayedDays ; 
private double price ; 
static Scanner input = new Scanner(System.in) ; 

public Item( double p) {
displayedDays = 1 ;

while(true)
{
try{
    if( p <= 0 )
       throw new IllegalArgumentException(); 
    else
        price = p;
    break; 

}catch(IllegalArgumentException ex )
{
    System.out.println("invalid price Enter new price : ");
    p = input.nextDouble(); 
}
}
}

public Item(Item item) {
this( item.price ); 
displayedDays = item.displayedDays;
} 

public String toString() {
return "displayedDays=" + displayedDays + ", price=" + price ;
}

public abstract boolean isRotten(); 


public int getDisplayedDays() {
return displayedDays;
}

public void setDisplayedDays(int d) {
displayedDays = d;
}

public double getPrice() {
return price;
}

public void setPrice(double p) {
price = p;
}


}

