package de.noack.artificial.sl4.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Soma {

	private Neuron parentNeuron;
	private Set<Dendrit> dendrits;
	private double sumOfWeights;
	private double threshold;

	public Soma(Neuron parentNeuron, double threshold) {
		this.parentNeuron = parentNeuron;
		this.dendrits = new HashSet <>();
		Dendrit dendrit = new Dendrit(this);
		dendrits.add(dendrit);
		this.sumOfWeights = 0;
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

	public Dendrit getRandomDendrit() {
		return (Dendrit) dendrits.toArray()[new Random().nextInt(dendrits.size())];
	}

	public double getSumOfWeights() {
		return sumOfWeights;
	}
}
