package de.noack.artificial.sl4.model;

public class Employee extends Neuron {

	private String name;

	public Employee(String name, int layer) {
		super(layer, 0.5D);
		this.name = name;
	}
}
