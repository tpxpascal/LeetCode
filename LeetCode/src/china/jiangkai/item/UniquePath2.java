package china.jiangkai.item;

public class UniquePath2
{
	public int uniquePathsWithObstacles( int[][] obstacleGrid )
	{
		int result = 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[ 0 ].length;

		if ( obstacleGrid[ 0 ][ 0 ] == 1 )
		{
			return 0;
		}

		int block = 0;

		for ( int i = 0; i < m; i++ )
		{
			if ( obstacleGrid[ i ][ 0 ] == 1 )
			{
				block = 1;
			}

			if ( block == 0 )
			{
				obstacleGrid[ i ][ 0 ] = 1;
			}
			else
			{
				obstacleGrid[ i ][ 0 ] = 0;
			}
		}

		block = 0;
		for ( int i = 1; i < n; i++ )
		{
			if ( obstacleGrid[ 0 ][ i ] == 1 )
			{
				block = 1;
			}

			if ( block == 0 )
			{
				obstacleGrid[ 0 ][ i ] = 1;
			}
			else
			{
				obstacleGrid[ 0 ][ i ] = 0;
			}
		}

		for ( int i = 1; i < m; i++ )
		{
			for ( int j = 1; j < n; j++ )
			{
				if ( obstacleGrid[ i ][ j ] == 0 )
				{
					obstacleGrid[ i ][ j ] = obstacleGrid[ i - 1 ][ j ]
							+ obstacleGrid[ i ][ j - 1 ];
				}
				else
				{
					obstacleGrid[ i ][ j ] = 0;
				}
			}
		}

		result = obstacleGrid[ m - 1 ][ n - 1 ];

		return result;
	}

	public void debug()
	{
		int[][] a =
		{
			{
					1, 0
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

		System.out.println( uniquePathsWithObstacles( a ) );
		System.out.println( uniquePathsWithObstacles( b ) );
		System.out.println( uniquePathsWithObstacles( c ) );
		System.out.println( uniquePathsWithObstacles( d ) );
	}
}
