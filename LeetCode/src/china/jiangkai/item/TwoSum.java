package china.jiangkai.item;

public class TwoSum
{
	public int[] twoSum( int[] nums, int target )
	{
		int[] result = new int[ 2 ];
		int limitA = nums.length - 1;
		int limitB = nums.length;
		for ( int indexA = 0; indexA < limitA; indexA++ )
		{
			for ( int indexB = indexA + 1; indexB < limitB; indexB++ )
			{
				if ( nums[ indexA ] + nums[ indexB ] == target )
				{
					result[ 0 ] = indexA;
					result[ 1 ] = indexB;
					return result;
				}
			}
		}
		return null;
	}

	public void debug()
	{
		int[][] numList =
		{
				{
						2, 7, 11, 15
				},
				{
						1, 2, 4, 8, 16
				},
				{
						1, 3, 9, 27, 81
				},
				{
						-1, 0, 2
				},
		};
		int[] target =
		{
				9, 10, 12, 1
		};
		for ( int i = 0; i < numList.length; i++ )
		{
			int[] result = this.twoSum( numList[ i ], target[ i ] );
			System.out.print( "List:" );
			for ( int j : numList[ i ] )
			{
				System.out.print( j );
				System.out.print( " " );
			}
			System.out.println();
			System.out.println( "Target:" + target[ i ] );
			System.out.println( result[ 0 ] + " " + result[ 1 ] );
		}
	}
}
