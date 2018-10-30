package de.noack.artificial.sl4.logic;

import de.noack.artificial.sl4.model.Neuron;

public abstract class Controller {

	public static boolean xor(int a, int b) {
		Neuron inputA = new Neuron(0, a);
		Neuron inputB = new Neuron(0, b);
		
		Neuron hiddenC = new Neuron(3, 0);
		hiddenC.addInputNeuronWithWeight(inputA, -2);
		hiddenC.addInputNeuronWithWeight(inputB, -2);
		Neuron hiddenD = new Neuron(-1, 0);
		
		hiddenD.addInputNeuronWithWeight(inputA, 2);
		hiddenD.addInputNeuronWithWeight(inputB, 2);
		
		Neuron output = new Neuron(-3, 0);
		output.addInputNeuronWithWeight(hiddenC, 2);
		output.addInputNeuronWithWeight(hiddenD, 2);
		
		return(output.isActive());
	}
}
