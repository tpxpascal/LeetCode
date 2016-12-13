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

	public int jump3( int[] nums )
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
		Stack< MyJump > data = new Stack< MyJump >();
		data.push( start );

		while ( !data.empty() )
		{
			MyJump item = data.pop();

			List< MyJump > list = item.next( nums );
			if ( list.size() == 0 )
			{
				if ( item.step < result )
				{
					result = item.step;
				}
			}
			else
			{
				for ( MyJump i : list )
				{
					if ( i.step < result )
					{
						data.push( i );
					}
				}
			}
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
				8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1,
				2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3,
				5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2,
				3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5
		};

		System.out.println( jump3( a ) );
		System.out.println( jump3( b ) );
		System.out.println( jump3( c ) );
		System.out.println( jump3( d ) );

		System.out.println( System.currentTimeMillis() );
		//System.out.println( jump2( e ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( jump3( e ) );
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
				int index = block - 1;
				for ( int i = index; i >= 1; i-- )
				{
					int delta = block - i;
					if ( nums[ i - 1 ] >= delta )
					{
						MyJump item = new MyJump();
						item.step = step + 1;
						item.block = i;
						result.add( item );
					}
				}
			}

			return result;
		}
	}
}
