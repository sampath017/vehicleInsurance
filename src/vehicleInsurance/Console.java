package vehicleInsurance;

import java.util.Scanner;

class Console {
	private ManageUnderwriter mu;
	private ManageInsurance mi;
	private Scanner sc;
	private String prompt;
	private boolean game;

	Console() {
		this.mu = new ManageUnderwriter();
		this.mi = new ManageInsurance();
		this.sc = new Scanner(System.in);
		this.game = true;
	}
	
	public void start() {
		this.mu.createUnderwriters();
		this.mi.createInsurances();
		
		String multiLineString = ("" + "Welcome to console based Vehicle Insurance Management System.\n"
				+ "The Rules after getting the inputs are:\n" + "1. Type 'QUIT' to exit. 1\n"
				+ "2. Type 'MU' to manage Underwriters. 2\n" + "3. Type 'MI' to manage Insurances. 3");
		
		System.out.println(multiLineString);
	}

	public void loop() {
		while (this.game) {
			this.prompt = sc.nextLine().trim();
			if (this.prompt.equals("QUIT")) {
				this.quit();
			} else if (this.prompt.equals("MU")) {
				this.viewUnderwriters();
				this.manageUnderwriters();
			}
		}
	}

	private void quit() {
		System.out.println(
				"Are you sure you want to quit. All the data is saved in memory and will be erased when quited! If yes press 'YES'");
		String decision = this.sc.nextLine().trim();
		if (decision.equals("YES")) {
			System.out.println("Console quited!");
			this.game = false;
		}
	}
	
	private void viewUnderwriters() {
		System.out.println("The present Underwriters are: ");
		this.mu.viewUnderwriters();
	}
	
	private void manageUnderwriters() {
		
		String multiLineString = ("" + "You can manage.\n"
				+ "1. Create new Underwriter Press 'C'. \n"
				+ "2. Update an Underwriter password Press 'UP'\n");
		
		System.out.println(multiLineString);
		
		this.prompt = this.sc.nextLine();
		
		while (this.game) {
			if (this.prompt.equals("C")) {
				this.mu.createUnderwriters();
			} else if (this.prompt.equals("UP")) {
				System.out.println("Enter the Underwriter id to manage: ");
				int id = this.sc.nextInt();
				this.sc.nextLine();
				this.mu.updateUnderwriterPassword(id);
			} else if (this.prompt.equals("QUIT")) {
				this.quit();
			} else
				System.out.println("Please enter valid input!");
		}
	}
}
