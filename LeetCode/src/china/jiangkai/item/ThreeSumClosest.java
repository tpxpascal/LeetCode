package china.jiangkai.item;

public class ThreeSumClosest
{
	public int threeSumClosest( int[] nums, int target )
	{
		int result = 0;
		int delta = Integer.MAX_VALUE;

		int end1 = nums.length - 2;
		int end2 = end1 + 1;
		int end3 = end2 + 1;
		for ( int i = 0; i < end1; i++ )
		{
			for ( int j = i + 1; j < end2; j++ )
			{
				int add1 = nums[ i ] + nums[ j ];
				for ( int k = j + 1; k < end3; k++ )
				{
					int temp = add1 + nums[ k ];
					if ( temp == target )
					{
						return temp;
					}
					int flag = Math.abs( temp - target );
					if ( flag < delta )
					{
						result = temp;
						delta = flag;
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
				-1, 2, 1, -4
		};
		int[] b =
		{
				1, 2, 3, 4
		};
		int[] c =
		{
				-2, 1, 1, 2
		};
		int[] d =
		{
				1, 1, 1, 1
		};

		System.out.println( threeSumClosest( a, 1 ) );
		System.out.println( threeSumClosest( b, 0 ) );
		System.out.println( threeSumClosest( c, 0 ) );
		System.out.println( threeSumClosest( d, 4 ) );
	}
}
