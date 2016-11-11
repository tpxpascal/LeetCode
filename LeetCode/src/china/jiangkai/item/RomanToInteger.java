package china.jiangkai.item;

import java.util.*;

public class RomanToInteger
{
	public int romanToInt( String s )
	{
		int result = 0;

		HashMap< Character, Integer > base = new HashMap< Character, Integer >();

		base.put( 'I', 1 );
		base.put( 'V', 5 );
		base.put( 'X', 10 );
		base.put( 'L', 50 );
		base.put( 'C', 100 );
		base.put( 'D', 500 );
		base.put( 'M', 1000 );

		int curr = base.get( s.charAt( 0 ) );
		int next = 0;
		for ( int i = 1; i < s.length(); i++ )
		{
			next = base.get( s.charAt( i ) );
			if ( curr < next )
			{
				curr = -curr;
			}
			result = result + curr;
			curr = next;
			next = 0;
		}
		result = result + curr;

		return result;
	}

	public void debug()
	{
		String a = "X";
		String b = "V";
		String c = "IX";
		String d = "XI";
		String e = "MMMCMXCIX";
		String f = "DCXXI";
		String x = "DCCXXXVIII";

		System.out.println( romanToInt( a ) );
		System.out.println( romanToInt( b ) );
		System.out.println( romanToInt( c ) );
		System.out.println( romanToInt( d ) );
		System.out.println( romanToInt( e ) );
		System.out.println( romanToInt( f ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( romanToInt( x ) );
		System.out.println( System.currentTimeMillis() );
	}
}
