package calc.model;

public class LeftInputedStatus implements CalculateStatus{
	private Calculator server;
	
	@Override
	public void setServer(Calculator calc) {
		server = calc;
	}

	@Override
	public void pressedNumber(String num) {
		if (num.equals("."))
			server.setLeftNumber("0.");
		else
			server.setLeftNumber(num);
		server.switchStatus("LeftInputing");
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
		server.setRightNumber(server.getLeftNumber());
		server.switchStatus("RightInputed");
	}

	@Override
	public void pressedEqual() {
		server.execute();
	}

	@Override
	public void pressedClear() {
		// TODO Auto-generated method stub
		
	}

}
