public class Choice extends Result {
	private Result kid0;
	public Result choice;
	
	public void setChoice(Result result){
		this.kid0 = result;
	}
	public Result getChoice(){
		return kid0;
	}
	
	public String toString(){
		return "" + kid0;
	}
}