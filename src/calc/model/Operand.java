package calc.model;

public interface Operand {
	String getValue();
	void setValue(String value);
	void add(Operand oper);
	void sub(Operand oper);
	void mul(Operand oper);
	void div(Operand oper);
}
