package china.jiangkai.item;

public class SearchInsertPosition
{
	public int searchInsert( int[] nums, int target )
	{
		int result = 0;

		if ( (nums == null) || (nums.length == 0) )
		{
			return 0;
		}

		int size = nums.length;
		int left = 0;
		int right = size - 1;

		if ( target <= nums[ left ] )
		{
			return 0;
		}
		if ( target > nums[ right ] )
		{
			return size;
		}

		boolean leftOk = false;
		boolean rightOk = false;

		while ( (!leftOk) && (!rightOk) )
		{
			if ( left == right )
			{
				if ( nums[ left ] >= target )
				{
					return left;
				}
				else
				{
					return left + 1;
				}
			}
			if ( left + 1 == right )
			{
				if ( target <= nums[ left ] )
				{
					return left;
				}
				else
				{
					if ( target <= nums[ right ] )
					{
						return right;
					}
					else
					{
						return right + 1;
					}
				}
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
				return index;
			}
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				5, 7, 8, 10
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
				1, 3
		};

		System.out.println( searchInsert( a, 0 ) );
		System.out.println( searchInsert( b, 6 ) );
		System.out.println( searchInsert( c, 5 ) );
		System.out.println( searchInsert( d, 0 ) );
		System.out.println( searchInsert( e, 3 ) );
	}
}
