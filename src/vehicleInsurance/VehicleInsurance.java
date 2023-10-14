package vehicleInsurance;

import java.util.ArrayList;
import java.util.Scanner;

class VehicleInsurance {
	int policyNo;
	int vehicleNo;
	String customerName;
	String toDate;
	String policyType;

	VehicleInsurance(int policyNo, int vehicleNo, String customerName, String toDate) {
		this.policyNo = policyNo;
		this.vehicleNo = vehicleNo;
		this.customerName = customerName;
		this.toDate = toDate;
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
	ArrayList<VehicleInsurance> insurances;

	ManageInsurance() {
		this.sc = new Scanner(System.in);
	}

	void createInsurances() {
		System.out.print("Enter number of insurances: ");

		int n = sc.nextInt(); sc.nextLine();
		this.insurances = new ArrayList<VehicleInsurance>(n);

		for (int i = 0; i < n; i++) {
			System.out.print("Insurance policyNo: ");
			int policyNo = this.sc.nextInt(); this.sc.nextLine();

			System.out.print("Insurance vehicleNo: ");
			int vehicleNo = this.sc.nextInt(); sc.nextLine();

			System.out.print("Insurance customerName: ");
			String customerName = this.sc.nextLine();
			
			System.out.print("Insurance toDate: ");
			String toDate = this.sc.nextLine();

			this.insurances.add(new VehicleInsurance(policyNo, vehicleNo, customerName, toDate));
		}

		System.out.println("All Insurances are taken.");
	}

	void updatePolicy() {
		System.out.println("Update Policy");

		System.out.print("Enter the policy no: ");
		int policyNo = this.sc.nextInt();

		System.out.print("Enter the date to updated: ");
		String toDate = this.sc.nextLine();

		for (VehicleInsurance vi : this.insurances) {
			if (vi.getPolicyNo() == policyNo) {
				int index = this.insurances.indexOf(vi);
				this.insurances.get(index).setToDate(toDate);
				System.out.println("Vehicle Insurance policy updated.");
			} else
				System.out.println("Vehicle Insurance not found!");
		}
	}

	void viewPolicy() {
		System.out.println("View Policy");

		System.out.print("Enter the policy no: ");
		int policyNo = this.sc.nextInt();

		for (VehicleInsurance vi : this.insurances) {
			if (vi.getPolicyNo() == policyNo) {
				System.out.println(vi.getPolicyNo());
				System.out.println(vi.getVehicleNo());
				System.out.println(vi.getCustomerName());
				System.out.println(vi.getToDate());
			} else
				System.out.println("Vehicle Insurance not found!");
		}
	}
}
