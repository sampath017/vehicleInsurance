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
//		this.mi.createInsurances();

		String multiLineString = ("\n" + "Welcome to console based Vehicle Insurance Management System.\n"
				+ "The Rules are:\n" + "1. Type 'QUIT' to exit. \n" + "2. Type 'MU' to manage Underwriters. \n"
				+ "3. Type 'MI' to manage Insurances.");

		System.out.println(multiLineString);
		System.out.println();
	}

	public void loop() {
		boolean stop = false;
		String help = ("The Rules are:\n"
					+ "1. Type 'QUIT' to exit. \n"
					+ "2. Type 'MU' to manage Underwriters. \n"
					+ "3. Type 'MI' to manage Insurances."
				);

		while (this.game) {
			System.out.print("--> ");
			this.prompt = sc.nextLine().trim();
			if (this.prompt.equals("QUIT")) {
				stop = this.quit();
				if (!stop) {
					System.out.println(help);
				}
			} else if (this.prompt.equals("MU")) {
				this.viewUnderwriters();
				this.underwritersLoop();
				System.out.println(help);

			} else if (this.prompt.equals("MI")) {
				this.viewInsurances();
				this.insurancesLoop();
				System.out.println(help);
			} else {
				System.out.println("Please enter correct prompt!");
				System.out.println(help);
			}
		}
	}

	private boolean quit() {
		boolean stop = false;
		System.out.println(
				"Are you sure you want to quit.\n All the data is saved in memory and will be erased when quited!\n If yes press 'YES' else 'NO' to continue.");

		while (this.game) {
			System.out.print("--> ");
			String decision = this.sc.nextLine().trim();
			if (decision.equals("YES")) {
				System.out.println("Console quited!");
				this.game = false;
				stop = true;

			} else if (decision.equals("NO")) {
				System.out.println("Console is continuing.");
				break;
			}

			else {
				System.out.println("Please enter correct prompt!");
				System.out.println("press 'YES' else 'NO' to continue.");
			}
		}
		return stop;
	}

	private void viewUnderwriters() {
		System.out.println("\nThe present Underwriters are: \n");
		this.mu.viewUnderwriters();
	}

	private void underwritersLoop() {
		String multiLineString = (""
					+ "Underwriter console.\n" 
					+ "1. Create new Underwriter Press 'C'. \n"
					+ "2. Manage an Underwriter Press 'M'\n"
					+ "3. To view current Underwriters Press 'V'.\n"
					+ "4. To quit press 'QUIT'. \n"
					+ "5. To go back press 'B'. \n"
				);

		System.out.println(multiLineString);

		while (this.game) {
			System.out.print("--> ");
			this.prompt = this.sc.nextLine();
			if (this.prompt.equals("C")) {
				this.mu.addUnderwriters();
			} else if (this.prompt.equals("M")) {
				System.out.print("Enter the Underwriter id to manage: ");
				int id = this.sc.nextInt(); this.sc.nextLine();
				this.manageUnderwriters(id);
			} else if (this.prompt.equals("V")) {
				this.viewUnderwriters();
			} else if (this.prompt.equals("B")) {
				System.out.println("Back to manage console.");
				break;
			} else if (this.prompt.equals("QUIT")) {
				this.quit();
			} else {
				System.out.println("Please enter valid input!");
				System.out.println(multiLineString);
			}
		}
	}

	private void manageUnderwriters(int id) {
		String multiLineString = (""
				+ "Underwriter management system.\n" 
				+ "2. To view underwriter Press 'V'.\n"
				+ "3. Update underwriter password Press 'P'\n"
				+ "4. Delete underwriter Press 'D'\n"
				+ "5. To quit press 'QUIT'. \n"
				+ "6. To go back press 'B'. \n"
			);
		System.out.println(multiLineString);
		
		while (this.game) {
			System.out.print("--> ");
			this.prompt = this.sc.nextLine();
			
			if (this.prompt.equals("V")) {
				this.mu.viewUnderwriter(id);
			} else if (this.prompt.equals("P")) {
				this.mu.updateUnderwriterPassword(id);
			} else if (this.prompt.equals("D")) {
				this.mu.deleteUnderwriter(id);
			} else if (this.prompt.equals("QUIT")) {
				this.quit();
			} else if (this.prompt.equals("B")) {
				System.out.println("Back to manage console.");
				break;
			} else {
				System.out.println("Please enter valid input!");
				System.out.println(multiLineString);
			}
		}
	}

	private void insurancesLoop() {
		String multiLineString = (""
				+ "You can manage.\n"
				+ "1. Create new Insurance Press 'C'. \n"
				+ "2. Update an Insurance password Press 'M'\n"
				+ "3. To view current Insurances Press 'V'.\n"
				+ "4. To quit press 'QUIT'. \n" 
				+ "5. To go back press 'B'. \n"
				);

		System.out.println(multiLineString);

		while (this.game) {
			System.out.print("--> ");
			this.prompt = this.sc.nextLine();
			if (this.prompt.equals("C")) {
				this.mu.addUnderwriters();
			} else if (this.prompt.equals("M")) {
				System.out.print("Enter the Insurance id to manage: ");
				int id = this.sc.nextInt();
				this.sc.nextLine();
				this.mu.updateUnderwriterPassword(id);
			} else if (this.prompt.equals("V")) {
				this.viewUnderwriters();
			} else if (this.prompt.equals("B")) {
				System.out.println("Back to manage console.");
				break;
			} else if (this.prompt.equals("QUIT")) {
				this.quit();
			} else {
				System.out.println("Please enter valid input!");
				System.out.println(multiLineString);
			}
		}
	}
	private void viewInsurances() {
		
		System.out.println("\nThe present Underwriters are: \n");
		this.mu.viewUnderwriters();
	}
}
