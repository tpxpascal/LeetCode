package china.jiangkai.item;

public class Power
{
	public double myPow( double x, int n )
	{
		if ( n == 0 )
		{
			return 1;
		}
		else
		{
			if ( n > 0 )
			{
				return xpow( x, n );
			}
			else
			{
				if ( n != Integer.MIN_VALUE )
				{
					return xpow( 1 / x, -n );
				}
				else
				{
					return xpow( 1 / x, -1 - n ) / x;
				}
			}
		}
	}

	private double xpow( double x, int n )
	{
		double result = 1;
		int split = 30000;
		if ( n <= split )
		{
			for ( int i = 0; i < n; i++ )
			{
				result = result * x;
			}
		}
		else
		{
			int k = n / split;
			int left = n % split;

			double big = xpow( x, split );
			for ( int i = 0; i < k; i++ )
			{
				result = result * big;
			}
			for ( int i = 0; i < left; i++ )
			{
				result = result * x;
			}
		}
		return result;
	}

	public void debug()
	{
		double a = 2;
		double b = 3;
		double c = 3;
		double d = 3;
		double e = 1;

		System.out.println( myPow( a, 0 ) );
		System.out.println( myPow( b, 1 ) );
		System.out.println( myPow( c, 2 ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( myPow( d, -2 ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( myPow( e, -2147483648 ) );
		for ( int i = 0; i < 100; i++ )
		{
			myPow( e, -2147483648 );
		}
		System.out.println( System.currentTimeMillis() );
	}
}
