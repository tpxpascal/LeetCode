package china.jiangkai.item;

public class SearchForARange
{
	public int[] searchRange( int[] nums, int target )
	{
		int[] result = new int[ 2 ];

		if ( (nums == null) || (nums.length == 0) )
		{
			result[ 0 ] = -1;
			result[ 1 ] = -1;
			return result;
		}

		int size = nums.length;
		int left = 0;
		int right = size - 1;

		if ( (target < nums[ left ]) || (target > nums[ right ]) )
		{
			result[ 0 ] = -1;
			result[ 1 ] = -1;
			return result;
		}

		boolean leftOk = false;
		boolean rightOk = false;

		while ( (!leftOk) && (!rightOk) )
		{
			if ( (left + 1 == right) || (left == right) )
			{
				if ( nums[ left ] == target )
				{
					result[ 0 ] = left;
					leftOk = true;
					if ( nums[ right ] == target )
					{
						result[ 1 ] = right;
						rightOk = true;
					}
					else
					{
						result[ 1 ] = left;
						rightOk = true;
					}
				}
				else
				{
					if ( nums[ right ] == target )
					{
						result[ 0 ] = right;
						result[ 1 ] = right;
						leftOk = true;
						rightOk = true;
					}
					else
					{
						result[ 0 ] = -1;
						result[ 1 ] = -1;
						leftOk = true;
						rightOk = true;
					}
				}

				continue;
			}

			int index = (left + right) / 2;
			if ( nums[ index ] < target )
			{
				left = index;
				continue;
			}
			if ( nums[ index ] > target )
			{
				right = index;
				continue;
			}
			if ( nums[ index ] == target )
			{
				int min = left;
				int max = index;
				while ( !leftOk )
				{
					int pos = (min + max + 1) / 2;
					if ( pos == max )
					{
						if ( nums[ min ] == target )
						{
							result[ 0 ] = min;
							leftOk = true;
						}
						else
						{
							result[ 0 ] = pos;
							leftOk = true;
						}
					}

					if ( nums[ pos ] < target )
					{
						min = pos;
						continue;
					}
					else
					{
						max = pos;
						continue;
					}
				}

				min = index;
				max = right;
				while ( !rightOk )
				{
					int pos = (min + max) / 2;
					if ( pos == min )
					{
						if ( nums[ max ] == target )
						{
							result[ 1 ] = pos + 1;
							rightOk = true;
						}
						else
						{
							result[ 1 ] = pos;
							rightOk = true;
						}
					}

					if ( nums[ pos ] > target )
					{
						max = pos;
						continue;
					}
					else
					{
						min = pos;
						continue;
					}
				}
			}
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				5, 7, 7, 8, 8, 10
		};
		int[] c =
		{
				1, 3, 5, 7, 9
		};
		int[] d =
		{
				2, 4, 6, 8, 10
		};
		int[] e =
		{
			1,
		};

		printArray( searchRange( a, 8 ) );
		printArray( searchRange( b, 8 ) );
		printArray( searchRange( c, 5 ) );
		printArray( searchRange( d, 5 ) );
		printArray( searchRange( e, 1 ) );
	}

	public void printArray( int[] list )
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
