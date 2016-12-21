package china.jiangkai.item;

public class LengthOfLastWord
{
	public int lengthOfLastWord( String s )
	{
		int result = 0;
		if ( s == null )
		{
			return 0;
		}

		String[] list = s.split( " " );
		if ( list.length > 0 )
		{
			result = list[ list.length - 1 ].length();
		}

		return result;
	}

	public void debug()
	{
		String a = null;
		String b = "";
		String c = "Hello World";

		System.out.println( lengthOfLastWord( a ) );
		System.out.println( lengthOfLastWord( b ) );
		System.out.println( lengthOfLastWord( c ) );
	}
}
