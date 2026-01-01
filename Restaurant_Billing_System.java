import java.util.Scanner;
class Restaurant{
	String name;
	int items;
	int quantity;
	int total=0;
	int discount;
	int price=0;
	int grandTotal = 0;
	String dish_name="";
	int tax_gst;  //3%tax_gst+Gst
	
	// Method to select a dish and calculate the price
	void chooseDish(int items,int quantity){
		this.items=items;
		this.quantity=quantity;
		
			//Assign price and name of dish based on dish selection
			switch(this.items){
				case 1:
					price=480;
					dish_name="Gujarati Dish.    ";
					break;
				case 2:
					price=300;
					dish_name="Panjabi Dish.     ";
					break;
				case 3:
					price=350;
					dish_name="South Indian Dish.";
					break;
				case 4:
					price=420;
					dish_name="Mexican Dish.     ";
					break;
				case 5:
					price=500;
					dish_name="Italian Dish.     ";
					break;
				case 6:
					price=450;
					dish_name="Chinese Dish.     ";
					break;
				case 7:
					price=250;
					dish_name="Burger Mill.      ";
					break;
				case 8:
					price=150;
					dish_name="Chole Bhature.    ";
					break;
				case 9:
					price=90;
					dish_name="Pani Puri.        ";
					break;
				case 10:
					price=30;
					dish_name="Butter Milk.      ";
					break;
				case 11:
					price=70;
					dish_name="Coffee.           ";
					break;
				case 12:
					price=20;
					dish_name="Soda.             ";
					break;
				case 13:
					price=80;
					dish_name="Mocktail.         ";
					break;
				case 14:
					price=25;
					dish_name="Soft Drink.       ";
					break;
				case 15:
					price=25;
					dish_name="Coca_Cola.        ";
					break;
				case 16:
					price=100;
					dish_name="Cheese Cake.      ";
					break;
				case 17:
					price=100;
					dish_name="Chocolate Cake.   ";
					break;
				case 18:
					price=100;
					dish_name="Red Velvet Cake.  ";
					break;
				case 19:
					price=70;
					dish_name="ChocoLava Cake.   ";
					break;
				case 20:
					price=50;
					dish_name="Ice Cream.        ";
					break;
				default:
					System.out.println("Invalid Choice Please Try Again.");
					return;
			}
			//calculate total price based on qunatity
			total=total+(price*quantity);			
	}
}
	
	// class to calculate and display the total bill
class Total_Bill extends Restaurant{
	
	// Method to display the total bill with applied tex and discount
	 void totalBill(Restaurant[] orders, int orderCount,String name) {
		 this.name=name;
			System.out.println();
			System.out.println();
			System.out.println("***********************************************************************");
			System.out.println("------------------Your Bill--------------------------------------------");
			System.out.println("***********************************************************************");
			System.out.println("* Name: "+name);
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* Items                Quantity   Price                                ");
			System.out.println("-----------------------------------------------------------------------");
			
			//Loop through each order and display details
			for (int i = 0; i < orderCount; i++) {
				if(orders[i]!=null && orders[i].items<=20 && orders[i].quantity>0){
					for(int j=i+1;j<orderCount;j++)
					{
					if(orders[j]!=null && orders[i].dish_name==orders[j].dish_name)
					{
						orders[i].quantity+=orders[j].quantity;
						orders[j]=null;
						break;
					}						
					}
				System.out.println("* "+orders[i].dish_name + "      " + orders[i].quantity + "    = " + (orders[i].price * orders[i].quantity)+" Rupees.");
				}
				else{
					continue;
				}
				//Calculate grand total
				grandTotal += orders[i].price * orders[i].quantity;
			}
			
			//Apply 3% tax and GST to the total bill 
			this.tax_gst=(grandTotal*3)/100;
			grandTotal=grandTotal+tax_gst;
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* Total      :" + (grandTotal-this.tax_gst)+ " Rupees. ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* Total Bill :" + grandTotal+ " Rupees. (With 3% tax+Gst) ");
			//Apply discount
			Discount(grandTotal);
	 }
        // Method to apply a discount based on total bill amount 
	void Discount(int grandTotal){
			Scanner sc = new Scanner(System.in);
			
			if(grandTotal<=1500){
				discount=0;
			}
			if(grandTotal>1500 && grandTotal<=2500){
				discount=1;
			}
			if(grandTotal>2500 && grandTotal<=3500){
				discount=2;
			}
			if(grandTotal>3500 && grandTotal<=5000){
				discount=3;
			}
			if(grandTotal>5000){
				discount=5;
			}
			
			System.out.println("-----------------------------------------------------------------------");
			
			grandTotal -= (grandTotal * discount) / 100;
			System.out.println();
			System.out.println("* Total Bill After "+discount+"% Discount : " + grandTotal+" Rupees. ");
			System.out.println();
			System.out.println("***********************************************************************");
			
    }
}
	
