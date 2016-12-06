package china.jiangkai.item;

import java.util.*;

public class TrappingRainWater
{
	public int trap( int[] height )
	{
		int result = 0;

		if ( (height == null) || (height.length < 3) )
		{
			return 0;
		}

		int size = height.length;

		int[] data = new int[ size ];

		int tallest = 0;

		LinkedList< Integer > levelLis = new LinkedList< Integer >();

		for ( int i = 0; i < size; i++ )
		{
			int tall = height[ i ];
			if ( tall > tallest )
			{
				levelLis.addLast( tall );
				tallest = tall;
			}
			else
			{
				if ( (levelLis.size() == 0) || (tall < levelLis.getFirst()) )
				{
					levelLis.addFirst( tall );
				}
				else
				{
					int max = levelLis.size() - 1;
					for ( int p = 0; p < max; p++ )
					{
						if ( (levelLis.get( p ) < tall)
								&& (levelLis.get( p + 1 ) > tall) )
						{
							levelLis.add( p + 1, tall );
						}
					}
				}
			}

			data[ i ] = tall;
		}

		int old = 0;
		for ( int i = 0; i < levelLis.size(); i++ )
		{
			int temp = 0;
			int wall = 0;
			int level = levelLis.get( i );
			for ( int j = 0; j < size; j++ )
			{
				if ( (wall == 0) && (data[ j ] >= level) )
				{
					wall = 1;
					continue;
				}
				if ( (wall == 1) && (data[ j ] < level) )
				{
					temp = temp + level - old;
					continue;
				}
				if ( (wall == 1) && (data[ j ] >= level) )
				{
					result = result + temp;
					temp = 0;
					continue;
				}
			}
			old = level;
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
		};
		int[] c =
		{
				1, 2, 3, 2, 1
		};
		int[] d =
		{
				3, 2, 1, 0, 1, 0, 1, 2, 3
		};
		int[] e =
		{
				2, 1, 0, 1, 2, 3, 2, 1, 0, 1, 2
		};

		System.out.println( trap( a ) );
		System.out.println( trap( b ) );
		System.out.println( trap( c ) );
		System.out.println( trap( d ) );
		System.out.println( trap( e ) );
	}
}
