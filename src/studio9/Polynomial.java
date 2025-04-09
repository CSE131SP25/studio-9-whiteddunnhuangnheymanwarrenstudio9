package studio9;

import java.util.LinkedList;

public class Polynomial {

	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		this.list = new LinkedList<>();
	}

	/**
	 * Adds a term to the polynomial. Terms are added from highest to lowest degree,
	 * so this assumes you're adding terms in order (e.g., from x^n to x^0).
	 * 
	 * @param coeff The coefficient of the term to add.
	 */
	public void addTerm(double coeff) {
		list.add(coeff);
	}

	/**
	 * Returns a String of the polynomial in the proper form:
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		if (list.isEmpty()) {
			return "0";
		}
		StringBuilder result = new StringBuilder();
		int degree = list.size() - 1;

		for (int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);
			if (coeff == 0) {
				degree--;
				continue;
			}

			if (result.length() > 0) {
				result.append(" + ");
			}

			if (degree == 0) {
				result.append(coeff);
			} else if (degree == 1) {
				result.append(coeff + "x");
			} else {
				result.append(coeff + "x^" + degree);
			}
			degree--;
		}

		return result.toString();
	}

	/**
	 * Evaluates the polynomial for a given x value.
	 * 
	 * @param x The x value to evaluate the polynomial at.
	 * @return The result as a double.
	 */
	public double evaluate(double x) {
		double result = 0;
		int degree = list.size() - 1;

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) * Math.pow(x, degree);
			degree--;
		}

		return result;
	}

	/**
	 * Returns the derivative of the polynomial using the power rule.
	 * 
	 * @return A new Polynomial representing the derivative.
	 */
	public Polynomial derivative() {
		Polynomial derivative = new Polynomial();
		int degree = list.size() - 1;

		for (int i = 0; i < list.size() - 1; i++) {
			double coeff = list.get(i);
			derivative.addTerm(coeff * degree);
			degree--;
		}

		return derivative;
	}
}
