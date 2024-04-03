package edu.miu.cs.cs489appsd.lab1b.productmgmtapp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs489appsd.lab1b.productmgmtapp.model.Employee;
import edu.miu.cs.cs489appsd.lab1b.productmgmtapp.model.PensionPlan;

@SpringBootApplication
public class ProductmgmtappApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProductmgmtappApplication.class, args);
		Employee[] emps = {
				new Employee("Daniel", "Agar", 105945.50, LocalDate.of(2018, 1, 17)),
				new Employee("Benard", "Shaw", 197750.00, LocalDate.of(2019, 05, 03)),
				new Employee("Carly", "Agar", 842000.75, LocalDate.of(2014, 05, 16)),
				new Employee("Wesley", "Schneider", 74500.00, LocalDate.of(2019, 05, 02))
		};

		@SuppressWarnings("unused")
		PensionPlan p1 = new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00, emps[0]);
		@SuppressWarnings("unused")
		PensionPlan p2 = new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50, emps[2]);

		printAll(emps);
		System.out.println("------------------------------------------------------------------------------------");
		printMUEReport(emps);
	}

	private static void printAll(Employee[] emps) {
		Arrays.sort(emps, (e1, e2) -> {
			if (e1.getLastName().equals(e2.getLastName())) {
				return (int) (e2.getYearlySalary() - e1.getYearlySalary());
			}
			return e1.getLastName().compareTo(e2.getLastName());
		});

		StringBuilder str = new StringBuilder("[");
		for (Employee e : emps) {
			str.append(e);
		}
		str.append("]");
		System.out.println(str.toString());
	}

	private static void printMUEReport(Employee[] emps) {
		Arrays.sort(emps, Comparator.comparing(Employee::getEmploymentDate));

		StringBuilder sb = new StringBuilder("[");
		for (Employee e : emps) {
			if (e.getPensionPlan() == null && LocalDate.now().getYear() - e.getEmploymentDate().getYear() > 4
					&& e.getEmploymentDate().getMonth().equals(LocalDate.now().getMonth().plus(1))) {
				sb.append(e);

			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

}
