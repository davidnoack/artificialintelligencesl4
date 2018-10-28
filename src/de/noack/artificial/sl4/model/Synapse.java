package de.noack.artificial.sl4.model;

public class Synapse {

	private Axon parentAxon;
	private Neuron contactedNeuron;

	public Synapse(Axon parentAxon, Neuron contactedNeuron) {
		this.parentAxon = parentAxon;
		this.contactedNeuron = contactedNeuron;
	}

	public void affectNeuron(double signal) {
		contactedNeuron.getSoma().getRandomDendrit().receiveInputSignal(signal);
	}
}
