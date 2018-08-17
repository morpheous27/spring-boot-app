package org.nitin.restapp.service;

public class Utility {
	
	/**
	 * method to introduce slowness
	 */
	public static void simulateSlowService() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
