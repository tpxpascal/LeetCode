package china.jiangkai.item;

public class RemoveElement
{
	public int removeElement( int[] nums, int val )
	{
		if ( nums == null )
		{
			return 0;
		}

		int result = nums.length;
		int limit = result;
		int position = 0;
		int index = 0;
		while ( index < limit )
		{
			if ( nums[ index ] == val )
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

		System.out.println( removeElement( a, 1 ) );
		System.out.println( removeElement( b, 2 ) );
		System.out.println( removeElement( c, 3 ) );
		System.out.println( removeElement( d, 2 ) );

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
