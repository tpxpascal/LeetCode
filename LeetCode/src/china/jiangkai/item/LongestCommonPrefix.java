package china.jiangkai.item;

public class LongestCommonPrefix
{
	public String longestCommonPrefix( String[] strs )
	{
		StringBuilder result = new StringBuilder();

		if ( strs == null || strs.length == 0 || strs[ 0 ] == null
				|| strs[ 0 ].length() == 0 )
		{
			return "";
		}

		for ( int index = 0; index < strs[ 0 ].length(); index++ )
		{
			char flag = strs[ 0 ].charAt( index );
			for ( int count = 1; count < strs.length; count++ )
			{
				if ( strs[ count ] == null || strs[ count ].length() <= index )
				{
					return result.toString();
				}
				else
				{
					if ( strs[ count ].charAt( index ) != flag )
					{
						return result.toString();
					}
				}
			}
			result.append( flag );
		}

		return result.toString();
	}

	public void debug()
	{
		String[] a =
		{
				"abc", "abcdd", "abcde", "abcee",
		};
		String[] b =
		{
				"abcdefgx", "abcdd", "abcde", "abcee",
		};
		String[] c =
		{
				"abc", "abcdd", "", "abcee",
		};
		String[] d =
		{
				"abc", "abcdd", null, "abcee",
		};
		String[] e = null;
		String[] f =
		{
				"a", "x", "y", "z"
		};
		String[] g =
		{
				"ax", "ay", "az"
		};

		System.out.println( longestCommonPrefix( a ) );
		System.out.println( longestCommonPrefix( b ) );
		System.out.println( longestCommonPrefix( c ) );
		System.out.println( longestCommonPrefix( d ) );
		System.out.println( longestCommonPrefix( e ) );
		System.out.println( longestCommonPrefix( f ) );
		System.out.println( longestCommonPrefix( g ) );
	}
}
