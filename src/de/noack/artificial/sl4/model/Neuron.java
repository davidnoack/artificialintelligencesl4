package de.noack.artificial.sl4.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Stellt ein Neuron dar mit Grenzwert zur Aktivierung, gesamtem Input,
 * sowie Verbindungen zu anderen Neuronen
 */
public class Neuron {
	// Aktivierungsgrenzwert
	private int threshold;

	// Kumuliert einwirkendes Signal
	private int inputSignal;

	// Verbindungen zu anderen Neuronen, von welchen Signal empfangen wird
	private Map<Neuron, Integer> inputNeuronsWithWeights;

	/**
	 * Initialisierung mit Grenzwert und externem Input (falls !=0)
	 *
	 * @param threshold
	 * @param inputSignal
	 */
	public Neuron(int threshold, int inputSignal) {
		this.threshold = threshold;
		this.inputSignal = inputSignal;
		inputNeuronsWithWeights = new HashMap<>();
	}

	/**
	 * Fügt ein Neuron hinzu, von welchem Signale empfangen werden.
	 *
	 * @param n
	 * @param weight
	 */
	public void addInputNeuronWithWeight(Neuron n, int weight) {
		inputNeuronsWithWeights.put(n, weight);
	}

	/**
	 * Wird iterativ aufgerufen bis zu den Neuronen, welche keine Input-Neuronen
	 * besitzen und deshalb auf das externe Signal angewiesen sind.
	 *
	 * @return Zustand des Neurons
	 */
	public boolean isActive() {
		for (Map.Entry<Neuron, Integer> inputNeuronWithWeight : inputNeuronsWithWeights.entrySet())
			if (inputNeuronWithWeight.getKey().isActive())
				inputSignal += inputNeuronWithWeight.getKey().inputSignal * inputNeuronWithWeight.getValue();
		if(inputSignal > threshold) {
			// Fortführendes Signal wirkt mit 1 multipliziert mit dem Gewicht
			inputSignal = 1;
			return true;
		}
		return false;
	}
}