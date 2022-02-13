package testclass;

import java.util.* ;
import javax.swing.JOptionPane;

public class TestClass {

public static void main(String[] args) {
Scanner input = new Scanner(System.in ); 
Bakery Bak = new Bakery("Diplomat" , "King Abdullah road" , 200.0 , 100 ) ;
Bak.addItem(new Sweet("cookies" , 4 )) ;    // AddItem in UML start with capital A 
Bak.addItem(new Bread("Arabic" , 2 )) ;
Bak.addItem(new Bread("Toast" , 4 )) ; 

String nameSweet = "eclair" ; 
while( true ){
    try{
     Bak.addItem(new Sweet(nameSweet , 8)) ; 
   break; 
    }
    catch(IllegalArgumentException e )
    {
        System.out.println("Error name of sweet Enter new name of sweet ");
        System.out.println("Enter only on of this : ");
        System.out.println("doughnut, English cake, or cookies");
        nameSweet = input.nextLine(); 
        
    }
}

// Perform a daily check on all bakery items. 
Bak.DailyCheck();

// Store all sweets information in “sweets.txt” text file and display this
//information in a friendly GUI using a text Area. 
String  SweetInfo = Bak.storeAllSweet() ; 
SweetFram obj = new SweetFram() ; 
obj.str = SweetInfo; 
obj.view();

obj.setVisible(true);


//Remove the item at index 1 in items.
if(  Bak.removeItem(1))
        System.out.println("remove item at index 1 is done");
else
        System.out.println("Cant add Item at index 1 in bakery");

}

}
