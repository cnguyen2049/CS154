
public class Literal implements RegEx {
	private String token;
	public boolean matches(String s) { return token.equals(s); }
}