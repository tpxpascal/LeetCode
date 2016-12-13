package china.jiangkai.item;

import java.util.*;

public class Permutations2
{
	public List< List< Integer >> permuteUnique( int[] nums )
	{
		List< List< Integer >> result = new LinkedList< List< Integer >>();

		if ( (nums == null) || (nums.length < 1) )
		{
			return result;
		}

		int[] start = Arrays.copyOf( nums, nums.length );

		while ( true )
		{
			List< Integer > item = new LinkedList< Integer >();
			for ( int i : nums )
			{
				item.add( i );
			}
			result.add( item );
			next( nums );

			int flag = 0;
			for ( int i = 0; i < nums.length; i++ )
			{
				if ( nums[ i ] == start[ i ] )
				{
					flag++;
				}
			}

			if ( flag == nums.length )
			{
				break;
			}
		}

		return result;
	}

	private void next( int[] nums )
	{
		int index = -1;
		for ( int i = nums.length - 2; i >= 0; i-- )
		{
			if ( nums[ i + 1 ] > nums[ i ] )
			{
				index = i;
				break;
			}
		}

		if ( index == -1 )
		{
			int left = 0;
			int right = nums.length - 1;
			int temp = 0;
			while ( left < right )
			{
				temp = nums[ left ];
				nums[ left ] = nums[ right ];
				nums[ right ] = temp;
				left++;
				right--;
			}
		}
		else
		{
			int left = index + 1;
			int right = nums.length - 1;
			int temp = 0;
			while ( left < right )
			{
				temp = nums[ left ];
				nums[ left ] = nums[ right ];
				nums[ right ] = temp;
				left++;
				right--;
			}
			for ( int i = index + 1; i < nums.length; i++ )
			{
				if ( nums[ i ] > nums[ index ] )
				{
					temp = nums[ index ];
					nums[ index ] = nums[ i ];
					nums[ i ] = temp;
					break;
				}
			}
		}
	}

	public void debug()
	{
		int[] a = {};
		int[] b =
		{
				1, 1, 3
		};
		int[] c =
		{
			1,
		};
		int[] d =
		{
				1, 1
		};
		int[] e =
		{
				1, 2, 1, 2
		};

		print( permuteUnique( a ) );
		print( permuteUnique( b ) );
		print( permuteUnique( c ) );
		print( permuteUnique( d ) );
		print( permuteUnique( e ) );
	}

	private void print( List< List< Integer >> list )
	{
		System.out.println( "Result:" );
		for ( List< Integer > item : list )
		{
			for ( int i : item )
			{
				System.out.print( i + " " );
			}
			System.out.println();
		}
	}
}
