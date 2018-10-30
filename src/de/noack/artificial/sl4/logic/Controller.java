package de.noack.artificial.sl4.logic;

import de.noack.artificial.sl4.model.Neuron;

/**
 * Kapselt die Logik
 */
public abstract class Controller {

	/**
	 * Es werden zwei ganzzahlige Werte übergeben, welche
	 * den Wert 0 (false) oder 1 (true) besitzen können.
	 * Nur einer dieser Werte darf beim XOR true sein, damit
	 * die Methode true zurückliefert.
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean xor(int a, int b) {
		// Input-Neuronen
		Neuron inputA = new Neuron(0, a);
		Neuron inputB = new Neuron(0, b);

		// Verdeckte Schicht welche die Input-Neuronen als Input erhält
		Neuron hiddenC = new Neuron(-3, 0);
		hiddenC.addInputNeuronWithWeight(inputA, -2);
		hiddenC.addInputNeuronWithWeight(inputB, -2);
		Neuron hiddenD = new Neuron(1, 0);
		hiddenD.addInputNeuronWithWeight(inputA, 2);
		hiddenD.addInputNeuronWithWeight(inputB, 2);

		// Das Output-Neuron
		Neuron output = new Neuron(3, 0);
		output.addInputNeuronWithWeight(hiddenC, 2);
		output.addInputNeuronWithWeight(hiddenD, 2);

		// Rekursiver Signalempfang
		return(output.isActive());
	}
}