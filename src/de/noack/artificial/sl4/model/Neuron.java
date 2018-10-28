package de.noack.artificial.sl4.model;

/**
 * Die Klasse Neuron stellt eine Nervenzelle dar.
 */
public class Neuron {

	private State state;
	private Soma childSoma;
	private Axon axon;
	private double effectivity;
	private int layer;

	public Neuron(State state, Soma childSoma, Axon axon, int layer) {
		this.state = state;
		this.childSoma = childSoma;
		this.axon = axon;
		this.layer = layer;
	}

	public void sendSignalIfThresholdExceeded() {
		if(childSoma.sumOfWeightsExceedsThreshold()) axon.sendSignal();
	}

	public State getState() {
		return state;
	}

	public Soma getChildSoma() {
		return childSoma;
	}

	public Axon getAxon() {
		return axon;
	}
}
