package calc.model;

public class RightInputedStatus implements CalculateStatus{
	private Calculator server;
	
	@Override
	public void setServer(Calculator calc) {
		server = calc;
	}

	@Override
	public void pressedNumber(String num) {
		server.setRightNumber(num);
		server.switchStatus("RightInputing");
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
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
