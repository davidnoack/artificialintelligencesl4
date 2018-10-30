package de.noack.artificial.sl4.model;

import java.util.HashMap;
import java.util.Map;

public class Neuron {
	private int threshold;
	private int inputSignal;
	private Map<Neuron, Integer> inputNeuronsWithWeights;

	public Neuron(int threshold, int inputSignal) {
		this.threshold = threshold;
		this.inputSignal = inputSignal;
		inputNeuronsWithWeights = new HashMap<>();
	}

	public void addInputNeuronWithWeight(Neuron n, int weight) {
		inputNeuronsWithWeights.put(n, weight);
	}

	public boolean isActive() {
		for (Map.Entry<Neuron, Integer> inputNeuronWithWeight : inputNeuronsWithWeights.entrySet()) {
			if (inputNeuronWithWeight.getKey().isActive()) {
				inputSignal += inputNeuronWithWeight.getKey().inputSignal * inputNeuronWithWeight.getValue();
			}
		}
		if(inputSignal + threshold > 0) {
			inputSignal = 1;
			return true;
		}
		return false;
	}
}