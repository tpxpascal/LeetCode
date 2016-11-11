package china.jiangkai.item;

import java.util.*;

public class ThreeSum
{
	public List< List< Integer >> threeSum( int[] nums )
	{
		List< List< Integer >> result = new LinkedList< List< Integer >>();
		Map< String, Integer > keys = new HashMap< String, Integer >();

		int end1 = nums.length - 2;
		for ( int i = 0; i < end1; i++ )
		{
			int start2 = i + 1;
			int end2 = end1 + 1;
			for ( int j = start2; j < end2; j++ )
			{
				int start3 = j + 1;
				int end3 = end2 + 1;
				int next = -nums[ i ] - nums[ j ];
				for ( int k = start3; k < end3; k++ )
				{
					if ( nums[ k ] == next )
					{
						List< Integer > item = new ArrayList< Integer >();
						item.add( nums[ i ] );
						item.add( nums[ j ] );
						item.add( nums[ k ] );
						Collections.sort( item );
						StringBuilder keyBuilder = new StringBuilder();
						for ( int x : item )
						{
							keyBuilder.append( x );
							keyBuilder.append( "_" );
						}
						String key = keyBuilder.toString();
						if ( !keys.containsKey( key ) )
						{
							keys.put( key, 1 );
							result.add( item );
						}
					}
				}
			}
		}

		return result;
	}

	public void debug()
	{
		int[] a =
		{
				-1, 0, 1, 2, -1, -4
		};
		int[] b = {};
		int[] c =
		{
				1, 2, 3
		};
		int[] d =
		{
				-1, 1, 0, 0, 1, -1
		};

		int[] x =
		{
				13, -5, 3, 3, -1, 13, 3, 1, -9, -4, 9, 12, 6, -9, -6, -12, -8,
				3, 12, 14, 4, -15, 2, -11, 4, -12, 10, 9, -6, -3, -8, 14, 7, 3,
				2, -8, -7, -10, 8, -8, -7, -6, -11, 6, -7, -2, 9, -8, 8, -2,
				13, -10, -2, 0, -14, -13, -4, 11, 3, -3, -7, 3, -4, 8, 13, 13,
				-15, -9, 10, 0, -2, -12, 1, 2, 9, 1, 8, -4, 8, -7, 9, 7, -2,
				-15, 14, 0, -13, -13, -12, -2, -1, -11, 8, 10, 12, 6, 8, 4, 12,
				3, 11, -12, -2, -3, 5, -15, 6, -10, -4, -1, -1, -10, 13
		};

		List< List< Integer >> show = null;

		show = threeSum( a );
		// printResult( show );
		show = threeSum( b );
		// printResult( show );
		show = threeSum( c );
		// printResult( show );
		show = threeSum( d );
		// printResult( show );

		System.out.println( System.currentTimeMillis() );
		show = threeSum( x );
		System.out.println( System.currentTimeMillis() );
		// printResult( show );
	}

	private void printResult( List< List< Integer >> list )
	{
		System.out.println( "Result:" );
		for ( List< Integer > i : list )
		{
			printList( i );
		}
		System.out.println();
	}

	private void printList( List< Integer > list )
	{
		for ( int i : list )
		{
			System.out.print( i );
			System.out.print( " " );
		}
		System.out.println();
	}
}
