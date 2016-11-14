package china.jiangkai.item;

public class MergeTwoSortedLists
{
	public ListNode mergeTwoLists( ListNode l1, ListNode l2 )
	{
		ListNode head = null;

		ListNode big = null;
		ListNode small = null;
		ListNode index = null;
		ListNode tmp = null;

		if ( l1 == null )
		{
			if ( l2 == null )
			{
				return null;
			}
			else
			{
				return l2;
			}
		}
		else
		{
			if ( l2 == null )
			{
				return l1;
			}
		}

		if ( l1.val <= l2.val )
		{
			small = l1;
			big = l2;
		}
		else
		{
			big = l1;
			small = l2;
		}
		head = small;
		index = head;
		while ( (small != null) && (big != null) )
		{
			if ( small.next != null )
			{
				if ( small.next.val <= big.val )
				{
					small = small.next;
					index.next = small;
					index = index.next;
				}
				else
				{
					tmp = big;
					big = small.next;
					small = tmp;
					index.next = small;
					index = index.next;
				}
			}
			else
			{
				index.next = big;
				break;
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
				5, 6, 7, 8, 9,
		};
		int[] d =
		{
				1, 2, 3,
		};

		printList( mergeTwoLists( generateList( a ), generateList( b ) ) );
		printList( mergeTwoLists( generateList( c ), generateList( d ) ) );
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
