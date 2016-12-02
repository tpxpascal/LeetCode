package china.jiangkai.item;

public class SearchInRotatedSortedArray
{
	public int search( int[] nums, int target )
	{
		int result = 0;

		if ( (nums == null) || (nums.length == 0) )
		{
			return -1;
		}

		if ( target == nums[ 0 ] )
		{
			return 0;
		}

		int size = nums.length;
		int valid = size - 1;

		if ( target > nums[ 0 ] )
		{
			for ( result = 0; result < size; result++ )
			{
				if ( nums[ result ] == target )
				{
					return result;
				}
				if ( result < valid )
				{
					if ( nums[ result ] > nums[ result + 1 ] )
					{
						return -1;
					}
				}
			}
			result = -1;
		}
		else
		{
			for ( result = valid; result >= 0; result-- )
			{
				if ( nums[ result ] == target )
				{
					return result;
				}
				if ( result >= 1 )
				{
					if ( nums[ result ] < nums[ result - 1 ] )
					{
						return -1;
					}
				}
			}
			result = -1;
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				3, 4, 5, 0, 1, 2,
		};
		int[] c =
		{
				6, 8, 10, 2, 4,
		};
		int[] d =
		{
				7, 9, 1, 3, 5,
		};
		int[] e =
		{
			1,
		};

		System.out.println( search( a, 0 ) );
		System.out.println( search( b, 0 ) );
		System.out.println( search( c, 0 ) );
		System.out.println( search( d, 0 ) );
		System.out.println( search( e, 2 ) );
	}
}
