package de.noack.artificial.sl4.model;

/**
 * Die Klasse Neuron stellt eine Nervenzelle dar.
 */
public class Neuron {

	private double state; // Zwischen 0 und 1
	private Soma soma;
	private Axon axon;
	private int layer;

	public Neuron(int layer, double threshold) {
		state = 0;
		this.soma = new Soma(this, threshold);
		this.axon = new Axon();
		this.layer = layer;
	}

	public void sendSignalIfThresholdExceeded(double signal) {
		if(soma.sumOfWeightsExceedsThreshold()) axon.sendSignal(signal);
	}

	public Soma getSoma() {
		return soma;
	}
}
