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
			currList.add( lists[ i ] );
		}

		Collections.sort( currList, new NodeComparator() );

		head = currList.getFirst();
		index = head;

		while ( !isEmptyList( currList ) )
		{
			if ( index.next != null )
			{
				insert = index.next;
				int limit = currList.size();
				int value = insert.val;
				for ( int i = 0; i < limit - 1; i++ )
				{
					if ( value < currList.getFirst().val )
					{
						currList.addFirst( insert );

					}
					else
					{
						if ( value > currList.getLast().val )
						{
							currList.addLast( insert );

						}
						else
						{
							if ( (value > currList.get( i ).val)
									&& (value <= currList.get( i ).val) )
							{
								currList.add( i, insert );
							}
						}
					}
				}
				index.next = currList.getFirst();
				index = index.next;
			}
			else
			{
				currList.removeFirst();
				index.next = currList.getFirst();
				index = index.next;
			}
		}

		return head;
	}

	public void debug()
	{
		int[] a =
		{
				1, 3, 5, 7, 9,
		};
		int[] b =
		{
				2, 4, 6, 8, 10,
		};
		int[] c =
		{
				15, 16, 17, 18,
		};
		int[] d =
		{
				11, 12, 13,
		};

		ListNode la = generateList( a );
		ListNode lb = generateList( b );
		ListNode lc = generateList( c );
		ListNode ld = generateList( d );

		ListNode[] list1 =
		{
				la, lb, lc, ld
		};

		printList( mergeKLists( list1 ) );
	}

	private boolean isEmptyList( LinkedList< ListNode > list )
	{
		for ( ListNode i : list )
		{
			if ( i != null )
			{
				return false;
			}
		}
		return true;
	}

	private void printList( ListNode list )
	{
		ListNode index = list;
		while ( index != null )
		{
			System.out.print( index.val );
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
