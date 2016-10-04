package pokerExceptions;

import java.io.*;

public class exHand extends Exception {
	String message;
	
	public exHand() {
		message  = "more than one best hand";
	}
}