//class to display the restaurant menu	
class Manu{
    Manu(){
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println("*		  Wellcome to the Flavour and Fork Restaurant                  *");
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println("*		              This is the manu                                 *");
		System.out.println("********************************************************************************");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("*                          --Unlimited Dishes--                                *");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("* 1.Gujarati Dish.      =480 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Sev Tamater Sabzi.    # Roti.             # Halwa.                     *");
		System.out.println("*     # Baingan Bharta.       # Puri.             # Butter Milk.               *");
		System.out.println("*     # Chana Sabzi.          # Papad.            # Dal Chawal.                *");
		System.out.println("********************************************************************************");
		System.out.println("* 2.Panjabi Dish.       =300 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Paneer Tikka.         # Paratha.          # Gulab Jamun.               *");
		System.out.println("*     # Panner Bhurji.        # Makki ki Roti.    # Lassi.                     *");
		System.out.println("*     # Palak Paneer.         # Papad.            # Jeera Rice & Dal Tadka.    *");
		System.out.println("********************************************************************************");
		System.out.println("* 3.South Indian Dish.  =350 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Masala Dosa.          # Plain Rice.       # Green Chutney.             *");
		System.out.println("*     # Plain Dosa.           # Rasam.            # Coconut Chutney.           *");
		System.out.println("*     # Idli sambar.          # Fresh curd.       # Butter Milk.               *");
		System.out.println("********************************************************************************");
		System.out.println("* 4.Mexican Dish.       =420 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Pari Pari Nachos.     # Veg Tacos.        # Churros.                   *");
		System.out.println("*     # Loaded Nachos.        # French Fries.                                  *");    
		System.out.println("*     # Burritos.             # Cheese Tacos.                                  *"); 	
		System.out.println("********************************************************************************");
		System.out.println("* 5.Italian Dish.       =500 Rupees.                                           *");
        System.out.println("*                                                                              *");		
		System.out.println("*     # 7 Cheese Pizza.       # Aglio Olio.       # White sauce Pasta.         *");
		System.out.println("*     # Margherita.           # Spaghetti.        # Red sauce Pasta.           *");
		System.out.println("*     # Veg Pizza.            # Veg Spaghetti.    # Veg Pasta.                 *");
		System.out.println("********************************************************************************");
		System.out.println("* 6.Chinese Dish.       =450 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Nuddles.              # Hot and sour.     # Fried Rice.                *");
		System.out.println("*     # Manchurian.           # Manchow Soup.     # Spring rolls.              *");
		System.out.println("*     # Chow mein.            # Chilli Potato.    # Pan cake.                  *");	
		System.out.println("********************************************************************************");
		System.out.println("* 7.Burger Mill.        =250 Rupees.                                           *");
		System.out.println("*                                                                              *");
		System.out.println("*     # Veg Burger.           # French Fries.      # Coca-cola.                *");
		System.out.println("********************************************************************************");
		System.out.println("* 8.Chole Bhature.      =150 Rupees.                                           *");
		System.out.println("********************************************************************************");
		System.out.println("* 9.Pani Puri.          =90 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("*                             --Drinks--                                       *");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("* 10.Butter Milk.       =30 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 11.Coffee.            =70 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 12.Soda.              =20 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 13.Mocktail.          =80 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 14.Soft Drink.        =25 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 15.Coca-Cola          =25 Rupees.                                            *");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("*                           --Sweet Dishes--                                   *");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("* 16.Cheese Cake.       =100 Rupees.                                           *");
		System.out.println("********************************************************************************");
		System.out.println("* 17.Chocolate Cake.    =100 Rupees.                                           *");
		System.out.println("********************************************************************************");
		System.out.println("* 18.Red Velvet Cake.   =100 Rupees.                                           *");
		System.out.println("********************************************************************************");
		System.out.println("* 19.ChocoLava Cake.    =70 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("* 20.Ice Cream.         =50 Rupees.                                            *");
		System.out.println("********************************************************************************");
		System.out.println("********************************************************************************");
		System.out.println();
		
	}
}

//Main class to execute the programs 
class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Restaurant orders[] = new Restaurant[100];
		int orderCount = 0;
		boolean exit = false;
		Total_Bill bill = new Total_Bill();

		System.out.println("-----Enter Your Full Name-----");
		String name = sc.nextLine();

		do {
			System.out.println("\nChoose an option:");
			System.out.println("1. Display Menu");
			System.out.println("2. Order Dish");
			System.out.println("3. Generate Bill and Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
				    System.out.println();
					System.out.println();
					 Manu manu = new Manu();  // Display menu
					break;

				case 2:
					System.out.println();
					System.out.println();
					while (true) {
                        System.out.print("Enter Dish Number (or 0 to Finish): ");
                        int items = sc.nextInt();
                        if (items == 0) {
                            System.out.println("Order completed.");
                            break;
                        }

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();
                        orders[orderCount] = new Restaurant();
                        orders[orderCount].chooseDish(items, quantity);
                        orderCount++;
                    }
                    break;
		

				case 3:
					if (orderCount > 0) {
						bill.totalBill(orders, orderCount, name);
					} else {
						System.out.println("No orders placed.");
					}
					System.out.println("***********************************************************************");
					System.out.println("*                     Thank You For Coming.                           *");
					System.out.println("-----------------------------------------------------------------------");
					System.out.println("*                        Visit again.                                 *");
					System.out.println("***********************************************************************");
					exit = true;
					break;

				default:
					System.out.println("Invalid choice. Please enter a valid option.");
			}
		} while (!exit);
		sc.close();
	}
}
