package calc.model;

public class DoubleOperand implements Operand{
	private String value = "0";
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void add(Operand oper) {
		double x = Double.parseDouble(value);
		double y = Double.parseDouble(oper.getValue());
		double result = x + y;
		value = String.valueOf(result);
	}

	@Override
	public void sub(Operand oper) {
		double x = Double.parseDouble(value);
		double y = Double.parseDouble(oper.getValue());
		double result = x - y;
		value = String.valueOf(result);
	}

	@Override
	public void mul(Operand oper) {
		double x = Double.parseDouble(value);
		double y = Double.parseDouble(oper.getValue());
		double result = x * y;
		value = String.valueOf(result);
	}

	@Override
	public void div(Operand oper) {
		double x = Double.parseDouble(value);
		double y = Double.parseDouble(oper.getValue());
		double result = x / y;
		value = String.valueOf(result);
	}

}
