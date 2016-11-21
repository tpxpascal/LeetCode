package china.jiangkai.item;

import java.util.*;

public class MergeKSortedLists
{
	public ListNode mergeKLists( ListNode[] lists )
	{
		ListNode head = null;
		ListNode index = null;
		ListNode insert = null;

		if ( (lists == null) || (lists.length == 0) )
		{
			return null;
		}

		LinkedList< ListNode > currList = new LinkedList< ListNode >();
		for ( int i = 0; i < lists.length; i++ )
		{
			if ( lists[ i ] != null )
			{
				currList.add( lists[ i ] );
			}
		}
		if ( currList.isEmpty() )
		{
			return null;
		}

		Collections.sort( currList, new NodeComparator() );

		head = currList.getFirst();

		while ( !currList.isEmpty() )
		{
			if ( index != null )
			{
				index.next = currList.getFirst();
			}
			index = currList.getFirst();

			currList.removeFirst();
			if ( index.next != null )
			{
				insert = index.next;
				int limit = currList.size();
				int value = insert.val;
				for ( int i = 0; i < limit; i++ )
				{
					if ( value <= currList.getFirst().val )
					{
						currList.addFirst( insert );
						break;
					}
					else
					{
						if ( value > currList.getLast().val )
						{
							currList.addLast( insert );
							break;
						}
						else
						{
							if ( (i < limit - 1)
									&& (value > currList.get( i ).val)
									&& (value <= currList.get( i + 1 ).val) )
							{
								currList.add( i + 1, insert );
								break;
							}
						}
					}
				}
			}
		}

		return head;
	}

	public void debug()
	{
		int[] a =
		{
				-1, 1,
		};
		int[] b =
		{
				-3, 1, 4,
		};
		int[] c =
		{
				-2, -1, 0, 2
		};
		int[] d =
		{
				11, 12, 13,
		};

		ListNode la = generateList( a );
		ListNode lb = generateList( b );
		ListNode lc = generateList( c );
		ListNode ld = generateList( d );

		printList( la );
		printList( lb );
		printList( lc );
		printList( ld );

		ListNode[] list1 =
		{
				la, lb, lc,
		};

		printList( mergeKLists( list1 ) );
	}

	private void printList( ListNode list )
	{
		ListNode index = list;
		while ( index != null )
		{
			System.out.print( index.val + " " );
			index = index.next;
		}
		System.out.println();
	}

	private ListNode generateList( int[] number )
	{
		ListNode result = null;
		ListNode end = null;
		for ( int i : number )
		{
			if ( result == null )
			{
				result = new ListNode( i );
				end = result;
			}
			else
			{
				end.next = new ListNode( i );
				end = end.next;
			}
		}
		return result;
	}

	class NodeComparator implements Comparator< ListNode >
	{
		@Override
		public int compare( ListNode a, ListNode b )
		{
			if ( a == null )
			{
				if ( b == null )
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}
			else
			{
				if ( b == null )
				{
					return -1;
				}
				else
				{
					return a.val - b.val;
				}
			}
		}
	}

	class ListNode
	{
		int val;
		ListNode next;

		ListNode( int x )
		{
			val = x;
		}
	}
}
