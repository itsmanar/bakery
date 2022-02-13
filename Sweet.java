package testclass;


public class Sweet extends Item{
private String name ; 

public Sweet(  String n,double p )
{
super( p);

if( n.equalsIgnoreCase("doughnut") || n.equalsIgnoreCase("English cake") ||n.equalsIgnoreCase("cookies")  )
name = n ; 
else
throw new IllegalArgumentException(); 
}

public Sweet( Sweet s) {
this( s.name , s.getPrice() ) ;
 }

public  boolean isRotten()
{
if(name.equalsIgnoreCase("doughnut" )&& displayedDays > 2)
return true; 
else
if(name.equalsIgnoreCase("English cake" )&& displayedDays > 4)
return true; 
else
if(name.equalsIgnoreCase("cookies") &&  displayedDays > 3)
return true; 
else
return false ; 
}

public String toString() {
return super.toString() + " , naem =" + name ;
}


}
