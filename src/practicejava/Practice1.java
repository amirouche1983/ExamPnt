package practicejava;

import java.util.Scanner;

public class Practice1 {

	public static String CustomerName;
	public static String ProductName;
	public static double QuantityPurchased;
	public static double PricePrudoct;
	public static double GrossPay;
	public static double NetPay;
	public static double Discount;
	public static double Taxes;
	
	
			
	public static void Welcome() {
		System.out.println("===============");
		System.out.println("welcome to your favorit store");
		System.out.println("===============");
	}
	 
	public static void GetInput() {
		
		Scanner storScanner = new Scanner (System.in);
		System.out.println("Enter Customer Name");
		CustomerName= storScanner.nextLine();
		System.out.println("Enter Product Name ");
		ProductName= storScanner.nextLine();
		
		boolean continueToNextStep;
		
		do {
			try {
			storScanner= new Scanner(System.in);
				System.out.println("Enter Quantity Purchased");
				QuantityPurchased= storScanner.nextDouble();
				if(QuantityPurchased>0) {
					continueToNextStep= true;
				}else {
					System.out.println("please Enter a Quantity>0");
					continueToNextStep=false;
				}
				}catch(Exception Q) {
				System.out.println(" ERROR please Enter a Number>0");
				continueToNextStep=false;
				}	
			} while(!continueToNextStep);
			
		do {
			try {
			storScanner= new Scanner(System.in);
			System.out.println("Enter Price Prudoct");
			PricePrudoct = storScanner.nextDouble();
				if(PricePrudoct>1 && PricePrudoct<=200) {
					continueToNextStep= true;
				}else {
					System.out.println("please Enter a Price between 1-200");
					continueToNextStep=false;
				}
				}catch(Exception P) {
				System.out.println(" ERROR please Enter a Number 1-200");
				continueToNextStep=false;
				}	
			} while(!continueToNextStep);
			
	}
	
public static void CaculatSalary() {
	GrossPay();
	 CalculatNetPay();
	}
public static void GrossPay() {
	
	GrossPay=(QuantityPurchased * PricePrudoct)+ Taxes ;
}
public static void CalculatNetPay() {
	
	if (GrossPay>0 && GrossPay<100){
		
		Taxes=(GrossPay*2)/100;
     	Discount=0;
     	NetPay=GrossPay-(Discount+Taxes);
     } else if (GrossPay>=100 && GrossPay<500 ) {
    	 Taxes=(GrossPay*4)/100;
    	 Discount=5;
    	 NetPay=GrossPay-(Discount+Taxes);
     	    }else if (GrossPay>=500 &&GrossPay<1000) {
     	    	Taxes=(GrossPay*6)/100;
     	    	Discount=20;
     	    	NetPay=GrossPay-(Discount+Taxes);
     	    }else if (GrossPay>=1000 ) {
     	    	Taxes=(GrossPay*8)/100;
     	    	Discount=30;
     	    	NetPay=GrossPay-(Discount+Taxes);
     	}else {GrossPay=0;
     	       System.out.println("error");
     	}
	
}
public static void DisplayOutput() {
	System.out.println( );
	System.out.println(" ====================");
	System.out.println(" Customer Name is   :" +CustomerName);
	System.out.println(" Product Name is    :" +ProductName);
	System.out.println("=====================");
	System.out.println(" Gross Pay is      $:" +GrossPay);
	System.out.println(" Total Taxes are   $:" +Taxes );
	System.out.println(" Your Discount is  $:" +Discount);
	System.out.println("------==========------");
	System.out.println(" Net Pay is        $:" +NetPay);
	
}
public static boolean DoYouWantToContinue() {
	String doYouWantToContinue;
	Scanner MyScan = new Scanner(System.in);
	doYouWantToContinue= MyScan.nextLine();
	if(doYouWantToContinue.equals("yes")) {
	return true;
	}
	return false;
}
public static void Exit() {
	System.out.println();
	System.out.println("thank for Visitig your favorit store");
	System.out.println();
}
	public static void main(String[] args) {
		
		Welcome();
		GetInput();
		CaculatSalary();
		DisplayOutput();
		Exit();
	}

}
