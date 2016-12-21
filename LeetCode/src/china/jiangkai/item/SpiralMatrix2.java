package china.jiangkai.item;

public class SpiralMatrix2
{
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;

	public int[][] generateMatrix( int n )
	{
		if ( n < 1 )
		{
			return new int[ 0 ][ 0 ];
		}

		int[][] result = new int[ n ][ n ];
		int total = n * n;

		int row = 0;
		int col = 0;
		int direction = RIGHT;
		int rowmin = 0;
		int rowmax = n - 1;
		int colmin = 0;
		int colmax = n - 1;

		result[ row ][ col ] = 1;
		for ( int i = 2; i <= total; i++ )
		{
			switch ( direction )
			{
			case RIGHT:
				col++;
				if ( col > colmax )
				{
					col--;
					row++;
					result[ row ][ col ] = i;
					direction = DOWN;
					rowmin++;
				}
				else
				{
					result[ row ][ col ] = i;
				}
				break;
			case DOWN:
				row++;
				if ( row > rowmax )
				{
					row--;
					col--;
					result[ row ][ col ] = i;
					direction = LEFT;
					colmax--;
				}
				else
				{
					result[ row ][ col ] = i;
				}
				break;
			case LEFT:
				col--;
				if ( col < colmin )
				{
					col++;
					row--;
					result[ row ][ col ] = i;
					direction = UP;
					rowmax--;
				}
				else
				{
					result[ row ][ col ] = i;
				}
				break;
			case UP:
				row--;
				if ( row < rowmin )
				{
					row++;
					col++;
					result[ row ][ col ] = i;
					direction = RIGHT;
					colmin++;
				}
				else
				{
					result[ row ][ col ] = i;
				}
				break;
			}
		}

		return result;
	}

	public void debug()
	{
		printMatrix( generateMatrix( 0 ) );
		printMatrix( generateMatrix( 2 ) );
		printMatrix( generateMatrix( 3 ) );
		printMatrix( generateMatrix( 4 ) );
		printMatrix( generateMatrix( 5 ) );
	}

	private void printMatrix( int[][] matrix )
	{
		System.out.println( "Result" );
		for ( int[] line : matrix )
		{
			for ( int i : line )
			{
				System.out.print( i + "," );
			}
			System.out.println();
		}
	}
}
