package china.jiangkai.item;

public class ValidSudoku
{
	public boolean isValidSudoku( char[][] board )
	{
		boolean result = true;

		if ( (board == null) || (board.length != 9) )
		{
			return false;
		}

		int[][][] blocks = new int[ 3 ][ 3 ][ 9 ];

		for ( int i = 0; i < 9; i++ )
		{
			int[] line = new int[ 9 ];
			int[] row = new int[ 9 ];
			if ( board[ i ].length != 9 )
			{
				return false;
			}
			for ( int j = 0; j < 9; j++ )
			{
				char val = board[ i ][ j ];
				int index = val - '1';
				if ( val != '.' )
				{
					if ( (val >= '0') && (val <= '9') )
					{
						if ( line[ index ] != 0 )
						{
							return false;
						}
						else
						{
							line[ index ] = 1;
						}

						int x = i / 3;
						int y = j / 3;
						if ( blocks[ x ][ y ][ index ] != 0 )
						{
							return false;
						}
						else
						{
							blocks[ x ][ y ][ index ] = 1;
						}
					}
					else
					{
						return false;
					}
				}

				val = board[ j ][ i ];
				index = val - '1';
				if ( val != '.' )
				{
					if ( (val >= '0') && (val <= '9') )
					{
						if ( row[ index ] != 0 )
						{
							return false;
						}
						else
						{
							row[ index ] = 1;
						}
					}
					else
					{
						return false;
					}
				}
			}
		}

		return result;
	}

	public void debug()
	{
		char[][] a =
		{
			{}
		};
		char[][] b =
		{
				{
						'5', '3', '.', '.', '7', '.', '.', '.', '.',
				},
				{
						'6', '.', '.', '1', '9', '5', '.', '.', '.',
				},
				{
						'.', '9', '8', '.', '.', '.', '.', '6', '.',
				},
				{
						'8', '.', '.', '.', '6', '.', '.', '.', '3',
				},
				{
						'4', '.', '.', '8', '.', '3', '.', '.', '1',
				},
				{
						'7', '.', '.', '.', '2', '.', '.', '.', '6',
				},
				{
						'.', '6', '.', '.', '.', '.', '2', '8', '.',
				},
				{
						'.', '.', '.', '4', '1', '9', '.', '.', '5',
				},
				{
						'.', '.', '.', '.', '8', '.', '.', '7', '9',
				},
		};
		char[][] c =
		{
				{
						'.', '8', '7', '6', '5', '4', '3', '2', '1',
				},
				{
						'2', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'3', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'4', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'5', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'6', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'7', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'8', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'9', '.', '.', '.', '.', '.', '.', '.', '.',
				},
		};
		char[][] d =
		{
				{
						'.', '.', '3', '3', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
		};
		char[][] e =
		{
				{
						'.', '3', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'3', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '.', '.',
				},
		};

		System.out.println( isValidSudoku( a ) );
		System.out.println( isValidSudoku( b ) );
		System.out.println( isValidSudoku( c ) );
		System.out.println( isValidSudoku( d ) );
		System.out.println( isValidSudoku( e ) );
	}
}
