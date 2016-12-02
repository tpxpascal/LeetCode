package china.jiangkai.item;

import java.util.*;

public class LongestValidParenthese
{
	public int longestValidParentheses( String s )
	{
		int result = 0;

		if ( (s == null) || (s.length() == 0) )
		{
			return result;
		}

		for ( int i = 0; i < s.length(); )
		{
			if ( s.charAt( i ) == '(' )
			{
				int temp = validString( s.substring( i ) );
				if ( temp > result )
				{
					result = temp;
				}
				i = i + temp;
			}
			i++;
		}

		return result;
	}

	private int validString( String s )
	{
		int result = 0;
		int temp = 0;

		Stack< Character > data = new Stack< Character >();

		if ( s.charAt( 0 ) != '(' )
		{
			return result;
		}

		for ( int i = 0; i < s.length(); i++ )
		{
			char curr = s.charAt( i );
			if ( curr == '(' )
			{
				data.push( curr );
			}
			if ( curr == ')' )
			{
				if ( data.empty() || data.peek() != '(' )
				{
					return result;
				}
				else
				{
					data.pop();
					temp = temp + 2;
					if ( data.empty() )
					{
						result = result + temp;
						temp = 0;
					}
				}
			}
		}

		return result;
	}

	public void debug()
	{
		String a = "";
		String b = "(()";
		String c = ")()())";
		String d = "()()(((";
		String e = "()(()";

		System.out.println( longestValidParentheses( a ) );
		System.out.println( longestValidParentheses( b ) );
		System.out.println( longestValidParentheses( c ) );
		System.out.println( longestValidParentheses( d ) );
		System.out.println( longestValidParentheses( e ) );
	}
}
