package entities;

public class pessoaFisica extends pessoa{
	private Double medicalExpense;
	
	public pessoaFisica() {
		super();
	}
	
	public pessoaFisica(String name, Double annualIncome, Double medicalExpense) {
		super(name, annualIncome);
		this.medicalExpense = medicalExpense;
	}

	public Double getMedicalExpense() {
		return medicalExpense;
	}

	public void setMedicalExpense(Double medicalExpense) {
		this.medicalExpense = medicalExpense;
	}

	@Override
	public Double taxesPaid() {
		Double annualIncome = getAnnualIncome();
		Double total;
		
		if(annualIncome < 20000) {
			total = annualIncome * 0.15;
			return total;
		}else{
			total = annualIncome * 0.25;
			if(this.medicalExpense != 0) {
				total = total - (getMedicalExpense() * 0.5);
				return total;
			}
			return total;
		}
	}
}
