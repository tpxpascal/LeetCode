package china.jiangkai.item;

public class MultiplyStrings
{
	public String multiply( String num1, String num2 )
	{
		StringBuilder result = new StringBuilder( "0" );

		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;

		for ( int i = index1; i >= 0; i-- )
		{
			int flag = 0;
			StringBuilder line = new StringBuilder();
			for ( int j = index2; j >= 0; j-- )
			{
				char c1 = num1.charAt( i );
				char c2 = num2.charAt( j );
				int value = ((c1 - '0') * (c2 - '0')) + flag;
				flag = value / 10;
				value = value % 10;
				line.append( value );
			}
			if ( flag > 0 )
			{
				line.append( flag );
			}
			line.reverse();
			for ( int z = i; z < index1; z++ )
			{
				line.append( "0" );
			}

			result = add( line.toString(), result.toString() );
		}

		return myTrim( result );
	}

	private StringBuilder add( String num1, String num2 )
	{
		StringBuilder result = new StringBuilder();

		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;

		String big = null;
		String small = null;
		int index = 0;

		if ( index1 > index2 )
		{
			big = num1;
			small = num2;
			index = index1;
		}
		else
		{
			big = num2;
			small = num1;
			index = index2;
		}
		int delta = big.length() - small.length();

		int flag = 0;
		for ( int i = index; i >= 0; i-- )
		{
			int indexSmall = i - delta;
			if ( indexSmall >= 0 )
			{
				int value = big.charAt( i ) - '0' + small.charAt( indexSmall )
						- '0' + flag;
				flag = value / 10;
				value = value % 10;
				result.append( value );
			}
			else
			{
				int value = big.charAt( i ) - '0' + flag;
				flag = value / 10;
				value = value % 10;
				result.append( value );
			}
		}
		if ( flag > 0 )
		{
			result.append( flag );
		}

		result.reverse();

		return result;
	}

	private String myTrim( StringBuilder num )
	{
		int i = 0;
		for ( i = 0; i < num.length(); i++ )
		{
			if ( num.charAt( i ) != '0' )
			{
				break;
			}
		}
		String result = num.substring( i, num.length() );
		if ( result.length() != 0 )
		{
			return result;
		}
		else
		{
			return "0";
		}
	}

	public void debug()
	{
		String a = "1234";
		String b = "0";

		System.out.println( multiply( a, b ) );
	}
}
