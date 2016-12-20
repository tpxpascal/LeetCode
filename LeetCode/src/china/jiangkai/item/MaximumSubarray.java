package china.jiangkai.item;

import java.util.*;

public class MaximumSubarray
{
	public int maxSubArray( int[] nums )
	{
		int result = Integer.MIN_VALUE;

		int block = 0;
		int count = 0;
		int maxBlock = Integer.MIN_VALUE;
		int plusBlock = 0;
		int minusBlock = 0;
		LinkedList< Integer > maxBlockList = new LinkedList< Integer >();
		ArrayList< Integer > leftBlockList = new ArrayList< Integer >();
		ArrayList< Integer > rightBlockList = new ArrayList< Integer >();
		int flag = 0;
		for ( int i = 0; i < nums.length; i++ )
		{
			if ( nums[ i ] > result )
			{
				result = nums[ i ];
			}

			if ( flag == 0 )
			{
				if ( nums[ i ] > 0 )
				{
					flag = 1;
					block = nums[ i ];
				}
			}
			else
			{
				if ( (block * nums[ i ] < 0) || (i == nums.length) )
				{
					if ( block > maxBlock )
					{
						maxBlock = block;
						maxBlockList.clear();
						maxBlockList.add( count );
					}
					else
					{
						if ( block == maxBlock )
						{
							maxBlockList.add( count );
						}
					}
					if ( block > 0 )
					{
						plusBlock = block;
						if ( minusBlock != 0 )
						{
							rightBlockList.add( (block + minusBlock) );
						}
					}
					else
					{
						minusBlock = block;
						if ( plusBlock != 0 )
						{
							leftBlockList.add( (block + plusBlock) );
						}
					}
					block = nums[ i ];
					count++;
				}
				else
				{
					block = block + nums[ i ];
					if ( (i == nums.length) && (block > 0) )
					{
						if ( block > maxBlock )
						{
							maxBlock = block;
							maxBlockList.clear();
							maxBlockList.add( count );
						}
						else
						{
							if ( block == maxBlock )
							{
								maxBlockList.add( count );
							}
						}

						rightBlockList.add( (block + minusBlock) );
					}
				}
			}
		}

		for ( int index : maxBlockList )
		{

		}

		// DEBUG
		System.out.println( "max" );
		for ( int i : maxBlockList )
		{
			System.out.print( i + " " );
		}
		System.out.println();
		System.out.println( "left" );
		for ( int i : leftBlockList )
		{
			System.out.print( i + " " );
		}
		System.out.println();
		System.out.println( "right" );
		for ( int i : rightBlockList )
		{
			System.out.print( i + " " );
		}
		System.out.println();

		return result;
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				-2, 1, -3, 4, -1, 2, 1, -5, 4
		};
		int[] c =
		{
			-5,
		};
		int[] d =
		{
				1, 2
		};
		int[] e =
		{
				-5, -2
		};

		System.out.println( maxSubArray( a ) );
		System.out.println( maxSubArray( b ) );
		System.out.println( maxSubArray( c ) );
		System.out.println( maxSubArray( d ) );
		System.out.println( maxSubArray( e ) );
	}
}
