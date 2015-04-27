
public class DemoParsers {
	   public static Parser number = Combinators.regEx("[0-9]+");
	   public static Parser name= Combinators.regEx("[a-zA-Z][a-zA-Z0-9]*");
	   public static Parser boole= Combinators.regEx("(true)|(false)");
	   public static Parser operator = Combinators.regEx("\\+|\\*|\\&&|\\|\\||!");
	   public static Parser term = new Parser();
	   public static Parser product = new Parser();
	   static {
		      term.setParser(
		    	         Combinators.alt(
		    	                     number,
		    	                     Combinators.alt(name, boole)));

	   }
	   static {
		      product.setParser(
		    		  Combinators.alt(
		    				  Combinators.seq(term,
		    						  Combinators.rep(Combinators.seq(operator,term))),
		    	               term));
		      
		          
		   }
	   public static void testRegEx1(Parser p, String s) {
		   System.out.println("s = " + s);
		   Result tree =  p.apply(new Result(s));
		   System.out.println("tree = " + tree);
		   System.out.println("pending = " + tree.pending());
		}
	   
	   public static void testExpParsers() {
		   System.out.println("NUMBER ::= [1-9]+");
		   String s = "124";
		   testRegEx1(DemoParsers.number, s);
		   s = "08889";
		   testRegEx1(DemoParsers.number, s);
		   s = "323d";
		   testRegEx1(DemoParsers.number, s);
		   System.out.println();
		   System.out.println("NAME ::= [a-zA-Z][a-zA-Z0-9]*");
		   s = "Chris";
		   testRegEx1(DemoParsers.name, s);
		   s = "rias";
		   testRegEx1(DemoParsers.name, s);
		   s = "0000";
		   testRegEx1(DemoParsers.name, s);
		   System.out.println();
		   System.out.println("BOOLE ::= true | false");
		   s = "true";
		   testRegEx1(DemoParsers.boole, s);
		   s = "false";
		   testRegEx1(DemoParsers.boole, s);
		   s = "notboolean";
		   testRegEx1(DemoParsers.boole, s);
		   System.out.println();
		   System.out.println("OPERATOR ::= && | \\|\\| | \\+ | \\* | !");
		   s = "+";
		   testRegEx1(DemoParsers.operator, s);
		   s = "||";
		   testRegEx1(DemoParsers.operator, s);
		   s = "!";
		   testRegEx1(DemoParsers.operator, s);
		   s = "x";
		   testRegEx1(DemoParsers.operator, s);
		   System.out.println();
		   System.out.println("TERM ::= NAME | NUMBER | BOOLE");
		   s = "123";
		   testRegEx1(DemoParsers.term, s);
		   s = "chris";
		   testRegEx1(DemoParsers.term, s);
		   s = "false";
		   testRegEx1(DemoParsers.term, s);
		   s = "falsetrue^^";
		   testRegEx1(DemoParsers.term, s);
		   s = "8881z";
		   testRegEx1(DemoParsers.term, s);
		   System.out.println();
		   System.out.println("PRODUCT ::= TERM | TERM~(OPERATOR~TERM)+");
		   s = "11";
		   testRegEx1(DemoParsers.product, s);
		   s = "Chris && Sarah";
		   testRegEx1(DemoParsers.product, s);
		   s = "100 + 500";
		   testRegEx1(DemoParsers.product, s);
		   s = "11 ++ 20";
		   testRegEx1(DemoParsers.product, s);
		   s = "Chris & rob";
		   testRegEx1(DemoParsers.product, s);
		   s = "+ 1 2";
		   testRegEx1(DemoParsers.product, s);
		   
		}
	   public static void main(String args []){
		   testExpParsers();
	   }
}
