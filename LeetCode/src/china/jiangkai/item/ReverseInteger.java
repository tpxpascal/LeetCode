package china.jiangkai.item;

import java.util.*;

public class ReverseInteger
{
	public int reverse( int x )
	{
		long result = 0;

		LinkedList< Integer > list = new LinkedList< Integer >();

		int value = Math.abs( x );

		while ( value > 0 )
		{
			list.add( value % 10 );
			value = value / 10;
		}

		for ( Integer i : list )
		{

			result = result * 10 + i;
		}

		if ( x < 0 )
		{
			result = -result;
		}

		if ( (result < Integer.MIN_VALUE) || (result > Integer.MAX_VALUE) )
		{
			result = 0;
		}

		return (int)result;
	}

	public void debug()
	{
		int a = 1534236469;
		int b = -123;
		int c = 100;
		int d = 0;

		System.out.println( reverse( a ) );
		System.out.println( reverse( b ) );
		System.out.println( reverse( c ) );
		System.out.println( reverse( d ) );
	}
}
