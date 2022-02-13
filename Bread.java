package testclass;

public class Bread extends Item{

private String type ; 

public Bread(  String t , double p )
{
super(p);
type = t;
}

public Bread( Bread b) {
super(b);
type = b.type;
}

public  boolean isRotten()
{
if(type.equalsIgnoreCase("Arabic" )&& displayedDays > 3)
return true; 
else
if(type.equalsIgnoreCase("Toast" )&& displayedDays > 5)
return true; 
else    
if( displayedDays > 4)
return true; 
else

return false ; 
}

public String toString() {
return super.toString() + " , type=" + type ;
}

public String getType()
{
return type; 
}

}
