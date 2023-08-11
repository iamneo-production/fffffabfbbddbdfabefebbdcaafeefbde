package controller;

public class CalculateBMI {
 

	public static double calculate(double height, double weight) {

		double bmi = weight / ((height / 100) * (height / 100));

		return Math.round(bmi * 100.0) / 100.0;

	}

   

	public static String description(double B) {

		if (B < 18.5) {

			return "Under Weight";

		} else if (B >= 18.5 && B< 24.9) {

			return "Normal";

		} else if (B >= 25 && B < 29.9) {

			return "Over Weight";

		} else if (B >= 30 && B < 34.9) {

			return "Obese";

		} else {

			return "Extremely Obese";

		}

	}  

	//Enter the code here....
}
