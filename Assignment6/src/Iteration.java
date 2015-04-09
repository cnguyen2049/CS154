public class Iteration extends Result implements RegEx {
	private RegEx base;
	public boolean matches(String s) {
		if (base.matches(s)) return true;
		for(int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			String suffix = s.substring(i);
			if (base.matches(prefix) && this.matches(suffix)) return true;
		}
		return false;
	}
}