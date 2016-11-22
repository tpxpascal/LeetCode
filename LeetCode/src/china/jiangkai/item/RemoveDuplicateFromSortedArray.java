package china.jiangkai.item;

public class RemoveDuplicateFromSortedArray
{
	public int removeDuplicates( int[] nums )
	{
		if ( nums == null )
		{
			return 0;
		}
		int result = nums.length;
		int limit = result;
		int position = 1;
		int index = 1;
		while ( index < limit )
		{
			if ( nums[ index - 1 ] == nums[ index ] )
			{
				result--;
			}
			else
			{
				nums[ position ] = nums[ index ];
				position++;
			}
			index++;
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b = null;
		int[] c =
		{
				1, 2, 3, 4
		};
		int[] d =
		{
				1, 1, 2, 2,
		};

		System.out.println( removeDuplicates( a ) );
		System.out.println( removeDuplicates( b ) );
		System.out.println( removeDuplicates( c ) );
		System.out.println( removeDuplicates( d ) );

		printArray( a );
		printArray( b );
		printArray( c );
		printArray( d );
	}

	private void printArray( int[] array )
	{
		if ( array != null )
		{
			for ( int i : array )
			{
				System.out.print( i );
			}
			System.out.println();
		}
		else
		{
			System.out.println( "null" );
		}
	}
}
