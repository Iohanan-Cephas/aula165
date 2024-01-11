package appMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.pessoa;
import entities.pessoaFisica;
import entities.pessoaJuridica;

public class main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner reader = new Scanner(System.in);
		List<pessoa> list = new ArrayList<pessoa>();
		
		System.out.print("Enter the number of tax payers: ");
		int N = reader.nextInt();
		
		for(int i = 0; i < N; i++) {
			reader.nextLine();
			System.out.println("Tax payer #"+ (i+1) +" data:");
			System.out.print("Individual or Company? (i/c) ");
			char input = reader.next().charAt(0);
			System.out.print("Name: ");
			String name = reader.next();
			
			System.out.print("Annual income: ");
			Double annualIncome = reader.nextDouble();
			
			if(input == 'i') {
				System.out.print("Health expenditures: ");
				Double medicalExpense = reader.nextDouble();
				
				pessoaFisica x = new pessoaFisica(name, annualIncome, medicalExpense);
				list.add(x);
			}else if(input == 'c') {
				System.out.print("Number of employees: ");
				Integer employeeQty = reader.nextInt();
				
				pessoaJuridica x = new pessoaJuridica(name, annualIncome, employeeQty);
				list.add(x);
			}
		}
		
		Double totalTaxes = 0.0;
		System.out.println("TAXES PAID:");
		for(pessoa x : list) {
			System.out.println(x.getName()+": $"+String.format("%.2f", x.taxesPaid()));
			totalTaxes += x.taxesPaid();
		}
		
		System.out.println("TOTAL TAXES: $"+String.format("%.2f", totalTaxes));
		reader.close();
	}
}
