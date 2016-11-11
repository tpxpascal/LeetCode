package china.jiangkai.item;

public class IntegerToRoman
{
	public String intToRoman( int num )
	{
		StringBuilder result = new StringBuilder();

		String[][] base =
		{
				{
						"I", "V", "X"
				},
				{
						"X", "L", "C"
				},
				{
						"C", "D", "M"
				},
				{
						"M", "V*", "X*"
				}
		};

		int value = num;
		int count = 0;
		String[] list = new String[ 4 ];
		while ( value != 0 )
		{
			int curr = value % 10;
			StringBuilder temp = new StringBuilder();
			String[] level = base[ count ];
			switch ( curr )
			{
			case 1:
				temp.append( level[ 0 ] );
				break;
			case 2:
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				break;
			case 3:
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				break;
			case 4:
				temp.append( level[ 0 ] );
				temp.append( level[ 1 ] );
				break;
			case 5:
				temp.append( level[ 1 ] );
				break;
			case 6:
				temp.append( level[ 1 ] );
				temp.append( level[ 0 ] );
				break;
			case 7:
				temp.append( level[ 1 ] );
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				break;
			case 8:
				temp.append( level[ 1 ] );
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				temp.append( level[ 0 ] );
				break;
			case 9:
				temp.append( level[ 0 ] );
				temp.append( level[ 2 ] );
				break;
			default:
				break;

			}

			list[ 3 - count ] = temp.toString();
			value = value / 10;
			count++;
		}

		for ( String i : list )
		{
			if ( i != null )
			{
				result.append( i );
			}
		}

		return result.toString();
	}

	public void debug()
	{
		int a = 10;
		int b = 5;
		int c = 9;
		int d = 11;
		int e = 3999;

		System.out.println( intToRoman( a ) );
		System.out.println( intToRoman( b ) );
		System.out.println( intToRoman( c ) );
		System.out.println( intToRoman( d ) );
		System.out.println( intToRoman( e ) );
	}
}
