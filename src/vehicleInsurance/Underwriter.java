package vehicleInsurance;

import java.util.ArrayList;
import java.util.Scanner;

public class Underwriter {
	private int id;
	private String name;
	private String password;

	Underwriter(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	int getId() {
		return this.id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getName() {
		return this.name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getPassword() {
		return this.password;
	}

	void setPassword(String password) {
		this.password = password;
	}
}

class ManageUnderwriter {
	Scanner sc;
	ArrayList<Underwriter> underwriters;

	ManageUnderwriter() {
		this.sc = new Scanner(System.in);
	}

	public void createUnderwriters() {
		System.out.print("Enter number of underwriters: ");

		int n = sc.nextInt();
		sc.nextLine();
		this.underwriters = new ArrayList<Underwriter>(n);

		for (int i = 0; i < n; i++) {
			System.out.print("Underwriter id: ");
			int id = this.sc.nextInt();
			this.sc.nextLine();

			System.out.print("Underwriter name: ");
			String name = this.sc.nextLine();

			System.out.print("Underwriter password: ");
			String password = this.sc.nextLine();

			this.underwriters.add(new Underwriter(id, name, password));
		}

		System.out.println("\nAll Underwriters are taken.");
	}

	public void addUnderwriters() {
		System.out.print("Enter number of underwriters: ");

		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<Underwriter> newUnderwriters = new ArrayList<Underwriter>(n);

		for (int i = 0; i < n; i++) {
			System.out.print("Underwriter id: ");
			int id = this.sc.nextInt();
			this.sc.nextLine();

			System.out.print("Underwriter name: ");
			String name = this.sc.nextLine();

			System.out.print("Underwriter password: ");
			String password = this.sc.nextLine();

			newUnderwriters.add(new Underwriter(id, name, password));
		}
		this.underwriters.addAll(newUnderwriters);
		newUnderwriters.clear();
		System.out.println("All Underwriters are taken.");
	}

	public void viewUnderwriter(int id) {
		for (Underwriter uw : this.underwriters) {
			if (uw.getId() == id) {
				System.out.println("Underwriter Id: " + uw.getId());
				System.out.println("Underwriter Name: " + uw.getName());
				System.out.println("Underwriter Password: " + uw.getPassword());
			} else
				System.out.println("No Underwriter found!");
		}
	}

	public void updateUnderwriterPassword(int id) {
		boolean found = false;
		int index = -1;
		for (Underwriter uw : this.underwriters) {
			if (uw.getId() == id) {
				index = this.underwriters.indexOf(uw);
				found = true;
			} else
				found = false;
		}

		if (found) {
			System.out.print("Enter the underwriter password to be updated: ");
			String password = this.sc.nextLine();
			this.underwriters.get(index).setPassword(password);
			System.out.println("Underwriter updated.");
		} else
			System.out.println("No Underwriter found!");
	}

	public void deleteUnderwriter(int id) {
		for (Underwriter uw : this.underwriters) {
			if (uw.getId() == id) {
				int index = this.underwriters.indexOf(uw);
				this.underwriters.remove(index);
				System.out.println("Underwriter deleted.");
			} else
				System.out.println("No Underwriter found!");
		}
	}


	public void viewUnderwriters() {
		for (Underwriter uw : this.underwriters) {
			System.out.println("Underwriter Id: " + uw.getId());
			System.out.println("Underwriter Name: " + uw.getName());
			System.out.println("Underwriter Password: " + uw.getPassword());
			System.out.println();
		}
	}
}
