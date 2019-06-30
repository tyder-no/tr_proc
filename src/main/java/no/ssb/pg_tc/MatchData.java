package no.ssb.pg_tc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MatchData 
{
	boolean matched = false ;
	int currAlt ;
	Pattern pat ;
	Matcher m ;
	String[] decomp ;
	static String[] patArr ;


	MatchData(String patStr, String trTxt,int cAlt){
		pat = Pattern.compile(patStr) ;
		m = pat.matcher(trTxt)  ;
		matched = m.matches();
		currAlt  = cAlt ;
		patArr = initPatArr() ;
	}

	public static String[] initPatArr() {
		String[] iPA =	{"(.+)","(Avtalegiro til )(.*)( Betalingsdato .+)","(Varekjøp )(.*)( betal dato .*)","(VISA VARE [0-9X]+ \\d\\d\\.\\d\\d )(.*)",
				"(Overføring - )(.*)","(Overført til lån )(.*)( forfall .*)","(Overførsel strukturert fakturainformasjon - )(.*)",
				"(Lønn - )(.*)","(Overførsel - Melding )(.*)","(Gebyr .*)","(Minibankuttak )(.*)","(Kontaktløs )(.*)",
				"(Giroinnbetaling )(.*)","(VIPPS fra )(.*)","(VIPPS )(.*)","(Butikk-terminal varekjøp )(.*)","(\\d{4}\\.\\d\\d\\.\\d{5}, )(.*)"} ;
		return iPA ;
	}

	public static MatchData trMatcher(String trTxt) {
		MatchData patM ; 
		boolean matched=false ;
		//String[] patArr = initPatArr() ;
		int currAlt = patArr.length - 1 ;
		patArr[0] = "(.+)" ; // Catch all non-empty strings


		do {
			patM = new MatchData(patArr[currAlt],trTxt,currAlt) ;
			matched = patM.getMatched();
			currAlt-- ;
		} while (!matched) ;

		return patM ;
	}




	public boolean getMatched() { return matched ; }
	public int getCurrAlt() { return currAlt ;	}
	public String getFirstM() { return m.group(1) ; }
	// String getSecM() { if (getCurrAlt()>0) return m.group(2) ; else return "No match" ; }
	public String getSecM() { return (getCurrAlt()>0) ? m.group(2) : "No match" ; }









	public void runApp() {

		System.out.println( "...In dynamically allocated App.runApp..." );
		
	}

	public static void main( String[] args )
	{   
		String trTxt = "Avtalegiro til CIRCLE K NORGE AS Betalingsdato 28-06-2019"   ; 
		String[] patArr = initPatArr() ;
		int currAlt = patArr.length - 1 ;
		MatchData mD = new MatchData(patArr[currAlt],trTxt,currAlt) ;
		mD.runApp();

		System.out.println( "From static main: Hello, Brave New World!" );
	}
}

