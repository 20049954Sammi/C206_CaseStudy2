
import java.time.LocalDate;
import java.util.ArrayList;



public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Stall
		Stall [] stallArray = new Stall [10];
		stallArray[0] = (new Stall(1, "Chicken Rice Stall", LocalDate.parse("2018-12-12")));
		stallArray[1] = (new Stall(2, "Western Food Stall", LocalDate.parse("2018-10-05")));
		

		//PromotionOffer
		ArrayList<PromotionOffer> Promotionlist = new ArrayList<PromotionOffer>();
		
		Promotionlist.add(new PromotionOffer(1,"Promotion setA food item",0));
		Promotionlist.add(new PromotionOffer(2,"Promotion setB food item",0));
		Promotionlist.add(new PromotionOffer(3,"Promotion setC food item",0));
		Promotionlist.add(new PromotionOffer(4,"Promotion setD food item",0));
		Promotionlist.add(new PromotionOffer(5,"Promotion setE food item",0));
		
			
		
		
		int option = 0;
		while(option != 6) {
			
	
			manu();
			option = Helper.readInt("Enter option: "); 
			
			if(option == 1) {
				stall(stallArray);
				
			}else if(option == 2) {
				
			}else if(option == 3) {
				
			}else if(option == 4) {
				PromotionOffer(Promotionlist, stallArray );
			}else if(option == 5) {
				
			}else if(option == 6) {
				System.out.println("Thank you!!");

			}else {
				System.out.println("Wrong option, please try agian!!");
			}
			
			
			
			
		}

	}
	
	public static void manu() {
		Helper.line(30, "-");
		System.out.println("Canteen Automation System");
		Helper.line(30, "-");
		
		System.out.println("1. Manage stall" );
		System.out.println("2. Manage food items " );
		System.out.println("3. Manage purchase orders  " );
		System.out.println("4. Manage promotion offers " );
		System.out.println("5. Manage orders by customer" );
		System.out.println("6. Quit" );
		
		System.out.println("" );
	}
	
	public static void stall(Stall []  stallList) {
		Helper.line(30, "-");
		System.out.println("Manage stall");
		Helper.line(30, "-");
		
		System.out.println("1. Add a new stall" );
		System.out.println("2. View an existing stall " );
		System.out.println("3. Delete an existing stall" );
		System.out.println("");
		
		int option = Helper.readInt("Enter option: "); 
		
		if(option == 1) {
			Stall newStall = inputStall();
			addStall(stallList, newStall);
			
		}else if(option == 2) {
			viewAllStall(stallList);
			
		}else if(option == 3) {
			deleteStall(stallList);

		}else {
			System.out.println("Wrong option, please try agian!!");

		}
	}
	
	//Add stall(Yi Zheng)
	public static Stall inputStall() {
		Helper.line(30, "-");
		System.out.println("Add Stall");
		Helper.line(30, "-");
		
		int StallID = Helper.readInt("Enter Stall ID > ");
		String StallName = Helper.readString("Enter Stall Name > ");
		LocalDate operationDate = LocalDate.parse(Helper.readString("Enter Operation Date > "));

		Stall newStall= new Stall(StallID, StallName, operationDate);
		return newStall;
		
	}
	public static void addStall(Stall [] stallList, Stall newStall) {
		
		boolean checkStall = checkStall(stallList, newStall);
		boolean checkStallNum = checkStallNum(stallList);
				
		if(checkStall == true && checkStallNum == true){
			for(int i = 0; i < stallList.length; i++) {
				if(stallList[i] == null) {
					stallList[i] = newStall;
					System.out.println("New Stall Added");
					break; 
				}
			}	
		}else if(checkStallNum == false){
			System.out.println("Stall Added Unsuccessful, total stalls in the canteen are full !!! ");

		}else{
			System.out.println("Stall Added Unsuccessful, Stall ID "+ newStall.getStallId() +" has been occupied in canteen !!! ");

		}
	}

	public static boolean checkStall(Stall [] stallList, Stall newStall){
		boolean check = true;
		for(int i = 0; i < stallList.length; i++) {
			if(stallList[i] != null ){
				if(stallList[i].getStallId() == newStall.getStallId()) {
					check = false;
				}
			}
		}
		
		return check;
	}
	
	public static boolean checkStallNum(Stall [] stallList){
		boolean check = false;
		
		for(int i = 0; i < stallList.length; i++) {
			if(stallList[i] == null) {
				check = true;
			}
		}
		
		return check;
	}
	
	//View stall (yi Zheng)
	public static String seachAllSatll(Stall [] stallList) {
		String output = "";
		
		for (int i = 0; i < stallList.length; i++) {
			if(stallList[i] != null){
				output += stallList[i].toString();
			}
		}
		return output;		
	}
	
	public static void viewAllStall(Stall [] stallList) {
		Helper.line(30, "-");
		System.out.println("View stall");
		Helper.line(30, "-");
		
		String output = String.format("%-15s%-25s%-25s\n", "Stall ID", "Stall Name",
				"Stall Operation Date");
		 output += seachAllSatll(stallList);	
		System.out.println(output);
	}
	
	//Delete stall (Yi Zheng)
	public static boolean doDeleteStall(Stall [] stallList, int StallID) {
		boolean isReturned = false;

		for (int i = 0; i < stallList.length; i++) {
			if(stallList[i] != null){
				if (StallID == stallList[i].getStallId()){
					stallList[i] = null; 
					
					isReturned = true;
				}
			}
		}
		return isReturned;
		
	}

	public static void deleteStall(Stall [] stallList) {
		viewAllStall(stallList);
		int StallID = Helper.readInt("Enter Stall ID > ");
		Boolean isReturned = doDeleteStall(stallList, StallID);
		
		if (isReturned == false) {
			System.out.println("Stall ID " +StallID+" not in the system!!!!");
		} else {
			System.out.println("Stall with " + StallID + " Delete!!!");
		}
	}
	
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}
	//================================= Promotion Offer (sammi) =================================
	public static void PromotionOffer(ArrayList<PromotionOffer>Promotionlist,Stall[] stallList ) {
		Helper.line(30, "-");
		System.out.println("Promotion Offer");
		Helper.line(30, "-");
		
		System.out.println("1. Add a Promotion Offer" );
		System.out.println("2. View an Promotion Offer " );
		System.out.println("3. Delete an Promotion Offer" );
		System.out.println("");
	
		int option = Helper.readInt("Enter option: "); 
		
		
		if(option == 1) {
			PromotionOffer newPromotion  = inputPromotion();
			addPromotionOffer(Promotionlist, newPromotion,stallList );
			
		}else if(option == 2) {
			viewAllPromotionOffer(Promotionlist);
			
		}else if(option == 3) {
			deletePromotionOffer(Promotionlist);

		}else {
			System.out.println("Wrong option, please try agian!!");

		}
	}
	//Add Promotion (Sammi)
	public static boolean checkToStallID(Stall [] stallList, int StallId ){
		boolean check = true;
		for(int i = 0; i < stallList.length; i++) {
		if(stallList[i] != null ){
		if(stallList[i].getStallId() == StallId) {
		check = false;
		}
		}
		}

		return check;
		}
		public static PromotionOffer inputPromotion() {
			
			int PromotionCode = Helper.readInt("Eniter Promotion Code > ");
			int StallId = Helper.readInt("Enter Stall ID > ");

			PromotionOffer pf= new PromotionOffer( PromotionCode, "",StallId);
			return pf;
			
		}
		public static void addPromotionOffer(ArrayList<PromotionOffer> Promotionlist, PromotionOffer pf,Stall [] stallList ) {
		boolean check=false;
		
		if (checkToStallID(stallList ,pf.getStallID())==false) {
				for (int i = 0; i < Promotionlist.size(); i++) {
					if(pf.getPromotionCode()==Promotionlist.get(i).getPromotionCode()&& Promotionlist.get(i).getStallID()==0) {
						Promotionlist.get(i).setStallID(pf.getStallID());
						System.out.println("PromotionCode: "+pf.getPromotionCode()+ pf.getFooditem()+ " added to Stall-ID: "+pf.getStallID());
					check=true;
					}

					 
				}
				
			
			}
		if(check==false) {
			System.out.println("Error Message:Has been added Promotion Code ");
		}
		
				
			
	}
		//View Promotion offer -sammi
		public static String AllPromotionOffer(ArrayList<PromotionOffer> Promotionlist) {
			String output = "";

			for (int i = 0; i < Promotionlist.size(); i++) {

				output += Promotionlist.get(i).toString();
			}
			return output;
			
	
		}
		public static void viewAllPromotionOffer(ArrayList<PromotionOffer> Promotionlist) {
			C206_CaseStudy.setHeader("Promotion Offer");
			String output = String.format("%-15s %-30s %-25s\n", "PromotionCode", "FoodItem", "Stall-ID");
			 output += AllPromotionOffer(Promotionlist);	
			System.out.println(output);
		}
		
		
		
		
	

		//detele Promotion offer (Sammi)
		public static void deletePromotionOffer(ArrayList<PromotionOffer> Promotionlist) {
			C206_CaseStudy.viewAllPromotionOffer(Promotionlist);
			int StallID = Helper.readInt("Enter Stall ID > ");
			int PromotionCode= Helper.readInt("Enter PromotionCode > ");
			Boolean isReturned = deletePromotionOffer(Promotionlist, PromotionCode);
			
			if (isReturned == true) {
				System.out.println("Invalid StallID ");
			} else {
				System.out.println("PromotionCode in Stall-ID" + StallID + " has been remove");
			}
		}
		public static boolean deletePromotionOffer(ArrayList<PromotionOffer> Promotionlist,int PromotionCode ) {
			boolean isReturned = false;

			for (int i = 0; i < Promotionlist.size(); i++) {
				 if (PromotionCode==Promotionlist.get(i).getStallID()) {
					 Promotionlist.get(i).setStallID(0);
				 }
					 
				 }
						
			
			return isReturned;
			
	}

}
