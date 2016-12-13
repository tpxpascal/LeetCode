package china.jiangkai.item;

public class RotateImage
{
	public void rotate( int[][] matrix )
	{
		if ( matrix == null || matrix.length <= 1 )
		{
			return;
		}

		int size = matrix.length - 1;
		int limit = 0;

		int temp = 0;

		if ( matrix.length % 2 == 0 )
		{
			limit = matrix.length / 2 - 1;
			for ( int i = 0; i <= limit; i++ )
			{
				for ( int j = 0; j <= limit; j++ )
				{
					temp = matrix[ size - j ][ i ];
					matrix[ size - j ][ i ] = matrix[ size - i ][ size - j ];
					matrix[ size - i ][ size - j ] = matrix[ j ][ size - i ];
					matrix[ j ][ size - i ] = matrix[ i ][ j ];
					matrix[ i ][ j ] = temp;
				}
			}
		}
		else
		{
			limit = (matrix.length - 1) / 2;
			for ( int i = 0; i <= limit; i++ )
			{
				for ( int j = 0; j < limit; j++ )
				{
					temp = matrix[ size - j ][ i ];
					matrix[ size - j ][ i ] = matrix[ size - i ][ size - j ];
					matrix[ size - i ][ size - j ] = matrix[ j ][ size - i ];
					matrix[ j ][ size - i ] = matrix[ i ][ j ];
					matrix[ i ][ j ] = temp;
				}
			}
		}
	}

	public void debug()
	{
		int[][] a = {};
		int[][] b =
		{
			{
				1
			},
		};
		int[][] c =
		{
				{
						1, 2
				},
				{
						3, 4
				}
		};
		int[][] d =
		{
				{
						1, 2, 3
				},
				{
						4, 5, 6
				},
				{
						7, 8, 9
				}
		};
		int[][] e =
		{
				{
						1, 2, 3, 4
				},
				{
						5, 6, 7, 8
				},
				{
						9, 10, 11, 12
				},
				{
						13, 14, 15, 16
				}
		};

		rotate( a );
		rotate( b );
		rotate( c );
		rotate( d );
		rotate( e );

		printMatrix( a );
		printMatrix( b );
		printMatrix( c );
		printMatrix( d );
		printMatrix( e );
	}

	private void printMatrix( int[][] matrix )
	{
		System.out.println( "Result:" );
		for ( int[] line : matrix )
		{
			for ( int i : line )
			{
				System.out.print( i + "\t" );
			}
			System.out.println();
		}
	}
}
