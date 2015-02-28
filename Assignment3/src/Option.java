
public class Option implements RegEx{
	RegEx base;
	
	public Option(RegEx base){
		this.base = base;
	}
	@Override
	public boolean matches(String s) {

		return s.isEmpty() || base.matches(s);
	}


}
