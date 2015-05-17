package prob3;

public class RecEnum {
	private int value1;
	private int value2;
	
	public void setValue1(int val){
		this.value1 = val;
	}
	
	public void setValue2(int val2){
		this.value2 = val2;
	}
	
	public String getValue(){
		return "(" + value1 + "," + value2 + ")";
	}
	

}
