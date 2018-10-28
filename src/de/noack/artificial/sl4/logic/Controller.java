package de.noack.artificial.sl4.logic;

import de.noack.artificial.sl4.model.Employee;
import de.noack.artificial.sl4.model.Team;

public class Controller {

	private Team team;

	public void initializeContext() {
		team = new Team();

		// Layer 0: Außendienst
		team.addEmployee(new Employee("Eve", 0));
		team.addEmployee(new Employee("Adam", 0));

		// Layer 1: Arbeit
		team.addEmployee(new Employee("Peter", 1));
		team.addEmployee(new Employee("Sarah", 1));
	}

	public void sendSignal(double signal) {
		team.sendExternalSignalToAllEmployees(signal);
	}
}
