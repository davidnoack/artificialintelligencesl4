package de.noack.artificial.sl4.model;

import java.util.HashSet;
import java.util.Set;

public class Team {

	private Set <Employee> employees = new HashSet <>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void sendExternalSignalToAllEmployees(double signal) {
		for(Employee employee : employees) {
			employee.getSoma().getRandomDendrit().receiveInputSignal(signal);
		}
	}

	public void processInput() {
		for(Employee employee : employees) {
			employee.getSoma().sumWeights();
			employee.sendSignalIfThresholdExceeded(employee.getSoma().getSumOfWeights());
		}
	}
}
