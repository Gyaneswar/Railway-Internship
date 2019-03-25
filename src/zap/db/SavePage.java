package zap.db;
public class SavePage 
{
	private String Name,Loa,Agree,Agency,Contract,Completion,Revenue,Department;
	
	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getLoa() {
		return Loa;
	}

	public void setLoa(String loa) {
		Loa = loa;
	}

	public String getAgree() {
		return Agree;
	}

	public void setAgree(String agree) {
		Agree = agree;
	}

	public String getAgency() {
		return Agency;
	}

	public void setAgency(String agency) {
		Agency = agency;
	}

	public String getContract() {
		return Contract;
	}

	public void setContract(String contract) {
		Contract = contract;
	}

	public String getCompletion() {
		return Completion;
	}

	public void setCompletion(String completion) {
		Completion = completion;
	}

	public String getRevenue() {
		return Revenue;
	}

	public void setRevenue(String revenue) {
		Revenue = revenue;
	}
}
