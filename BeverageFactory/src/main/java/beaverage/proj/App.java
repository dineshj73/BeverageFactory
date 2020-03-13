package beaverage.proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan=new Scanner(System.in);   
//        Main menu list
        List<String> menuItemList=new ArrayList();
        menuItemList.add( " 1 Coffee");
        menuItemList.add(" 2 Chai");
        menuItemList.add(" 3 Banana Smoothie");
        menuItemList.add(" 4 Strawberry Shake");
        menuItemList.add(" 5 Mojito");
        menuItemList.add(" 6 Exit");
        
        //ingredientsPrice list 
        Map<Integer,Double> ingredientsPriceList=new HashMap();
        ingredientsPriceList.put(1,1.0); // MIlk
        ingredientsPriceList.put(2,0.5); //Sugar
        ingredientsPriceList.put(3,0.5); // Soda
        ingredientsPriceList.put(4,0.5); // mint
        ingredientsPriceList.put(5,0.5); //water
        
//        main menu price list 
        Map<Integer,Double> menuPriceList=new HashMap();
        menuPriceList.put(1,5.0); // Coffee
        menuPriceList.put(2,4.0); //Chai
        menuPriceList.put(3,6.0); // Banana Smoothie
        menuPriceList.put(4,7.0); // Strawberry Shake
        menuPriceList.put(5,7.5); //Mojito
        
       // coffee ingredients list
        Map<Integer,String> coffee_Chai_banana_IngredientList=new HashMap();		 
		 coffee_Chai_banana_IngredientList.put(1," 1 Milk");
		 coffee_Chai_banana_IngredientList.put(2," 2 Sugar");
		 coffee_Chai_banana_IngredientList.put(5," 5 Water");
		 
		   Map<Integer,String> mojitoIngredientList=new HashMap();
		   
		   mojitoIngredientList.put(2," 2 Sugar");
		   mojitoIngredientList.put(3," 3 Mint");
		   mojitoIngredientList.put(4," 4 Soda");
		   mojitoIngredientList.put(5," 5 Water");
	
		 
		  List<String> traversalList=new ArrayList();			 
		  traversalList.add(" 1 Back");
		  traversalList.add(" 2 Main Menu");
        
		 Integer exitOrNot=0;
        
        int menuItem=0;
        outer:
         do {
        	
            Iterator itr=menuItemList.iterator();  
            System.out.println("==============WELCOME================");
            while(itr.hasNext()){  
            	  
                System.out.println( itr.next());  
            } 
            System.out.println("=====================================");
            System.out.println("Please select menu item");
        	 menuItem=scan.nextInt();
        	 int menuType=0;
       	  	switch(menuItem) {
            	case 1:
            		
            		
            		System.out.println("=====You have selected coffee=====");
            		
            		coffeeJump: do {
            			
            			    System.out.println("Please select coffee type");
            			    System.out.println("=====================================");
            	        	System.out.println(" 1  Coffee");
            	        	System.out.println(" 2  custumize coffee");
            	        	System.out.println(" 3  Main Menu");
            	        	System.out.println("=====================================");
            	        	menuType=scan.nextInt();
            	        	if(menuType==3)
            	        		break;
            	        	
            	        	 switch(menuType) {
            	        	 case 1 : {
            	        		
            	        		 System.out.println("Your order has without exclusion");
            	        		 Double coffeePrice=menuPriceList.get(1);
            	        		 System.out.println("Coffee price is="+coffeePrice);
            	        		 System.out.println("=====================================");
            	        	 }
            	        	 break;
            	        	 
            	        	 case 2 : {
            	        		 
            	        		 Double coffeePrice=menuPriceList.get(1);
            	        		 Double finalPrice=coffeePrice;
            	        		 int ingredient=0;
            	        		 List<Integer> selectedIngredients=new ArrayList<Integer>();
            	        		 do {           	        			 
            	        			
            	        			 System.out.println("=====================================");
            	        			 
            	        			 Iterator<Integer> coffeeItr=coffee_Chai_banana_IngredientList.keySet().iterator();
            	        			 while(coffeeItr.hasNext()) {
            	        				 int key=(int)coffeeItr.next();  
            	        				 System.out.println( coffee_Chai_banana_IngredientList.get(key));  
            	        			 }
            	        	         System.out.println("=====================================");
            	        	         
	            	        		 System.out.println(" Please select the ingredients");
	            	        		 ingredient=scan.nextInt();
	            	        		 selectedIngredients.add(ingredient);
	            	        		 
	            	        		 System.out.println(" do u want to continue then enter 0  ");
	            	        		 exitOrNot=scan.nextInt();	 

	            	        
            	        		 }
            	        		 while(exitOrNot==0);            	        		 
            	        		 Set<Integer> hSet = new HashSet<Integer>(selectedIngredients); 
            	        	        hSet.addAll(selectedIngredients); 
            	        		 if((coffee_Chai_banana_IngredientList.size()) <= selectedIngredients.size()) {
            	        			  System.out.println("============================================");
            	        			  Iterator selectedIngredientsTemp=hSet.iterator();
            	        			  System.out.println("Selected exclusion Ingredients are ");
            	        	            while(selectedIngredientsTemp.hasNext()){ 
            	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
            	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
            	        	            }
            	        			  System.out.println("An order cannot have all the ingredients in exclusion for a menu item.");
            	        			 menuItem=4;
                        			 continue outer;
            	        		 }else {
            	        			 int traveserInput=0;
            	        			Iterator selectedIngredientsTemp=hSet.iterator();  
            	        			System.out.println("=================================================");
            	        			System.out.println("Selected exclusion Ingredients are ");
          	        	            while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            	finalPrice-=(ingredientsPriceList.get(index));
          	        	            }
                 	        		 
          	        	           System.out.println("Coffee price is="+finalPrice);
          	        	           System.out.println("============================================");
	          	        	       Iterator traverserItr=traversalList.iterator();  
	     	        	           innerCoffee: while(traverserItr.hasNext()){  
	     	        	            	  
	     	        	                System.out.println( traverserItr.next());  
	     	        	            } 
	     	        	           traveserInput=scan.nextInt();
	     	        	           if(traveserInput==1) {
	     	        	        	    menuType=1;
		                    			 continue coffeeJump;
	     	        	           }else if(traveserInput==2) {
	     	        	        	  menuItem=4;
	     	        	        	    continue outer;
	     	        	           }else {
	     	        	        	  System.out.println("Please enter valid input."); 
	     	        	           }
	          	        	         
            	        		 }            	        		
            	        		 
            	        	 }break;         	        	
            	        	 
            	        	 }
            	        	
            		  }while(menuType>0 && menuType<2);
            		  
            		 if(menuType>2) {
            			 menuItem=4;
            			 continue outer;
            		 }
            		 break;
            		 
            		 //===========================for CHAI=============================
            	case 2 : {
            		System.out.println("=====You have selected Chai=====");
            		coffeeJump: do {
            			
            			    System.out.println("Please select Chai type");
            			    System.out.println("=====================================");
            	        	System.out.println(" 1  Chai");
            	        	System.out.println(" 2  custumize Chai");
            	        	System.out.println(" 3  Main Menu");
            	        	System.out.println("=====================================");
            	        	menuType=scan.nextInt();
            	        	if(menuType==3)
            	        		break;
            	        	
            	        	 switch(menuType) {
            	        	 case 1 : {
            	        		
            	        		 System.out.println("Your order has without exclusion");
            	        		 Double chaiPrice=menuPriceList.get(2);
            	        		 System.out.println("Chai price is="+chaiPrice);
            	        		 System.out.println("=====================================");
            	        	 }
            	        	 break;
            	        	 
            	        	 case 2 : {
            	        		 
            	        		 Double chaiPrice=menuPriceList.get(2);
            	        		 Double finalPrice=chaiPrice;
            	        		 int ingredient=0;
            	        		 List<Integer> selectedIngredients=new ArrayList<Integer>();
            	        		 do {           	        			 
            	        			
            	        			 System.out.println("=====================================");
            	        			
            	        			 Iterator<Integer> coffeeItr=coffee_Chai_banana_IngredientList.keySet().iterator();
            	        			 while(coffeeItr.hasNext()) {
            	        				 int key=(int)coffeeItr.next();  
            	        				 System.out.println( coffee_Chai_banana_IngredientList.get(key));  
            	        			 }
            	        	         System.out.println("=====================================");
            	        	         
	            	        		 System.out.println(" Please select the ingredients");
	            	        		 ingredient=scan.nextInt();
	            	        		 selectedIngredients.add(ingredient);
	            	        		 
	            	        		 System.out.println(" do u want to continue then enter 0  ");
	            	        		 exitOrNot=scan.nextInt();	 

	            	        
            	        		 }
            	        		 while(exitOrNot==0);            	        		 
            	        		 Set<Integer> hSet = new HashSet<Integer>(selectedIngredients); 
            	        	        hSet.addAll(selectedIngredients); 
            	        		 if((coffee_Chai_banana_IngredientList.size()) <= selectedIngredients.size()) {
            	        			  System.out.println("============================================");
            	        			  System.out.println("Selected exclusion Ingredients are ");
            	        			  Iterator selectedIngredientsTemp=hSet.iterator();
          	        	             while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            }
            	        			  System.out.println("An order cannot have all the ingredients in exclusion for a menu item.");
            	        			 menuItem=4;
                        			 continue outer;
            	        		 }else {
            	        			 int traveserInput=0;
            	        			Iterator selectedIngredientsTemp=hSet.iterator();  
            	        			System.out.println("=================================================");
            	        			System.out.println("Selected exclusion Ingredients are ");
          	        	            while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            	finalPrice-=(ingredientsPriceList.get(index));
          	        	            }
                 	        		 
          	        	           System.out.println("Chai price is="+finalPrice);
          	        	           System.out.println("============================================");
	          	        	       Iterator traverserItr=traversalList.iterator();  
	     	        	           innerCoffee: while(traverserItr.hasNext()){  
	     	        	            	  
	     	        	                System.out.println( traverserItr.next());  
	     	        	            } 
	     	        	           traveserInput=scan.nextInt();
	     	        	           if(traveserInput==1) {
	     	        	        	    menuType=1;
		                    			 continue coffeeJump;
	     	        	           }else if(traveserInput==2) {
	     	        	        	  menuItem=4;
	     	        	        	    continue outer;
	     	        	           }else {
	     	        	        	  System.out.println("Please enter valid input."); 
	     	        	           }
	          	        	         
            	        		 }            	        		
            	        		 
            	        	 }break;         	        	
            	        	 
            	        	 }
            	        	
            		  }while(menuType>0 && menuType<2);
            		  
            		 if(menuType>2) {
            			 menuItem=4;
            			 continue outer;
            		 }
            		break;
            	}
            	// for banana smoothie
            	case 3 : {
            		System.out.println("=====You have selected Banana Smoothie=====");
            		coffeeJump: do {
            			
            			    System.out.println("Please select Banana Smoothie type");
            			    System.out.println("=====================================");
            	        	System.out.println(" 1  Banana Smoothie");
            	        	System.out.println(" 2  custumize Banana Smoothie");
            	        	System.out.println(" 3  Main Menu");
            	        	System.out.println("=====================================");
            	        	menuType=scan.nextInt();
            	        	if(menuType==3)
            	        		break;
            	        	
            	        	 switch(menuType) {
            	        	 case 1 : {
            	        		
            	        		 System.out.println("Your order has without exclusion");
            	        		 Double bananaSmoothiePrice=menuPriceList.get(3);
            	        		 System.out.println("Banana Smoothie price is="+bananaSmoothiePrice);
            	        		 System.out.println("=====================================");
            	        	 }
            	        	 break;
            	        	 
            	        	 case 2 : {
            	        		 
            	        		 Double bananaSmoothiePrice=menuPriceList.get(3);
            	        		 Double finalPrice=bananaSmoothiePrice;
            	        		 int ingredient=0;
            	        		 List<Integer> selectedIngredients=new ArrayList<Integer>();
            	        		 do {           	        			 
            	        			
            	        			 System.out.println("=====================================");
            	        			  
            	        			 Iterator<Integer> coffeeItr=coffee_Chai_banana_IngredientList.keySet().iterator();
            	        			 while(coffeeItr.hasNext()) {
            	        				 int key=(int)coffeeItr.next();  
            	        				 System.out.println( coffee_Chai_banana_IngredientList.get(key));  
            	        			 }
            	        	         System.out.println("=====================================");
            	        	         
	            	        		 System.out.println(" Please select the ingredients");
	            	        		 ingredient=scan.nextInt();
	            	        		 selectedIngredients.add(ingredient);
	            	        		 
	            	        		 System.out.println(" do u want to continue then enter 0  ");
	            	        		 exitOrNot=scan.nextInt();	 

	            	        
            	        		 }
            	        		 while(exitOrNot==0);            	        		 
            	        		 Set<Integer> hSet = new HashSet<Integer>(selectedIngredients); 
            	        	        hSet.addAll(selectedIngredients); 
            	        		 if((coffee_Chai_banana_IngredientList.size()) <= selectedIngredients.size()) {
            	        			  System.out.println("============================================");
            	        			  System.out.println("Selected exclusion Ingredients are ");
            	        			  Iterator selectedIngredientsTemp=hSet.iterator();
          	        	             while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            }
            	        			  System.out.println("An order cannot have all the ingredients in exclusion for a menu item.");
            	        			 menuItem=4;
                        			 continue outer;
            	        		 }else {
            	        			 int traveserInput=0;
            	        			Iterator selectedIngredientsTemp=hSet.iterator();  
            	        			System.out.println("=================================================");
            	        			System.out.println("Selected exclusion Ingredients are ");
          	        	            while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            	finalPrice-=(ingredientsPriceList.get(index));
          	        	            }
                 	        		 
          	        	           System.out.println("Banana Smoothie price is="+finalPrice);
          	        	           System.out.println("============================================");
	          	        	       Iterator traverserItr=traversalList.iterator();  
	     	        	           innerCoffee: while(traverserItr.hasNext()){  
	     	        	            	  
	     	        	                System.out.println( traverserItr.next());  
	     	        	            } 
	     	        	           traveserInput=scan.nextInt();
	     	        	           if(traveserInput==1) {
	     	        	        	    menuType=1;
		                    			 continue coffeeJump;
	     	        	           }else if(traveserInput==2) {
	     	        	        	  menuItem=4;
	     	        	        	    continue outer;
	     	        	           }else {
	     	        	        	  System.out.println("Please enter valid input."); 
	     	        	           }
	          	        	         
            	        		 }            	        		
            	        		 
            	        	 }break;         	        	
            	        	 
            	        	 }
            	        	
            		  }while(menuType>0 && menuType<2);
            		  
            		 if(menuType>2) {
            			 menuItem=4;
            			 continue outer;
            		 }
            		break;
            	}
            	// for Strawberry Shake
            	case 4 : {
            		System.out.println("=====You have selected Strawberry Shake=====");
            		coffeeJump: do {
            			
            			    System.out.println("Please select Strawberry Shake type");
            			    System.out.println("=====================================");
            	        	System.out.println(" 1  Strawberry Shake");
            	        	System.out.println(" 2  custumize Strawberry Shake");
            	        	System.out.println(" 3  Main Menu");
            	        	System.out.println("=====================================");
            	        	menuType=scan.nextInt();
            	        	if(menuType==3)
            	        		break;
            	        	
            	        	 switch(menuType) {
            	        	 case 1 : {
            	        		
            	        		 System.out.println("Your order has without exclusion");
            	        		 Double strawberryShakePrice=menuPriceList.get(4);
            	        		 System.out.println("Strawberry Shake price is="+strawberryShakePrice);
            	        		 System.out.println("=====================================");
            	        	 }
            	        	 break;
            	        	 
            	        	 case 2 : {
            	        		 
            	        		 Double strawberryShakePrice=menuPriceList.get(4);
            	        		 Double finalPrice=strawberryShakePrice;
            	        		 int ingredient=0;
            	        		 List<Integer> selectedIngredients=new ArrayList<Integer>();
            	        		 do {           	        			 
            	        			
            	        			 System.out.println("=====================================");
            	        			 
            	        			 Iterator<Integer> coffeeItr=coffee_Chai_banana_IngredientList.keySet().iterator();
            	        			 while(coffeeItr.hasNext()) {
            	        				 int key=(int)coffeeItr.next();  
            	        				 System.out.println( coffee_Chai_banana_IngredientList.get(key));  
            	        			 }
            	        	         System.out.println("=====================================");
            	        	         
	            	        		 System.out.println(" Please select the ingredients");
	            	        		 ingredient=scan.nextInt();
	            	        		 selectedIngredients.add(ingredient);
	            	        		 
	            	        		 System.out.println(" do u want to continue then enter 0  ");
	            	        		 exitOrNot=scan.nextInt();	 

            	        		 }
            	        		 while(exitOrNot==0);            	        		 
            	        		 Set<Integer> hSet = new HashSet<Integer>(selectedIngredients); 
            	        	        hSet.addAll(selectedIngredients); 
            	        		 if((coffee_Chai_banana_IngredientList.size()) <= selectedIngredients.size()) {
            	        			  System.out.println("============================================");
            	        			  System.out.println("Selected exclusion Ingredients are ");
            	        			  Iterator selectedIngredientsTemp=hSet.iterator();
          	        	             while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            }
            	        			  System.out.println("An order cannot have all the ingredients in exclusion for a menu item.");
            	        			 menuItem=4;
                        			 continue outer;
            	        		 }else {
            	        			 int traveserInput=0;
            	        			Iterator selectedIngredientsTemp=hSet.iterator();  
            	        			System.out.println("=================================================");
            	        			System.out.println("Selected exclusion Ingredients are ");
          	        	            while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(coffee_Chai_banana_IngredientList.get(index));
          	        	            	finalPrice-=(ingredientsPriceList.get(index));
          	        	            }
                 	        		 
          	        	           System.out.println("Strawberry Shake price is="+finalPrice);
          	        	           System.out.println("============================================");
	          	        	       Iterator traverserItr=traversalList.iterator();  
	     	        	           innerCoffee: while(traverserItr.hasNext()){  
	     	        	            	  
	     	        	                System.out.println( traverserItr.next());  
	     	        	            } 
	     	        	           traveserInput=scan.nextInt();
	     	        	           if(traveserInput==1) {
	     	        	        	    menuType=1;
		                    			 continue coffeeJump;
	     	        	           }else if(traveserInput==2) {
	     	        	        	  menuItem=4;
	     	        	        	    continue outer;
	     	        	           }else {
	     	        	        	  System.out.println("Please enter valid input."); 
	     	        	           }
	          	        	         
            	        		 }            	        		
            	        		 
            	        	 }break;         	        	
            	        	 
            	        	 }
            	        	
            		  }while(menuType>0 && menuType<2);
            		  
            		 if(menuType>2) {
            			 menuItem=4;
            			 continue outer;
            		 }
            		break;
            	}
            	//for  Mojito 
            	case 5 : {
            		System.out.println("=====You have selected Mojito=====");
            		coffeeJump: do {
            			
            			    System.out.println("Please select Mojito type");
            			    System.out.println("=====================================");
            	        	System.out.println(" 1  Mojito");
            	        	System.out.println(" 2  custumize Mojito");
            	        	System.out.println(" 3  Main Menu");
            	        	System.out.println("=====================================");
            	        	menuType=scan.nextInt();
            	        	if(menuType==3)
            	        		break;
            	        	
            	        	 switch(menuType) {
            	        	 case 1 : {
            	        		
            	        		 System.out.println("Your order has without exclusion");
            	        		 Double mojitoPrice=menuPriceList.get(5);
            	        		 System.out.println("Banana Smoothie price is="+mojitoPrice);
            	        		 System.out.println("=====================================");
            	        	 }
            	        	 break;
            	        	 
            	        	 case 2 : {
            	        		 
            	        		 Double mojitoPrice=menuPriceList.get(5);
            	        		 Double finalPrice=mojitoPrice;
            	        		 int ingredient=0;
            	        		 List<Integer> selectedIngredients=new ArrayList<Integer>();
            	        		 do {           	        			 
            	        			
            	        			 System.out.println("=====================================");
            	        			
            	        			 Iterator <Integer> it = mojitoIngredientList.keySet().iterator();       //keyset is a method  
            	        			 while(it.hasNext())  
            	        			 {  
	            	        			 int key=(int)it.next();  
	            	        			 System.out.println(mojitoIngredientList.get(key));  
            	        			 } 
            	        	         System.out.println("=====================================");
            	        	         
	            	        		 System.out.println(" Please select the ingredients");
	            	        		 ingredient=scan.nextInt();
	            	        		 selectedIngredients.add(ingredient);
	            	        		 
	            	        		 System.out.println(" do u want to continue then enter 0  ");
	            	        		 exitOrNot=scan.nextInt();	 

	            	        
            	        		 }
            	        		 while(exitOrNot==0);            	        		 
            	        		 Set<Integer> hSet = new HashSet<Integer>(selectedIngredients); 
            	        	        hSet.addAll(selectedIngredients); 
            	        		 if((mojitoIngredientList.size()) <= selectedIngredients.size()) {
            	        			 
            	        			  System.out.println("============================================");
            	        			  System.out.println("Selected exclusion Ingredients are ");
            	        			  Iterator selectedIngredientsTemp=hSet.iterator();
          	        	             while(selectedIngredientsTemp.hasNext()){ 
          	        	            	Integer index= (Integer)selectedIngredientsTemp.next();
          	        	            	System.out.println(mojitoIngredientList.get(index));
          	        	            }
            	        			  System.out.println("An order cannot have all the ingredients in exclusion for a menu item.");
            	        			 menuItem=4;
                        			 continue outer;
            	        		 }else {
            	        			 int traveserInput=0;
            	        			Iterator selectedIngredientsTemp=hSet.iterator();  
            	        			System.out.println("=================================================");
            	        			System.out.println("Selected exclusion Ingredients are ");
          	        	            while(selectedIngredientsTemp.hasNext()){
          	        	            	Integer exclusionIds=(Integer)selectedIngredientsTemp.next();
          	        	            	 System.out.println(mojitoIngredientList.get(exclusionIds)); 
          	        	            	 finalPrice-=(ingredientsPriceList.get(exclusionIds));
          	        	            }
                 	        		 
          	        	           System.out.println("Mojito price is="+finalPrice);
          	        	           System.out.println("============================================");
	          	        	       Iterator traverserItr=traversalList.iterator();  
	     	        	           innerCoffee: while(traverserItr.hasNext()){  
	     	        	            	  
	     	        	                System.out.println( traverserItr.next());  
	     	        	            } 
	     	        	           traveserInput=scan.nextInt();
	     	        	           if(traveserInput==1) {
	     	        	        	    menuType=1;
		                    			 continue coffeeJump;
	     	        	           }else if(traveserInput==2) {
	     	        	        	  menuItem=4;
	     	        	        	    continue outer;
	     	        	           }else {
	     	        	        	  System.out.println("Please enter valid input."); 
	     	        	           }
	          	        	         
            	        		 }            	        		
            	        		 
            	        	 }break;         	        	
            	        	 
            	        	 }
            	        	
            		  }while(menuType>0 && menuType<2);
            		  
            		 if(menuType>2) {
            			 menuItem=4;
            			 continue outer;
            		 }
            		break;
            	}
            		
            		default :
            			System.out.println("Thank you !");
            			System.exit(0) ;
            	}
        	 
        }
        while(menuItem>2);
       
        	
    }
}
