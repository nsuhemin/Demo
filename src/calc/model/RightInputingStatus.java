package calc.model;

public class RightInputingStatus implements CalculateStatus{
	private Calculator server;
	
	@Override
	public void setServer(Calculator calc) {
		server = calc;
	}

	@Override
	public void pressedNumber(String num) {
		if (server.getRightNumber().contains(".") && num.equals(".")) return;
		num = server.getRightNumber() + num;
		server.setRightNumber(num);
	}

	@Override
	public void pressedOperator(String name) {
		server.execute();
		server.setOperator(name);
		server.setRightNumber(server.getLeftNumber());
		server.switchStatus("RightInputed");
	}

	@Override
	public void pressedEqual() {
		server.execute();
		server.switchStatus("LeftInputed");
	}

	@Override
	public void pressedClear() {
		// TODO Auto-generated method stub
		
	}

}
