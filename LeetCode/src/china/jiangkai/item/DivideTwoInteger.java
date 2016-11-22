package china.jiangkai.item;

public class DivideTwoInteger
{
	public int divide( int dividend, int divisor )
	{
		if ( divisor == 0 )
		{
			return Integer.MAX_VALUE;
		}

		long result = 0;

		long left = Math.abs( (long)dividend );
		long delta = Math.abs( (long)divisor );

		while ( left >= delta )
		{
			left = left - delta;
			result++;
		}

		if ( dividend * divisor < 0 )
		{
			result = -result;
		}

		if ( result > Integer.MAX_VALUE )
		{
			result = Integer.MAX_VALUE;
		}
		if ( result < Integer.MIN_VALUE )
		{
			result = Integer.MIN_VALUE;
		}

		return (int)result;
	}

	public void debug()
	{
		int a = -100;
		int b = 3;
		int c = 5;
		int d = 0;
		int e = -2147483648;
		int f = 1;

		System.out.println( divide( a, b ) );
		System.out.println( divide( c, d ) );
		System.out.println( divide( e, f ) );
	}
}
