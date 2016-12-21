package china.jiangkai.item;

import java.util.*;

public class InsertInterval
{
	public List< Interval > insert( List< Interval > intervals,
			Interval newInterval )
	{
		LinkedList< Interval > result = new LinkedList< Interval >();

		if ( newInterval == null )
		{
			return intervals;
		}

		if ( intervals == null || intervals.size() == 0 )
		{
			result.add( newInterval );
			return result;
		}

		Interval combine = null;
		Interval tmp = newInterval;

		int flag = 0;
		int count = 0;
		int big = 1;
		int limit = intervals.size() - 1;
		for ( Interval i : intervals )
		{
			combine = mergeTwo( i, tmp );
			if ( combine == null )
			{
				if ( (big != 0) && (i.start > tmp.start) )
				{
					result.add( tmp );
					big = 0;
				}
				else
				{
					if ( flag == 1 )
					{
						result.add( tmp );
						tmp = null;
						flag = 0;
						big = 0;
					}
				}
				result.add( i );
				if ( (count == limit) && (tmp != null) && (big != 0) )
				{
					result.add( tmp );
				}
			}
			else
			{
				tmp = combine;
				flag = 1;
				big = 0;
				if ( (count == limit) && (tmp != null) )
				{
					result.add( tmp );
				}
			}

			count++;
		}

		return result;
	}

	public Interval mergeTwo( Interval a, Interval b )
	{
		if ( (a == null) || (b == null) )
		{
			return null;
		}

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
		Interval a = new Interval( 2, 4 );
		Interval b = new Interval( 5, 7 );
		Interval c = new Interval( 8, 10 );
		Interval d = new Interval( 11, 13 );
		Interval e = new Interval( 3, 6 );

		List< Interval > l1 = new LinkedList< Interval >();
		List< Interval > l2 = new LinkedList< Interval >();

		l1.add( a );
		l1.add( b );
		l1.add( c );
		l1.add( d );

		l2.add( a );

		printList( insert( l1, e ) );
		printList( insert( l2, b ) );
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
