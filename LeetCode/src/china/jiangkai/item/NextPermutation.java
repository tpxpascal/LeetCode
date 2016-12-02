package china.jiangkai.item;

public class NextPermutation
{
	public void nextPermutation( int[] nums )
	{
		if ( (nums == null) || (nums.length < 2) )
		{
			return;
		}

		int index = -1;
		for ( int i = nums.length - 2; i >= 0; i-- )
		{
			if ( nums[ i + 1 ] > nums[ i ] )
			{
				index = i;
				break;
			}
		}

		if ( index == -1 )
		{
			int left = 0;
			int right = nums.length - 1;
			int temp = 0;
			while ( left < right )
			{
				temp = nums[ left ];
				nums[ left ] = nums[ right ];
				nums[ right ] = temp;
				left++;
				right--;
			}
		}
		else
		{
			int left = index + 1;
			int right = nums.length - 1;
			int temp = 0;
			while ( left < right )
			{
				temp = nums[ left ];
				nums[ left ] = nums[ right ];
				nums[ right ] = temp;
				left++;
				right--;
			}
			for ( int i = index + 1; i < nums.length; i++ )
			{
				if ( nums[ i ] > nums[ index ] )
				{
					temp = nums[ index ];
					nums[ index ] = nums[ i ];
					nums[ i ] = temp;
					break;
				}
			}
		}
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				1, 2, 3,
		};
		int[] c =
		{
				3, 2, 1,
		};
		int[] d =
		{
				1, 5, 4, 3, 2
		};
		int[] e =
		{
				3, 2, 4, 2, 1
		};

		nextPermutation( a );
		printArray( a );
		nextPermutation( b );
		printArray( b );
		nextPermutation( c );
		printArray( c );
		nextPermutation( d );
		printArray( d );
		nextPermutation( e );
		printArray( e );
	}

	private void printArray( int[] list )
	{
		System.out.println( "Result:" );
		for ( int i : list )
		{
			System.out.print( i );
			System.out.print( " " );
		}
		System.out.println();
	}
}
