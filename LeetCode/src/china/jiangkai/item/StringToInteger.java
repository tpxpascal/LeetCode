package china.jiangkai.item;

public class StringToInteger
{
	public int myAtoi( String str )
	{
		double result = 0;

		String[] list = str.trim().split( "\\s+" );
		String text = "";
		if ( (list != null) && (list[ 0 ].length() > 0) )
		{
			text = list[ 0 ];
		}
		else
		{
			return 0;
		}
		int flag = 1;
		int head = 0;

		if ( text.charAt( 0 ) == '+' )
		{
			flag = 1;
			head = 1;
		}
		if ( text.charAt( 0 ) == '-' )
		{
			flag = -1;
			head = 1;
		}

		if ( head >= text.length() )
		{
			return 0;
		}

		for ( int i = head; i < text.length(); i++ )
		{
			int val = text.charAt( i ) - '0';
			if ( val < 0 || val > 9 )
			{
				break;
			}
			else
			{
				result = result * 10 + val;
			}
		}
		if ( flag < 0 )
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
		String a = "-";
		String b = "-545";
		String c = "10522545459";
		String d = "  32	d  5";

		System.out.println( myAtoi( a ) );
		System.out.println( myAtoi( b ) );
		System.out.println( myAtoi( c ) );
		System.out.println( myAtoi( d ) );
	}
}
