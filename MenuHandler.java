import java.util.*;




public class MenuHandler {
	
	public static void main(String[] args) { 
		String a = "hello";
		String b = "f@e";
		String c = "df";
		String d = "l";
		
		Staff staff = new Staff(a,b,c,d);
		System.out.println("here");
		showStaffMenu(staff);
	}
	
	public static void printStudentMenu(Student student) {
			System.out.println("0. Logout");
			System.out.println("1. View Camps");
			System.out.println("2. Register Camp");
			System.out.println("3. View Registered Camps");
			System.out.println("4. Withdraw Camp");
			System.out.println("5. Submit Enquiry");
			System.out.println("6. View Enquiries");
			System.out.println("7. View Enquiry Replies");
			System.out.println("8. Edit Enquiry");
			System.out.println("9. Delete Enquiry");
			if(student.isCommitteeMember()) {
				System.out.println("10. Reply Enquiry");
				System.out.println("11. View Suggestions");
				System.out.println("12. Edit Suggestions");
				System.out.println("13. Submit Suggestions");
				System.out.println("14. Delete Suggestions");
				System.out.println("15. View Camp Details");	
			}
		}

	
	public static void printStaffMenu() {
			System.out.println("1. Create Camp");
			System.out.println("2. Edit Camp");
			System.out.println("3. Delete Camp");
			System.out.println("4. Toggle Visibility");
			System.out.println("5. View All Camps");
			System.out.println("6. View My Camps");
			System.out.println("7. View Enquiries");
			System.out.println("8. Reply Enquiry");
			System.out.println("9. View Suggestions");
			System.out.println("10. Approve Suggestions");
			System.out.println("11. Generate Report");
			System.out.println("12. Exit");
	
	}
	
	public static void showStudentMenu(Student student) {
		//student actions:
		// - view open camps
		// - register/withdraw from camp
		// - submit enquiry for the camp they registered
		// - view registered camp
		
		//if they are committee member actions:
			//

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printStudentMenu(student);
			
			int choice = sc.nextInt();
			
			sc.nextLine();
			
			if(choice==0) return;
			
			if(student.isCommitteeMember()) {
				InputHandler.handleCommitteeMemberChoice(student,choice);
			}
			
			else {
				InputHandler.handleStudentChoice(student,choice);
			}
				
				
			}
		}
		
	public static void showStaffMenu(Staff staff) {
		//staff actions:
		// - create/edit/delete camp
		// - toggle camp visibility
		// - view all camps
		// - view camps created
		// - view/reply to enquiries
		// - approve suggestions
		// - generate reports
		Scanner sc = new Scanner(System.in);
		while(true) {
			printStaffMenu();
			
			int choice = sc.nextInt();
			
			sc.nextLine();
			
			if(choice==12) return;
			
			InputHandler.handleStaffChoice(staff,choice);
			}
		}	
	}

