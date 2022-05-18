import java.util.Stack;

/**
 *
 * @author Marcel Turcotte, Universit d'Ottawa/University of Ottawa
 */

public class Balanced {

    public static boolean algo1( String s ) {

        int curly = 0;
        int square = 0;
        int round = 0;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
            case '{':
                curly++;
                break;
            case '}':
                curly--;
                break;
            case '[':
                square++;
                break;
            case ']':
                square--;
                break;
            case '(':
                round++;
                break;
            case ')':
                round--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }
    
    public static boolean algo2( String s ) {
    	Stack<Character> games = new Stack();
    	boolean flag = true;
    	for(int i = 0; i<s.length(); i++) {
    		if(s.charAt(i) == '(' || s.charAt(i) == ')'|| s.charAt(i) == '{'|| s.charAt(i) == '}' ||s.charAt(i) == '[' ||s.charAt(i) == ']')
    		games.push(s.charAt(i));
    	}
    	for(int i = 0; i<s.length(); i++) {
    		char c = 0;
    		if(s.charAt(i) == '(' || s.charAt(i) == ')'|| s.charAt(i) == '{'|| s.charAt(i) == '}' ||s.charAt(i) == '[' ||s.charAt(i) == ']') {
    			 c = s.charAt(i);
    		}
    		switch (c) {
            case '{':
                if(games.pop() != '}')
                	flag = false;
                break;
            case '[':
            	if(games.pop() != ']')
                	flag = false;
                break;
            case '(':
            	if(games.pop() != ')')
                	flag = false;
                break;
            
            }
    	}
    	return (flag && games.isEmpty());
    }

    public static void main( String[] args ) {
    	String s = "({}})";
    	String a = " (4 + [2 - 1)]";
    	System.out.println(algo2(s));
    	
      /*  for ( int i=0; i<args.length; i++ ) { System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) ); } */
    	
    }
}