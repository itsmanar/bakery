package testclass;

import java.io.*;
public class Bakery implements Serializable 
{
private String Name ;
private String Location ; 
private double Area ;     
private int numItems ;
private int numSweets ; 
private Item items[] ; 

public Bakery(String name, String loc, double area , int size) {
Name = name;
Location = loc;
Area = area;
items = new Item[size] ; 
numItems =  0 ; 
numSweets = 0 ; 
}

public boolean addItem(Item item )   // in uml Add with capital A 
{
if( numItems  < items.length )
{
if(item instanceof Bread)
items[numItems++] = new Bread ((Bread) item ); 
else
if(item instanceof Sweet)
{
numSweets++ ;    
items[numItems++] = new Sweet ((Sweet) item );   
}

return true; 
}

return false ; 
}

public boolean removeItem(int loc)
{
try{
if( items[loc] instanceof Sweet )  numSweets-- ;

for(int j = loc ; j < numItems -1 ; j++)   
items[j] = items[j+1];

items[--numItems] = null ; 
return true; 
}catch(ArrayIndexOutOfBoundsException ex )
{
System.out.println("Error location in items list "); 
return false; 
}

}


public void DailyCheck()
{
for(int i = 0 ; i < numItems ; i++)
{
items[i].setDisplayedDays( items[i].getDisplayedDays() + 1  );

if(items[i].isRotten() == true)
removeItem(i); 
}

// sava to file “bakery.dat”
try{
File f = new File("Patients.dat");
FileOutputStream fos = new FileOutputStream (f);
ObjectOutputStream oos = new ObjectOutputStream (fos);

oos.writeBytes(Name);
oos.writeBytes(Location);
oos.writeDouble(Area);
oos.writeInt(numItems);
oos.writeInt(numSweets);

for(int i = 0 ; i < numItems ; i++)
oos.writeObject(items[i]);

oos.close();

}
catch( IOException e )
{
System.out.println(e.toString());
}


}

public String storeAllSweet()
{

double TotalPrice  = 0 ; 
String str = "Name=" + Name + ", numSweets=" + numSweets + "\n" ;

for(int i = 0 ; i < numItems ; i++)
if(items[i] instanceof Sweet )
TotalPrice +=  items[i].getPrice() ;

str = str + " Total price : " + TotalPrice + "\n"; 
try{
File f = new File("sweets.txt") ; 
FileOutputStream sf = new FileOutputStream(f) ; 
PrintWriter file = new PrintWriter(sf) ; 

file.println( str );
file.close(); 
}
catch(IOException e )
{
System.out.println(e);
}
return str ; 
}

public String toString() {
String s =  "Name=" + Name + ", locateion=" + Location +  ", Area=" + Area + "\n numItems=" + numItems + 
", numSweets=" + numSweets + "\n" ;

for(int i = 0 ; i < numItems ; i++ )
s = s + items[i].toString() + "\n"; 

return s ; 
}

public int getNumItems() {
return numItems;
}

public int getNumSweets() {
return numSweets;
}



public Item[] getItems() {
return items;
}



}
