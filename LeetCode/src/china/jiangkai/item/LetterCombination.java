package china.jiangkai.item;

import java.util.*;

public class LetterCombination
{
	public List< String > letterCombinations( String digits )
	{
		List< String > result = new LinkedList< String >();

		String[] base =
		{
				" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz"
		};

		if ( digits == null || digits.length() == 0 )
		{
			return result;
		}

		int size = digits.length();
		String[] input = new String[ size ];
		int[] flag = new int[ size ];
		int[] index = new int[ size ];

		for ( int i = 0; i < size; i++ )
		{
			char cur = digits.charAt( i );
			input[ i ] = base[ cur - '0' ];
			flag[ i ] = input[ i ].length();
		}

		int end = 0;
		while ( end == 0 )
		{
			StringBuilder item = new StringBuilder();
			for ( int i = 0; i < size; i++ )
			{
				if ( input[ i ].length() > 0 )
				{
					item.append( input[ i ].charAt( index[ i ] ) );
				}
			}
			result.add( item.toString() );

			int plus = 0;
			int limit = size - 1;
			for ( int i = limit; i >= 0; i-- )
			{
				if ( i == limit )
				{
					index[ i ] = index[ i ] + 1 + plus;
				}
				else
				{
					index[ i ] = index[ i ] + plus;
				}
				if ( flag[ i ] == 0 )
				{
					continue;
				}
				plus = index[ i ] / flag[ i ];

				if ( plus > 0 )
				{
					index[ i ] = index[ i ] % flag[ i ];
				}
				else
				{
					break;
				}
			}

			end = plus;
		}

		return result;
	}

	public void debug()
	{
		String a = "23";
		String b = "2103";
		String c = "223";
		String d = "";

		printList( letterCombinations( a ) );
		printList( letterCombinations( b ) );
		printList( letterCombinations( c ) );
		printList( letterCombinations( d ) );
	}

	private void printList( List< String > list )
	{
		System.out.println( "Result:" );
		for ( String i : list )
		{
			System.out.println( i );
		}
		System.out.println();
	}
}
