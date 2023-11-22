import java.util.*;

public class CampApp {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args0) {
		CampApp app = new CampApp();
		app.run();
	}	
	
	public void run() {
		UserManager UserManager = new UserManager();
		while(true) {
			System.out.println("1.login");
			System.out.println("2.exit");
			
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					User authenticatedUser = UserManager.login();
					if(authenticatedUser !=null) {
						handleUserMenu(authenticatedUser);
					}
					else {
						System.out.println("Incorrect authn");
					}
					break;
				case 2:
					sc.close();
					return;
				default:
					System.out.println("Invalud choice. Please try again");
					break;
			}
		}
	}

	private void handleUserMenu(User User) {
		// TODO Auto-generated method stub
		if(User instanceof Student) {
			MenuHandler.showStudentMenu((Student) User);
		}
		else if(User instanceof Staff) {
			MenuHandler.showStaffMenu((Staff) User);
		}
	}
	
//	public List<Camp> loadCamps(String file) {
//		List<Camp> Camps = new ArrayList<>();
//		
//		String[] lines = CSVReader.getLines(file);
//		
//		for (String line: lines) {
//			String[] part = line.split(",");
//			
//			String name = part[0];
//			Date startDate = DateStr.strToDate(part[1]);
//			Date endDate= DateStr.strToDate(part[2]);
//			Date registrationDeadline= DateStr.strToDate(part[3]);
//			String location= part[4];
//			int totalSlots= Integer.parseInt(part[5]);
//			int campCommitteeSlot= Integer.parseInt(part[6]);
//			String description= part[7];
//			boolean visible = Boolean.parseBoolean(part[9]);
//			boolean onlyFaculty = Boolean.parseBoolean(part[10]);
//			String staffInCharge= part[8];
//			Staff inCharge = findStaffById(staffInCharge);
//			
//			Camp camp = new Camp(name,startDate,endDate,registrationDeadline,location,
//					totalSlots,campCommitteeSlot,description,inCharge,visible,onlyFaculty);
//			
//			Camps.add(camp);
//		}
//		return Camps;
//	}
	
}