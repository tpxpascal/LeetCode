package china.jiangkai.item;

public class PalindromicNumber
{
	public boolean isPalindrome( int x )
	{
		boolean result = true;

		if ( x < 0 )
		{
			return false;
		}

		int highBase = 1000000000; // To improve performance, use magic number.
		int lowBase = 1;
		double flag = 1.0 * x / highBase;

		while ( (flag < 1) && (flag > 0) )
		{
			flag = flag * 10;
			highBase = highBase / 10;
		}

		while ( highBase > lowBase )
		{
			int highNum = x / highBase % 10;
			int lowNum = x / lowBase % 10;

			if ( highNum != lowNum )
			{
				return false;
			}

			highBase = highBase / 10;
			lowBase = lowBase * 10;
		}

		return result;
	}

	public void debug()
	{
		int a = 1910110191;
		int b = 1122;
		int c = 0;
		int d = 12321;
		int e = 2442;

		System.out.println( isPalindrome( a ) );
		System.out.println( isPalindrome( b ) );
		System.out.println( isPalindrome( c ) );
		System.out.println( isPalindrome( d ) );
		System.out.println( isPalindrome( e ) );
	}
}
