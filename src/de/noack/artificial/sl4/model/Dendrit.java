package de.noack.artificial.sl4.model;

public class Dendrit {

	private Soma parentSoma;
	private double sumOfSignals;

	public Dendrit(Soma parentDendrit) {
		this.parentSoma = parentDendrit;
		sumOfSignals = 0;
	}

	public void receiveInputSignal(double signal) {
		sumOfSignals += signal;
	}

	public Soma getParentSoma() {
		return parentSoma;
	}

	public double getSumOfSignals() {
		return sumOfSignals;
	}
}
