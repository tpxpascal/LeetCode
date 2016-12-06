package china.jiangkai.item;

public class CountAndSay
{
	public String countAndSay( int n )
	{
		if ( n < 1 )
		{
			return "";
		}

		String start = "1";

		for ( int i = 1; i < n; i++ )
		{
			StringBuilder temp = new StringBuilder();
			int limit = start.length();
			char curr = 0;
			int count = 0;
			for ( int index = 0; index < limit; index++ )
			{
				char p = start.charAt( index );
				if ( p != curr )
				{
					if ( count != 0 )
					{
						temp.append( count );
						temp.append( curr );
					}
					curr = p;
					count = 1;
				}
				else
				{
					count++;
				}
			}
			if ( count != 0 )
			{
				temp.append( count );
				temp.append( curr );
			}

			start = temp.toString();
		}

		return start;
	}

	public void debug()
	{
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;
		int e = 5;

		System.out.println( countAndSay( a ) );
		System.out.println( countAndSay( b ) );
		System.out.println( countAndSay( c ) );
		System.out.println( countAndSay( d ) );
		System.out.println( countAndSay( e ) );
	}
}
