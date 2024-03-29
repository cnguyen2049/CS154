
public class Iteration implements RegEx{
	RegEx base;
	public Iteration(RegEx base){
		this.base = base;
	}
	
	public int length(String s){
		for(int i=0;i<s.length();i++){
			if(base.matches(s.substring(0,1))){
				//System.out.println(i);
				return 1;
			}
			if(base.matches(s.substring(0,i))){
				//System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	@Override
	public boolean matches(String s) {
		int len = length(s);
		if (len  == -1){
			return false;
		}
		int jump = len;
		int i =0;
		boolean flag;
		while(i<s.length()){
			if(jump>s.length()){
				if(i!=s.length()-1){
					return false;
				}
				break;
			}
			String holder = s.substring(i,jump);
			//System.out.println(holder);
			if(!base.matches(holder)){
				flag = false;
				return flag;
			}
			i = jump;
			jump += len;
		}
		return true;
	}
	public String toString(){
		return "" + base.toString();
	}


}
