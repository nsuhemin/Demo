package calc.model;

public class LeftInputingStatus implements CalculateStatus{
	private Calculator server;
	
	@Override
	public void setServer(Calculator calc) {
		server = calc;
	}

	@Override
	public void pressedNumber(String num) {
		if (server.getLeftNumber().contains(".") && num.equals(".")) return;
		num = server.getLeftNumber() + num;
		server.setLeftNumber(num);
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
		server.setRightNumber(server.getLeftNumber());
		server.switchStatus("RightInputed");
	}

	@Override
	public void pressedEqual() {
		server.switchStatus("LeftInputed");
	}

	@Override
	public void pressedClear() {
		// TODO Auto-generated method stub
		
	}

}
