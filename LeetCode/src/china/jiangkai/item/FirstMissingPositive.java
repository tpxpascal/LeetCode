package china.jiangkai.item;

import java.util.*;

public class FirstMissingPositive
{
	public int firstMissingPositive( int[] nums )
	{
		int result = 1;

		if ( (nums == null) || (nums.length == 0) )
		{
			return 1;
		}

		Arrays.sort( nums );

		if ( nums[ 0 ] > 1 )
		{
			return 1;
		}
		else
		{
			for ( int i : nums )
			{
				if ( i <= 0 )
				{
					continue;
				}
				if ( i == result )
				{
					result++;
					continue;
				}
				else
				{
					if ( i > result )
					{
						return result;
					}
				}
			}
			result = nums[ nums.length - 1 ] + 1;
		}

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				1, 2, 0,
		};
		int[] c =
		{
				3, 4, -1, 1
		};
		int[] d =
		{
				-1, 0, 0, 2, 1
		};
		int[] e =
		{
				1,
		};

		System.out.println( firstMissingPositive( a ) );
		System.out.println( firstMissingPositive( b ) );
		System.out.println( firstMissingPositive( c ) );
		System.out.println( firstMissingPositive( d ) );
		System.out.println( firstMissingPositive( e ) );
	}
}
