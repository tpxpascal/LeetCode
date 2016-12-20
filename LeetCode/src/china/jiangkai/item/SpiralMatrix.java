package china.jiangkai.item;

import java.util.*;

public class SpiralMatrix
{
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;

	public List< Integer > spiralOrder( int[][] matrix )
	{
		List< Integer > result = new LinkedList< Integer >();

		if ( (matrix == null) || (matrix.length == 0) )
		{
			return result;
		}

		int row = matrix.length;
		int col = matrix[ 0 ].length;

		int total = row * col;

		int x = 0;
		int y = 0;
		int direction = RIGHT;
		int xmin = 0;
		int xmax = row - 1;
		int ymin = 0;
		int ymax = col - 1;
		result.add( matrix[ x ][ y ] );
		int count = 1;
		while ( count < total )
		{

			switch ( direction )
			{
			case RIGHT:
				y++;
				if ( y > ymax )
				{
					y--;
					direction = DOWN;
					xmin++;
				}
				else
				{
					result.add( matrix[ x ][ y ] );
					count++;
				}
				break;
			case DOWN:
				x++;
				if ( x > xmax )
				{
					x--;
					direction = LEFT;
					ymax--;
				}
				else
				{
					result.add( matrix[ x ][ y ] );
					count++;
				}
				break;
			case LEFT:
				y--;
				if ( y < ymin )
				{
					y++;
					direction = UP;
					xmax--;
				}
				else
				{
					result.add( matrix[ x ][ y ] );
					count++;
				}
				break;
			case UP:
				x--;
				if ( x < xmin )
				{
					x++;
					direction = RIGHT;
					ymin++;
				}
				else
				{
					result.add( matrix[ x ][ y ] );
					count++;
				}
				break;
			}
		}

		return result;
	}

	public void debug()
	{
		int[][] a = {};
		int[][] b =
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
		int[][] c =
		{
				{
						1, 2, 3
				},
				{
						4, 5, 6
				}
		};
		int[][] d =
		{
			{
					1, 2, 3
			}
		};
		int[][] e =
		{
				{
					1
				},
				{
					2
				},
				{
					3
				},
				{
					4
				}
		};

		printList( spiralOrder( a ) );
		printList( spiralOrder( b ) );
		printList( spiralOrder( c ) );
		printList( spiralOrder( d ) );
		printList( spiralOrder( e ) );
	}

	private void printList( List< Integer > list )
	{
		System.out.println( "Result" );
		for ( int i : list )
		{
			System.out.print( i + " " );
		}
		System.out.println();
	}
}
