package calc.model;

public class StatusFactory {
	private static CalculateStatus[] cs;
	
	static{
		cs = new CalculateStatus[4];
		int i = 0;
		cs[i++] = new LeftInputingStatus();
		cs[i++] = new LeftInputedStatus();
		cs[i++] = new RightInputingStatus();
		cs[i++] = new RightInputedStatus();
	}
	
	public static CalculateStatus create(StatusType t){
		return cs[t.ordinal()];
	}
}
