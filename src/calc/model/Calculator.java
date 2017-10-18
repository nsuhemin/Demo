package calc.model;

public class Calculator {
	private Operand left;
	private Operand right;
	private Operator op;
	private CalculateStatus status;
	private DispListener listener;
	
	public void addDispListener(DispListener listener){
		this.listener = listener;
	}
	
	public Calculator(){
		left = new DoubleOperand();
		right = new DoubleOperand();
		status = StatusFactory.create(StatusType.LeftInputed);
		status.setServer(this);
	}
	
	public void clear(){
		left = new DoubleOperand();
		right = new DoubleOperand();
		status = StatusFactory.create(StatusType.LeftInputed);
		status.setServer(this);
		if (listener != null) listener.show("0");
	}
	
	public void execute(){
		if (op != null)
			op.execute(left, right);
		if (listener != null) listener.show(left.getValue());
	}
	
	public void pressedOperator(String name){
		status.pressedOperator(name);
	}
	
	public void pressedNumber(String num){
		status.pressedNumber(num);
	}
	
	public void pressedEqual(){
		status.pressedEqual();
	}
	
	public void switchStatus(String name){
		StatusType t = StatusType.valueOf(name);
		this.status = StatusFactory.create(t);
		this.status.setServer(this);
	}
	
	public String getLeftNumber(){
		return left.getValue();
	}
	
	public void setLeftNumber(String num){
		left.setValue(num);
		if (listener != null) listener.show(num);
	}
	
	public String getRightNumber(){
		return right.getValue();
	}
	
	public void setRightNumber(String num){
		right.setValue(num);
		if (listener != null) listener.show(num);
	}
	
	public void setOperator(String name){
		OperatorType t = OperatorType.valueOf(name);
		op = OperatorFactory.create(t);
	}
}
