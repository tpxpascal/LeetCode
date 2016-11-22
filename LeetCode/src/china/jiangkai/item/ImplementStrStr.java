package china.jiangkai.item;

public class ImplementStrStr
{
	public int strStr( String haystack, String needle )
	{
		int result = 0;

		if ( needle == null )
		{
			return 0;
		}
		if ( haystack == null )
		{
			return -1;
		}
		if ( (haystack.length() == 0) && (needle.length() == 0) )
		{
			return 0;
		}
		if ( haystack.length() < needle.length() )
		{
			return -1;
		}

		int index = 0;
		int limit = haystack.length() - needle.length();
		int size = needle.length();
		for ( result = 0; result <= limit; result++ )
		{
			for ( index = 0; index < size; index++ )
			{
				if ( haystack.charAt( result + index ) != needle.charAt( index ) )
				{
					break;
				}
			}
			if ( index == size )
			{
				return result;
			}
		}
		if ( result == limit + 1 )
		{
			result = -1;
		}

		return result;
	}

	public void debug()
	{
		String a = "abcd";
		String b = "x";
		String c = "abcadefg";
		String d = "ad";
		String e = "aaabbbaaabbbb";
		String f = "abbba";

		System.out.println( strStr( a, b ) );
		System.out.println( strStr( c, d ) );
		System.out.println( strStr( e, f ) );

		System.out.println( a.indexOf( b ) );
		System.out.println( c.indexOf( d ) );
		System.out.println( e.indexOf( f ) );
	}
}
