package china.jiangkai.item;

public class PalindromicNumber
{
	public boolean isPalindrome( int x )
	{
		boolean result = false;

		int value = x;
		if ( value < 0 )
		{
			return false;
		}
		int maxSize = 10;
		int size = 0;

		for ( int i = maxSize; i >= 0; i-- )
		{
			double flag = value / Math.pow( 10, i );
			if ( flag > 1 )
			{
				size = i;
				break;
			}
		}

		int left = size;
		int right = 0;

		while ( left > right )
		{
			int factor = value % 10;
			value = (int)((value - (Math.pow( 10, (left - right) ) + 1)
					* factor) / 10);
			left--;
			right++;
		}

		if ( value >= 0 && value <= 9 )
		{
			result = true;
		}

		return result;
	}

	public void debug()
	{
		int a = 1122;
		int b = -1235321;
		int c = 234432;
		int d = 123456;
		int e = -2147447412;

		System.out.println( isPalindrome( a ) );
		System.out.println( isPalindrome( b ) );
		System.out.println( isPalindrome( c ) );
		System.out.println( isPalindrome( d ) );
		System.out.println( isPalindrome( e ) );
	}
}
