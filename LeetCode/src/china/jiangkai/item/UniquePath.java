package china.jiangkai.item;

import java.util.*;

public class UniquePath
{
	public int uniquePaths( int m, int n )
	{
		int result = 0;

		if ( (m == 1) || (n == 1) )
		{
			return 1;
		}

		result = uniquePaths( m - 1, n ) + uniquePaths( m, n - 1 );

		return result;
	}

	public int uniquePaths2( int m, int n )
	{
		int result = 0;

		ArrayList< Position > allPosition = new ArrayList< Position >();
		Position start = new Position( m, n );
		allPosition.add( start );

		while ( allPosition.size() > 0 )
		{
			ArrayList< Position > temp = new ArrayList< Position >();
			for ( Position p : allPosition )
			{
				Position[] list = p.howToGet();
				result = result + 2 - list.length;
				for ( Position i : list )
				{
					temp.add( i );
				}
			}
			allPosition = temp;
		}

		return result;
	}

	public void debug()
	{
		System.out.println( uniquePaths2( 2, 2 ) );
		System.out.println( uniquePaths2( 3, 3 ) );
		System.out.println( uniquePaths2( 2, 3 ) );
		System.out.println( uniquePaths2( 100, 100 ) );
	}

	class Position
	{
		public int x = 0;
		public int y = 0;

		public Position()
		{

		}

		public Position( int m, int n )
		{
			x = m;
			y = n;
		}

		public Position[] howToGet()
		{
			int m = x - 1;
			int n = y - 1;
			if ( m == 1 )
			{
				if ( n == 1 )
				{
					Position[] result = {};
					return result;
				}
				else
				{
					Position p = new Position( x, n );
					Position[] result =
					{
						p
					};
					return result;
				}
			}
			else
			{
				if ( n == 1 )
				{
					Position p = new Position( m, y );
					Position[] result =
					{
						p
					};
					return result;
				}
				else
				{
					Position p = new Position( x, n );
					Position q = new Position( m, y );
					Position[] result =
					{
							p, q
					};
					return result;
				}
			}
		}
	}
}
