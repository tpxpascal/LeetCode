package china.jiangkai.item;

public class LongestPalindromicSubstring
{
	public String longestPalindrome( String s )
	{
		String result = "";

		int limit = s.length();
		for ( int index = 0; index < limit; index++ )
		{
			int left = 0;
			int right = 0;
			if ( (index + 1 < limit)
					&& (s.charAt( index ) == s.charAt( index + 1 )) )
			{
				left = index;
				right = index + 1;
				while ( (left >= 0) && (right < limit)
						&& (s.charAt( left ) == s.charAt( right )) )
				{
					left--;
					right++;
				}
				String text = s.substring( left + 1, right );
				if ( text.length() > result.length() )
				{
					result = text;
				}
			}
			left = index - 1;
			right = index + 1;
			while ( (left >= 0) && (right < limit)
					&& (s.charAt( left ) == s.charAt( right )) )
			{
				left--;
				right++;
			}
			String text = s.substring( left + 1, right );
			if ( text.length() > result.length() )
			{
				result = text;
			}
		}

		return result;
	}

	public void debug()
	{
		String a = "676aaabccba678695";
		String b = "ac99878abbaxx";
		String c = "ando80aabaabaa";
		String d = "ccccc";

		System.out.println( longestPalindrome( a ) );
		System.out.println( longestPalindrome( b ) );
		System.out.println( longestPalindrome( c ) );
		System.out.println( longestPalindrome( d ) );
	}
}
