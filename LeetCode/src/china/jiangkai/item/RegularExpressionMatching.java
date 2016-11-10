package china.jiangkai.item;

public class RegularExpressionMatching
{
	public boolean isMatch( String s, String p )
	{
		boolean result = false;

		return result;
	}

	public void debug()
	{
		System.out.println( isMatch( "aa", "a" ) );
		System.out.println( isMatch( "aa", "aa" ) );
		System.out.println( isMatch( "aaa", "aa" ) );
		System.out.println( isMatch( "aa", "a*" ) );
		System.out.println( isMatch( "aa", ".*" ) );
		System.out.println( isMatch( "ab", ".*" ) );
		System.out.println( isMatch( "aab", "c*a*b" ) );
	}
}
