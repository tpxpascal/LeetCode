package china.jiangkai.item;

import java.util.*;

public class MergeInterval
{
	public List< Interval > merge( List< Interval > intervals )
	{
		LinkedList< Interval > result = new LinkedList< Interval >();

		if ( intervals == null )
		{
			return result;
		}

		for ( Interval i : intervals )
		{
			int count = result.size();
			if ( count == 0 )
			{
				result.add( i );
			}
			else
			{
				Interval combine = null;
				Interval tmp = i;
				for ( int k = 0; k < count; k++ )
				{
					if ( result.size() == 0 )
					{
						break;
					}
					Interval base = result.getLast();
					result.removeLast();
					combine = mergeTwo( base, tmp );
					if ( combine == null )
					{
						result.addFirst( base );
						if ( k == count - 1 )
						{
							result.addFirst( tmp );
						}
					}
					else
					{
						tmp = combine;
					}
				}
				if ( combine != null )
				{
					result.add( combine );
				}
			}
		}

		return result;
	}

	public Interval mergeTwo( Interval a, Interval b )
	{
		if ( (a.end < b.start) || (b.end < a.start) )
		{
			return null;
		}
		else
		{
			if ( (a.start <= b.start) && (a.end >= b.end) )
			{
				return a;
			}
			else
			{
				if ( (b.start <= a.start) && (b.end >= a.end) )
				{
					return b;
				}
				else
				{
					Interval combine = new Interval();
					combine.start = (a.start < b.start) ? a.start : b.start;
					combine.end = (a.end > b.end) ? a.end : b.end;
					return combine;
				}
			}
		}
	}

	public void debug()
	{
		Interval a = new Interval( 2, 3 );
		Interval b = new Interval( 5, 5 );
		Interval c = new Interval( 2, 2 );
		Interval d = new Interval( 3, 4 );
		Interval e = new Interval( 3, 4 );

		// System.out.println( mergeTwo( a, b ) );
		// System.out.println( mergeTwo( b, c ) );
		// System.out.println( mergeTwo( b, d ) );
		// System.out.println( mergeTwo( b, e ) );

		List< Interval > l1 = new LinkedList< Interval >();
		List< Interval > l2 = new LinkedList< Interval >();

		l1.add( a );
		l1.add( b );
		l1.add( c );
		l1.add( d );
		l1.add( e );

		printList( merge( l1 ) );
		printList( merge( l2 ) );
	}

	private void printList( List< Interval > list )
	{
		System.out.println( "Result" );
		for ( Interval i : list )
		{
			System.out.println( i );
		}
	}

	class Interval
	{
		int start;
		int end;

		Interval()
		{
			start = 0;
			end = 0;
		}

		Interval( int s, int e )
		{
			start = s;
			end = e;
		}

		@Override
		public String toString()
		{
			StringBuilder result = new StringBuilder();

			result.append( start + "-" + end );

			return result.toString();
		}
	}
}
