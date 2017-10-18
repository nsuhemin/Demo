package calc.model;

public interface CalculateStatus {
	void setServer(Calculator calc);
	void pressedNumber(String num);
	void pressedOperator(String name);
	void pressedEqual();
	void pressedClear();
}
