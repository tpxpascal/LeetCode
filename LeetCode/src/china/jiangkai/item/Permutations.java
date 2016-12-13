package china.jiangkai.item;

import java.util.*;

public class Permutations
{
	public List< List< Integer >> permute( int[] nums )
	{
		List< List< Integer >> result = new LinkedList< List< Integer >>();

		if ( (nums == null) || (nums.length < 1) )
		{
			return result;
		}

		int size = nums.length;
		long count = 1;
		for ( int i = 1; i <= size; i++ )
		{
			count = count * i;
		}

		while ( count > 0 )
		{
			List< Integer > item = new LinkedList< Integer >();
			for ( int i : nums )
			{
				item.add( i );
			}
			result.add( item );
			next( nums );
			count--;
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
				1, 2, 3
		};
		int[] c =
		{
			1,
		};
		int[] d =
		{
				1, 2
		};
		int[] e =
		{
				3, 2, 1, 4
		};

		print( permute( a ) );
		print( permute( b ) );
		print( permute( c ) );
		print( permute( d ) );
		print( permute( e ) );
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
