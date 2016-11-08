package china.jiangkai.item;

import java.util.*;

public class ZigZagConversion
{
	public String convert( String s, int numRows )
	{
		StringBuilder result = new StringBuilder();

		int rowMax = numRows;
		int colMax = s.length();

		char[][] matrix = new char[ rowMax ][ colMax ];

		int flag = 1;
		int row = -1;
		int col = 0;
		for ( int i = 0; i < s.length(); i++ )
		{
			if ( flag == 1 )
			{
				row = row + 1;
				if ( row == rowMax )
				{
					if ( rowMax >= 3 )
					{
						flag = -flag;
						row = rowMax - 2;
						col = col + 1;
					}
					else
					{
						row = 0;
						col = col + 1;
					}
				}
			}
			else
			{
				row = row - 1;
				col = col + 1;
				if ( row == 0 )
				{
					flag = -flag;
				}
			}
			matrix[ row ][ col ] = s.charAt( i );
		}

		for ( int i = 0; i < rowMax; i++ )
		{
			for ( int j = 0; j < colMax; j++ )
			{
				if ( matrix[ i ][ j ] != 0 )
				{
					result.append( matrix[ i ][ j ] );
				}
			}
		}

		return result.toString();
	}

	public String convertFast( String s, int numRows )
	{
		StringBuilder result = new StringBuilder();

		LinkedList< Character >[] list = new LinkedList[ numRows ];
		for ( int i = 0; i < numRows; i++ )
		{
			list[ i ] = new LinkedList< Character >();
		}

		int row = 0;
		int step = 1;
		for ( int i = 0; i < s.length(); i++ )
		{
			list[ row ].add( s.charAt( i ) );
			if ( row == 0 )
			{
				step = 1;
			}
			if ( row == numRows - 1 )
			{
				step = -1;
			}
			if ( numRows != 1 )
			{
				row = row + step;
			}
		}

		for ( int i = 0; i < numRows; i++ )
		{
			for ( Character c : list[ i ] )
			{
				result.append( c );
			}
		}

		return result.toString();
	}

	public void debug()
	{
		String a = "PAYPALISHIRING";
		String b = "ABCDEFGHIJxyz";
		String c = "abcd";
		String d = "ab";

		System.out.println( convertFast( a, 3 ) );
		System.out.println( convertFast( b, 4 ) );
		System.out.println( convertFast( c, 2 ) );
		System.out.println( convertFast( d, 1 ) );
	}
}
