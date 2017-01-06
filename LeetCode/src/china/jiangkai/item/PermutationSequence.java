package china.jiangkai.item;

public class PermutationSequence
{
	public String getPermutation( int n, int k )
	{
		StringBuilder result = new StringBuilder();

		int[] start = new int[ n ];
		int value = 1;
		for ( int i = 0; i < n; i++ )
		{
			start[ i ] = value;
			value++;
		}

		for ( int i = 1; i < k; i++ )
		{
			next( start );
		}
		for ( int i : start )
		{
			result.append( i );
		}

		return result.toString();
	}

	private void next( int[] nums )
	{
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
		System.out.println( getPermutation( 1, 1 ) );
		System.out.println( getPermutation( 2, 2 ) );
		System.out.println( getPermutation( 3, 3 ) );
		System.out.println( getPermutation( 9, 1 ) );
		System.out.println( getPermutation( 9, 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 ) );
	}
}
