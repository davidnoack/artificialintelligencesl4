package de.noack.artificial.sl4.model;

import java.util.HashSet;
import java.util.Set;

public class Axon {
	private Set<Synapse> synapses;
	public double distance;

	public Axon() {
		synapses = new HashSet <>();
	}

	public void addSynapticConnection(Neuron contactedNeuron) {
		synapses.add(new Synapse(this, contactedNeuron));
	}

	public void sendSignal(double signal) {
		for(Synapse synapse : synapses) {
			synapse.affectNeuron(signal);
		}
	}
}
