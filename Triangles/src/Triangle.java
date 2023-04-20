
public class Triangle {
	public double sideOne; // Should be the Biggest
	public double sideTwo;
	public double sideThree; // Should be the Smallest

	public Triangle(double One, double Two, double Three) {
		this.sideOne = One;
		this.sideTwo = Two;
		this.sideThree = Three;
		this.sortSides();
	}

	public void sortSides() {
		double temp;
		boolean change = true;
		while (change == true) {
			change = false;
			if (this.sideOne < this.sideTwo) {
				change = true;
				temp = this.sideOne;
				this.sideOne = this.sideTwo;
				this.sideTwo = temp;
			}
			if (this.sideTwo < this.sideThree) {
				change = true;
				temp = this.sideThree;
				this.sideThree = this.sideTwo;
				this.sideTwo = temp;
			}
		}
	}

	public String toString() {
		return sideOne + ":" + sideTwo + ":" + sideThree;
	}
}
