package calc.model;

public class SubOperator extends Operator{
	@Override
	public void execute(Operand left, Operand right) {
		left.sub(right);
	}
}
