package china.jiangkai.item;

public class AddBinary
{
	public String addBinary( String a, String b )
	{
		StringBuilder result = new StringBuilder();

		int BASE = 2;

		int aSize = a.length();
		int bSize = b.length();

		int max = aSize;
		int min = bSize;

		String maxString = a;
		String minString = b;

		if ( max < min )
		{
			max = bSize;
			min = aSize;
			maxString = b;
			minString = a;
		}

		int flag = 0;
		for ( int i = 1; i <= max; i++ )
		{
			int num1 = 0;
			int num2 = 0;

			num1 = maxString.charAt( max - i ) - '0';
			if ( i <= min )
			{
				num2 = minString.charAt( min - i ) - '0';
			}

			int sum = num1 + num2 + flag;
			int curr = sum % BASE;
			flag = sum / BASE;
			result.append( curr );
		}
		if ( flag != 0 )
		{
			result.append( flag );
		}
		result = result.reverse();

		return result.toString();
	}

	public void debug()
	{
		String a = "11";
		String b = "1";
		String c = "100";
		String d = "101";

		System.out.println( addBinary( a, b ) );
		System.out.println( addBinary( b, c ) );
		System.out.println( addBinary( c, d ) );
	}
}
