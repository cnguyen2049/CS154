
import java.util.*;
import java.util.function.*;
public class Combinators {
   
   // returns p1 | p2
   public static Parser alt(Parser p1, Parser p2) {
      Parser parser = new Parser();
      parser.setParser(
         result->{
            if (result.fail)return result; 
            Choice answer = new Choice();
            answer.choice = p1.apply(result);
            if (answer.choice.fail)  {
               answer.choice = p2.apply(result);
            }
            if (answer.choice.fail) return answer.choice;
            answer.unseen = answer.choice.unseen;
            return answer;
      });
      return parser;
   }
   public static Parser opt(Parser p){
	   Parser parser = new Parser();
       parser.setParser(
           result -> {
               if (result.fail) {
                   return result;
               }

               Option answer = new Option();
               answer.kid = p.apply(result);
               answer.kid.unseen = result.unseen;              
               return answer;
		});
		return parser;
   }
   
   public static Parser rep(Parser p) {
	   Parser parser = new Parser();
       parser.setParser(
           result -> {
               if (result.fail) {
                   return result;
               }

               Iteration answer = new Iteration();
               answer.kid = p.apply(result);
               answer.kid.unseen = result.unseen;  
               if (answer.kid.fail)  {
            	   return answer.kid;
                }
              
               while(answer.pending() != 0){
            	   System.out.println(answer.kid.unseen);
            	   answer.kid = p.apply(answer.kid);
            	   if (answer.kid.fail)  {
            		   return answer.kid;
            	   }
              
            	   answer.kid.unseen = result.unseen;   
               }
               return answer;
		});
		return parser;
   }
   public static Parser seq(Parser p1, Parser p2) {
	   Parser parser = new Parser();
       parser.setParser(
           result -> {
               if (result.fail) {
                   return result;
               }

               Concatenation answer = new Concatenation();
               answer.kid0 = p1.apply(result);
               if (answer.kid0.fail)  {
                   return answer.kid0;
               }

               answer.kid0.unseen = answer.kid0.unseen;
               answer.kid1 = p2.apply(answer.kid0);
               if (answer.kid1.fail) {     	   
                   return answer.kid1;
               }
              
               answer.kid1.unseen = answer.kid1.unseen;
               
               return answer;
		});
		return parser;
   }
   public static Parser regEx(String regEx) {
	   Parser parser = new Parser();
	   parser.setParser(
       result->{
    	  Literal answer = new Literal();
    	  
    	  
    	  if (result.fail){
    		  result.fail = true;
    		  return result;
    	  }
    	
    	  if(result.pending() == 0){
    		  answer.fail = true;
    		  return answer;
    	  }
    	  String value = result.unseen.get(0);

          if(value.matches(regEx)){
        	  answer.token = value;
        	  answer.unseen =(ArrayList<String>)result.unseen.clone();
        	  answer.unseen.remove(0);
        	  //answer.unseen = (ArrayList<Object>)result.clone();
        	  
          	} 
          else{
        	  answer.unseen =(ArrayList<String>)result.unseen.clone();
        	  answer.fail = true;
        	
          }
       
          return answer;
        
     });
     return parser;
	   
 
   }
   }


