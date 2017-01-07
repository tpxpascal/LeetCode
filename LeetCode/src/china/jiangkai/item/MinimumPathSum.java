package china.jiangkai.item;

public class MinimumPathSum
{
	public int minPathSum( int[][] grid )
	{
		int result = 0;

		int m = grid.length;
		int n = grid[ 0 ].length;

		for ( int i = 1; i < m; i++ )
		{
			grid[ i ][ 0 ] += grid[ i - 1 ][ 0 ];
		}
		for ( int i = 1; i < n; i++ )
		{
			grid[ 0 ][ i ] += grid[ 0 ][ i - 1 ];
		}

		for ( int i = 1; i < m; i++ )
		{
			for ( int j = 1; j < n; j++ )
			{
				int top = grid[ i - 1 ][ j ];
				int left = grid[ i ][ j - 1 ];

				grid[ i ][ j ] += Math.min( top, left );
			}
		}

		result = grid[ m - 1 ][ n - 1 ];
		return result;
	}

	public void debug()
	{
		int[][] a =
		{
			{
					9, 1, 4, 8
			},
		};
		int[][] b =
		{
				{
						0, 0, 0
				},
				{
						0, 1, 0
				},
				{
						0, 0, 0
				}
		};
		int[][] c =
		{
				{
						0, 0, 0,
				},
				{
						1, 1, 1
				},
				{
						0, 0, 0
				}
		};
		int[][] d =
		{
				{
						0, 0, 0,
				},
				{
						0, 0, 0,
				},
				{
						0, 0, 0,
				},
		};

		System.out.println( minPathSum( a ) );
		System.out.println( minPathSum( b ) );
		System.out.println( minPathSum( c ) );
		System.out.println( minPathSum( d ) );
	}
}
