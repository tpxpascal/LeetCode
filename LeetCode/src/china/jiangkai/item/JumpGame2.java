package china.jiangkai.item;

import java.util.*;

public class JumpGame2
{
	public int jump( int[] nums )
	{
		int result = 0;

		if ( (nums == null) || (nums.length == 0) )
		{
			return -1;
		}

		if ( nums.length == 1 )
		{
			return 0;
		}
		else
		{
			result = myjump( nums, nums.length );
		}

		return result;
	}

	public int jump2( int[] nums )
	{
		int result = Integer.MAX_VALUE;

		if ( (nums == null) || (nums.length == 0) )
		{
			return -1;
		}

		if ( nums.length == 1 )
		{
			return 0;
		}

		MyJump start = new MyJump();
		start.step = 0;
		start.block = nums.length;
		List< MyJump > jumps = start.next( nums );
		while ( jumps.size() > 0 )
		{
			List< MyJump > temp = new LinkedList< MyJump >();
			for ( MyJump i : jumps )
			{
				if ( i.step >= result )
				{
					continue;
				}
				List< MyJump > unit = i.next( nums );
				if ( unit.size() > 0 )
				{
					for ( MyJump o : unit )
					{
						if ( o.step < result )
						{
							temp.add( o );
						}
					}
				}
				else
				{
					if ( i.step < result )
					{
						result = i.step;
					}
				}
			}
			jumps = temp;
		}

		return result;
	}

	private int myjump( int[] nums, int last )
	{
		int result = Integer.MAX_VALUE;

		if ( last < 2 )
		{
			return 0;
		}
		else
		{
			int start = last - 1;
			for ( int i = start; i >= 1; i-- )
			{
				if ( nums[ i - 1 ] >= last - i )
				{
					int value = 1 + myjump( nums, i );
					if ( value < result )
					{
						result = value;
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
				2, 3, 1, 1, 4
		};
		int[] b = {};
		int[] c =
		{
				1, 1, 1
		};
		int[] d =
		{
			2,
		};
		int[] e =
		{
				6, 2, 6, 1, 7, 9, 3, 5, 3, 7, 2, 8, 9, 4, 7, 7, 2, 2, 8, 4, 6,
				6, 1, 3,
		};

		System.out.println( jump2( a ) );
		System.out.println( jump2( b ) );
		System.out.println( jump2( c ) );
		System.out.println( jump2( d ) );

		System.out.println( System.currentTimeMillis() );
		System.out.println( jump( e ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( jump2( e ) );
		System.out.println( System.currentTimeMillis() );
	}

	class MyJump
	{
		public int step = 0;
		public int block = 0;

		public List< MyJump > next( int[] nums )
		{
			List< MyJump > result = new LinkedList< MyJump >();

			if ( block < 2 )
			{
				return result;
			}
			else
			{
				int index = block - 2;
				for ( int i = index; i >= 0; i-- )
				{
					int delta = block - i - 1;
					if ( nums[ i ] >= delta )
					{
						MyJump item = new MyJump();
						item.step = step + 1;
						item.block = i + 1;
						result.add( item );
					}
				}
			}

			return result;
		}
	}
}
