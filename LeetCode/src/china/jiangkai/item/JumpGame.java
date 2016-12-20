package china.jiangkai.item;

import java.util.*;

public class JumpGame
{
	public boolean canJump( int[] nums )
	{
		boolean result = false;

		if ( (nums == null) || (nums.length == 0) )
		{
			return false;
		}

		if ( nums.length == 1 )
		{
			return true;
		}

		MyJump start = new MyJump();
		start.block = nums.length;
		Stack< MyJump > data = new Stack< MyJump >();
		data.push( start );

		while ( !data.empty() )
		{
			MyJump item = data.pop();

			List< MyJump > list = item.next( nums );
			if ( list.size() == 0 )
			{
				if ( item.block < 2 )
				{
					return true;
				}
			}
			else
			{
				for ( MyJump i : list )
				{
					data.push( i );
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
			0
		};
		int[] c =
		{
			1
		};
		int[] d =
		{
				2, 3, 1, 1, 4
		};
		int[] e =
		{
				3, 2, 1, 0, 4
		};

		System.out.println( canJump( a ) );
		System.out.println( canJump( b ) );
		System.out.println( canJump( c ) );
		System.out.println( canJump( d ) );
		System.out.println( canJump( e ) );
	}

	class MyJump
	{
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
						item.block = i;
						result.add( item );
					}
				}
			}

			return result;
		}
	}
}
