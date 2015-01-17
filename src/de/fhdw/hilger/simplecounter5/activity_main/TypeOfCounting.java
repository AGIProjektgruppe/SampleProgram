package de.fhdw.hilger.simplecounter5.activity_main;

public enum TypeOfCounting {

	INCREMENT(true), DECREMENT(false);

	private boolean value;

	private TypeOfCounting(boolean b) {
		value = b;
	}

	public boolean toBoolean() {
		return value;
	}
	
	public static TypeOfCounting toTypeOfCounting(boolean b) {
		return b ? INCREMENT : DECREMENT;
	}
	
}
