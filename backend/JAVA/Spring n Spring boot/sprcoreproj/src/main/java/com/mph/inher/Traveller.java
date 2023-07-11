package com.mph.inher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Traveller {
	private Vehicle vehicle=null;

	public Traveller() {
		super();
	}

	@Autowired
	public Traveller(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void startVehicle() {
		vehicle.start();
	}
}
