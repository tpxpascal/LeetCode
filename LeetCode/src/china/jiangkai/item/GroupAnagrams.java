package china.jiangkai.item;

import java.util.*;

public class GroupAnagrams
{
	public List< List< String >> groupAnagrams( String[] strs )
	{
		List< List< String >> result = new LinkedList< List< String >>();

		if ( (strs == null) || (strs.length == 0) )
		{
			return result;
		}

		HashMap< String, List< String >> data = new HashMap< String, List< String >>();
		for ( String i : strs )
		{
			if ( i == null )
			{
				continue;
			}

			String key = generateKey2( i );
			List< String > list = null;
			if ( (list = data.get( key )) == null )
			{
				LinkedList< String > item = new LinkedList< String >();
				item.add( i );
				data.put( key, item );
			}
			else
			{
				list.add( i );
			}
		}
		if ( data.size() > 0 )
		{
			result = new LinkedList< List< String >>( data.values() );
		}

		return result;
	}

	private String generateKey2( String word )
	{
		char[] list = word.toCharArray();
		Arrays.sort( list );
		return new String( list );
	}

	private String generateKey( String word )
	{
		StringBuilder result = new StringBuilder();

		HashMap< Character, Integer > key = new HashMap< Character, Integer >();
		for ( int i = 0; i < word.length(); i++ )
		{
			char c = word.charAt( i );
			if ( key.get( c ) == null )
			{
				key.put( c, 1 );
			}
			else
			{
				int val = key.get( c );
				val++;
				key.put( c, val );
			}
		}

		ArrayList< Character > keys = new ArrayList< Character >( key.keySet() );
		Collections.sort( keys );

		for ( char i : keys )
		{
			result.append( i );
			result.append( key.get( i ) );
		}

		return result.toString();
	}

	public void debug()
	{
		String[] a = {};
		String[] b =
		{
			"",
		};
		String[] c =
		{
				"abc", "cba", "ab"
		};
		String[] d =
		{
				"", ""
		};
		String[] e =
		{
				"eat", "tea", "tan", "ate", "nat", "bat"
		};

		print( groupAnagrams( a ) );
		print( groupAnagrams( b ) );
		print( groupAnagrams( c ) );
		print( groupAnagrams( d ) );
		print( groupAnagrams( e ) );
	}

	private void print( List< List< String >> data )
	{
		System.out.println( "Result:" );
		for ( List< String > list : data )
		{
			for ( String i : list )
			{
				System.out.print( i + " " );
			}
			System.out.println();
		}
	}
}
