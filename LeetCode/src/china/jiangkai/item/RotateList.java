package china.jiangkai.item;

public class RotateList
{
	public ListNode rotateRight( ListNode head, int k )
	{
		ListNode result = null;

		if ( (k == 0) || (head == null) || (head.next == null) )
		{
			return head;
		}

		ListNode index = null;
		ListNode end = null;
		int count = 0;
		int length = 1;

		index = head;
		while ( index.next != null )
		{
			index = index.next;
			length++;
		}

		int size = k % length;
		if ( size == 0 )
		{
			return head;
		}

		index = head;
		while ( index.next != null )
		{
			if ( (end == null) && (count == size) )
			{
				end = head;
			}

			index = index.next;
			if ( end != null )
			{
				end = end.next;
			}
			else
			{
				count++;
			}
		}

		if ( (end == null) && (count == size) )
		{
			end = head;
		}

		result = end.next;
		end.next = null;
		index.next = head;

		return result;
	}

	public void debug()
	{
		int[] a =
		{
			1
		};
		int[] b =
		{
				1, 2
		};
		int[] c =
		{
				1, 2, 3
		};
		int[] d =
		{
				1, 2, 3, 4, 5
		};

		ListNode l1 = generateList( a );
		ListNode l2 = generateList( b );
		ListNode l3 = generateList( c );
		ListNode l4 = generateList( d );

		printList( rotateRight( l1, 0 ) );
		printList( rotateRight( l2, 3 ) );
		printList( rotateRight( l3, 5 ) );
		printList( rotateRight( l4, 7 ) );
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
