package calc.model;

public class DivOperator extends Operator{
	@Override
	public void execute(Operand left, Operand right) {
		left.div(right);
	}
}
