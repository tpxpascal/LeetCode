package china.jiangkai.item;

import java.util.*;

public class ValidParentheses
{
	public boolean isValid( String s )
	{
		boolean result = true;

		Stack< Character > data = new Stack< Character >();

		for ( int i = 0; i < s.length(); i++ )
		{
			char curr = s.charAt( i );

			if ( curr == '(' || curr == '[' || curr == '{' )
			{
				data.push( curr );
			}

			if ( curr == ')' )
			{
				if ( data.empty() || data.peek() != '(' )
				{
					return false;
				}
				else
				{
					data.pop();
				}
			}

			if ( curr == ']' )
			{
				if ( data.empty() || data.peek() != '[' )
				{
					return false;
				}
				else
				{
					data.pop();
				}
			}

			if ( curr == '}' )
			{
				if ( data.empty() || data.peek() != '{' )
				{
					return false;
				}
				else
				{
					data.pop();
				}
			}
		}

		if ( !data.empty() )
		{
			result = false;
		}

		return result;
	}

	public void debug()
	{
		String a = "()[]";
		String b = "([)]";
		String c = "(]";
		String d = "(()[])";

		System.out.println( isValid( a ) );
		System.out.println( isValid( b ) );
		System.out.println( isValid( c ) );
		System.out.println( isValid( d ) );
	}
}
