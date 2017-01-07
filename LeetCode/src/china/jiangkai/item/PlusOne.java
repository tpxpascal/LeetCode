package china.jiangkai.item;

public class PlusOne
{
	public int[] plusOne( int[] digits )
	{
		int flag = 1;
		for ( int i = digits.length - 1; i >= 0; i-- )
		{
			int value = flag + digits[ i ];
			digits[ i ] = value % 10;
			flag = value / 10;
		}

		if ( flag != 0 )
		{
			int[] result = new int[ digits.length + 1 ];
			result[ 0 ] = flag;
			for ( int i = 1; i < result.length; i++ )
			{
				result[ i ] = digits[ i - 1 ];
			}
			return result;
		}

		return digits;
	}

	public void debug()
	{
		int[] a =
		{
			1
		};
		int[] b =
		{
			9
		};
		int[] c =
		{
				1, 2, 3
		};
		int[] d =
		{
				1, 9, 9
		};
		int[] e =
		{
				9, 9, 9
		};

		printArray( plusOne( a ) );
		printArray( plusOne( b ) );
		printArray( plusOne( c ) );
		printArray( plusOne( d ) );
		printArray( plusOne( e ) );
	}

	private void printArray( int[] list )
	{
		System.out.println( "Result:" );
		for ( int i : list )
		{
			System.out.print( i + " " );
		}
		System.out.println();
	}
}
