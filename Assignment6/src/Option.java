public class Option extends Result implements RegEx {
	private RegEx base;
	public boolean matches(String s) { return s.isEmpty() || base.matches(s); }
}
