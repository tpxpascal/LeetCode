package china.jiangkai.item;

public class RemoveNthNode
{
	public ListNode removeNthFromEnd( ListNode head, int n )
	{
		ListNode prev = null;
		ListNode index = null;
		ListNode curr = head;

		int i = 0;
		while ( curr != null )
		{
			i++;
			if ( i == n )
			{
				index = head;
			}
			if ( i == n + 1 )
			{
				prev = head;
			}

			curr = curr.next;
			if ( index != null && curr != null )
			{
				index = index.next;
			}
			if ( prev != null && curr != null )
			{
				prev = prev.next;
			}
		}

		if ( index == head )
		{
			return index.next;
		}
		else
		{
			prev.next = index.next;
		}

		return head;
	}

	public void debug()
	{
		int[] a =
		{
				1, 2, 3, 4, 5,
		};
		int[] b =
		{
				1, 2, 3, 4, 5,
		};
		int[] c =
		{
				1, 2, 3,
		};
		int[] d =
		{
				1, 2, 3, 4,
		};

		printList( removeNthFromEnd( generateList( a ), 2 ) );
		printList( removeNthFromEnd( generateList( b ), 1 ) );
		printList( removeNthFromEnd( generateList( c ), 3 ) );
		printList( removeNthFromEnd( generateList( d ), 4 ) );
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
