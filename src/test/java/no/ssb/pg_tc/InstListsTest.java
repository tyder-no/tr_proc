package no.ssb.pg_tc;

import org.junit.Test;

//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.* ;

import java.io.*;

import java.util.regex.*;  
//import java.util.Scanner; 
import java.util.HashMap ;
import java.util.ArrayList ;








/**
 * Unit test for simple App.
 */
public class InstListsTest 
{
	InstLists iL = new InstLists() ;

	@Test
	public void testInstLists() {
		int junk ;
		InstLists instLists = new InstLists() ;
		junk = instLists.insertEntry("RUTER AS","03.06 - 46") ;
		assertEquals(junk,1) ;
		junk = instLists.insertEntry("RUTER AS","05.06 - 46") ;
		assertEquals(junk,0) ;
		junk = instLists.insertEntry("RUTER AS","07.06 - 750") 
				;
		junk = instLists.insertEntry("RUTER AS","07.06 - 36") ;
		junk = instLists.insertEntry("RUTER AS","10.06 - 46") ;
		junk = instLists.insertEntry("BILTEMA CHARLOTTENBERG","05.06 - 2370") ;
		assertEquals(junk,1) ;	

		ArrayList<String> retrieved = instLists.retrieveList("RUTER AS") ;

		System.out.println(" Retrieved #0: " + retrieved.get(0));
		System.out.println(" Retrieved all: " +retrieved.size() ) ;
		for (int i=0 ; i<retrieved.size(); i++) {
			System.out.println(" Retrieved #"+i+": " + retrieved.get(i));			
		}
		assertEquals(retrieved.size(),5) ;
		
		ArrayList<String> retrieved2 = instLists.retrieveList("BILTEMA CHARLOTTENBERG") ;

		System.out.println(" Retrieved #0: " + retrieved2.get(0));
		System.out.println(" Retrieved all: " +retrieved2.size() ) ;
		for (int i=0 ; i<retrieved2.size(); i++) {
			System.out.println(" Retrieved #"+i+": " + retrieved2.get(i));			
		}
		assertEquals(retrieved2.size(),1) ;
		
		
	}


	@Test
	public void shouldAnswerWithTrue()
	{
		assertTrue( true );
	}

	@Test
	public void shouldAnswerWithFalse()
	{
		assertFalse( false );
	}


}
