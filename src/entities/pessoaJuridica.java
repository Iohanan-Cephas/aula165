package entities;

public class pessoaJuridica extends pessoa{
	private Integer employeeQty;
	
	public pessoaJuridica() {
		super();
		
	}
	
	public pessoaJuridica(String name, Double annualIncome, Integer employeeQty) {
		super(name, annualIncome);
		this.employeeQty = employeeQty;
	}

	public Integer getEmployeeQty() {
		return employeeQty;
	}

	public void setEmployeeQty(Integer employeeQty) {
		this.employeeQty = employeeQty;
	}

	@Override
	public Double taxesPaid() {
		Double annualIncome = getAnnualIncome();
		Double total;
		
		if(this.employeeQty > 10) {
			total = annualIncome * 0.14;
			return total;
		}else{
			total = annualIncome * 0.16;
			return total;
		}
	}
}
