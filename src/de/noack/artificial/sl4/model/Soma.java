package de.noack.artificial.sl4.model;

import java.util.Set;

public class Soma {

	private Neuron parentNeuron;
	private Set<Dendrit> dendrits;
	private double sumOfWeights;
	private double threshold;

	public Soma(Neuron parentNeuron, Set <Dendrit> dendrits, double sumOfWeights, double threshold) {
		this.parentNeuron = parentNeuron;
		this.dendrits = dendrits;
		this.sumOfWeights = sumOfWeights;
		this.threshold = threshold;
	}

	public void sumWeights() {
		for(Dendrit dendrit : dendrits) {
			sumOfWeights = dendrit.getSumOfSignals();
		}
	}

	public boolean sumOfWeightsExceedsThreshold() {
		return sumOfWeights > threshold;
	}

	public Neuron getParentNeuron() {
		return parentNeuron;
	}

	public Set <Dendrit> getDendrits() {
		return dendrits;
	}

	public double getSumOfWeights() {
		return sumOfWeights;
	}

	public double getThreshold() {
		return threshold;
	}
}
