package vehicleInsurance;

import java.util.ArrayList;
import java.util.Scanner;


class Insurance {
	int policyNo;
	int vehicleNo;
	int customerId;

	String customerName;
	String toDate;
	String policyType;

	Insurance(int policyNo, int vehicleNo, int customerId, String customerName, String toDate, String policyType) {
		this.policyNo = policyNo;
		this.vehicleNo = vehicleNo;
		this.customerId = customerId;

		this.customerName = customerName;
		this.toDate = toDate;
		this.policyType = policyType;
	}

	int getPolicyNo() {
		return this.policyNo;
	}

	void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	int getVehicleNo() {
		return this.vehicleNo;
	}

	void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	int getCustomerId() {
		return customerId;
	}

	void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	String getCustomerName() {
		return this.customerName;
	}

	void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	String getToDate() {
		return this.toDate;
	}

	void setToDate(String toDate) {
		this.toDate = toDate;
	}

	String getPolicyType() {
		return this.policyType;
	}

	void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
}

class ManageInsurance {
	Scanner sc;
	ArrayList<Insurance> insurances;

	ManageInsurance() {
		this.sc = new Scanner(System.in);
	}

	void createInsurances() {
		System.out.print("\nEnter number of insurances: ");

		int n = sc.nextInt();
		sc.nextLine();
		this.insurances = new ArrayList<Insurance>(n);

		for (int i = 0; i < n; i++) {
			System.out.print("Insurance policyNo: ");
			int policyNo = this.sc.nextInt();
			this.sc.nextLine();

			System.out.print("Insurance vehicleNo: ");
			int vehicleNo = this.sc.nextInt();
			sc.nextLine();

			System.out.print("Insurance customerId: ");
			int customerId = this.sc.nextInt();
			sc.nextLine();

			System.out.print("Insurance customerName: ");
			String customerName = this.sc.nextLine();

			System.out.print("Insurance toDate: ");
			String toDate = this.sc.nextLine();
			
			System.out.print("Insurance policyType: ");
			String policyType = this.sc.nextLine();

			this.insurances.add(new Insurance(policyNo, vehicleNo, customerId, customerName, toDate, policyType));
		}

		System.out.println("All Insurances are taken.\n");
	}

	public void addInsurances() {
		System.out.print("\nEnter number of insurances: ");

		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<Insurance> newInsurances = new ArrayList<Insurance>(n);

		for (int i = 0; i < n; i++) {
			System.out.print("Insurance policyNo: ");
			int policyNo = this.sc.nextInt();
			this.sc.nextLine();

			System.out.print("Insurance vehicleNo: ");
			int vehicleNo = this.sc.nextInt();
			sc.nextLine();

			System.out.print("Insurance customerId: ");
			int customerId = this.sc.nextInt();
			sc.nextLine();

			System.out.print("Insurance customerName: ");
			String customerName = this.sc.nextLine();

			System.out.print("Insurance toDate: ");
			String toDate = this.sc.nextLine();
			
			System.out.print("Insurance policyType: ");
			String policyType = this.sc.nextLine();

			newInsurances.add(new Insurance(policyNo, vehicleNo, customerId, customerName, toDate, policyType));
		}

		this.insurances.addAll(newInsurances);
		insurances.clear();
		System.out.println("All Insurances are taken.");
	}

	void updatePolicyDate() {
		System.out.println("Update Policy date.");

		System.out.print("Enter the policy no: ");
		int policyNo = this.sc.nextInt(); this.sc.nextLine();

		System.out.print("Enter the date to updated: ");
		String toDate = this.sc.nextLine(); 

		for (Insurance in : this.insurances) {
			if (in.getPolicyNo() == policyNo) {
				int index = this.insurances.indexOf(in);
				this.insurances.get(index).setToDate(toDate);
				System.out.println("Insurance policy date updated.");
			} else
				System.out.println("Insurance not found!");
		}
	}
	
	void updatePolicyType() {
		System.out.println("Update Policy type.");

		System.out.print("Enter the policy no: ");
		int policyNo = this.sc.nextInt(); this.sc.nextLine();

		System.out.print("Enter the policy type to updated: ");
		String policyType = this.sc.nextLine(); 

		for (Insurance in : this.insurances) {
			if (in.getPolicyNo() == policyNo) {
				int index = this.insurances.indexOf(in);
				this.insurances.get(index).setToDate(policyType);
				System.out.println("Insurance policy type updated.");
			} else
				System.out.println("Insurance not found!");
		}
	}

	void viewInsurance() {
		System.out.println("View Insurance");

		System.out.print("Enter the policy no: ");
		int policyNo = this.sc.nextInt();

		for (Insurance in : this.insurances) {
			if (in.getPolicyNo() == policyNo) {
				System.out.println(in.getPolicyNo());
				System.out.println(in.getVehicleNo());
				System.out.println(in.getCustomerId());
				System.out.println(in.getCustomerName());
				System.out.println(in.getToDate());
				System.out.println(in.getPolicyType());
			} else
				System.out.println("Insurance not found!");
		}
	}

	public void viewInsurances() {
		for (Insurance in : this.insurances) {
			System.out.println("Insurance PolicyNo: " + in.getPolicyNo());
			System.out.println("Insurance VehicleNo: " + in.getVehicleNo());
			System.out.println("Insurance CustomerId: " + in.getCustomerId());
			System.out.println("Insurance CustomerName: " + in.getCustomerName());
			System.out.println("Insurance ToDate: " + in.getToDate());
			System.out.println("Insurnace PolicyType: " + in.getPolicyType());
		}
	}
}
