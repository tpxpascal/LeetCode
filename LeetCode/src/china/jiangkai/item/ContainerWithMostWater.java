package china.jiangkai.item;

public class ContainerWithMostWater
{
	public int maxArea( int[] height )
	{
		int result = 0;

		for ( int i = 0; i < height.length - 1; i++ )
		{
			for ( int j = i + 1; j < height.length; j++ )
			{
				int area = (j - i) * Math.min( height[ i ], height[ j ] );
				if ( area > result )
				{
					result = area;
				}
			}
		}

		return result;
	}

	public int maxAreaFast( int[] height )
	{
		int result = 0;

		for ( int i = 1; i < height.length; i++ )
		{
			int upper = height.length - i;
			int line = 0;
			for ( int j = 0; j < upper; j++ )
			{
				int curLine = Math.min( height[ j ], height[ j + i ] );
				if ( curLine > line )
				{
					line = curLine;
				}
			}
			int area = line * i;
			if ( area > result )
			{
				result = area;
			}
		}

		return result;
	}

	public void debug()
	{
		int[] a =
		{
				2, 1, 1, 2
		};
		int[] b =
		{
				1, 2, 3, 4
		};
		int[] c =
		{
				3, 5
		};
		int[] d =
		{
				1, 1
		};
		int[] x = new int[ 15000 ];
		int[] y = new int[ 15000 ];

		for ( int i = 0; i < 15000; i++ )
		{
			x[ i ] = 15000 - i;
			y[ i ] = i + 1;
		}

		System.out.println( maxArea( a ) );
		System.out.println( maxArea( b ) );
		System.out.println( maxArea( c ) );
		System.out.println( maxArea( d ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( maxArea( x ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( maxArea( y ) );
		System.out.println( System.currentTimeMillis() );

		System.out.println( maxAreaFast( a ) );
		System.out.println( maxAreaFast( b ) );
		System.out.println( maxAreaFast( c ) );
		System.out.println( maxAreaFast( d ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( maxAreaFast( x ) );
		System.out.println( System.currentTimeMillis() );
		System.out.println( maxAreaFast( y ) );
		System.out.println( System.currentTimeMillis() );
	}
}
