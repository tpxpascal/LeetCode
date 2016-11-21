package china.jiangkai.item;

public class SwapNodesInPairs
{
	public ListNode swapPairs( ListNode head )
	{
		ListNode result = null;

		ListNode index = head;
		ListNode end = null;
		ListNode temp = null;

		while ( index != null )
		{
			if ( index.next == null )
			{
				if ( end != null )
				{
					end.next = index;
					break;
				}
				else
				{
					result = index;
					break;
				}
			}
			else
			{
				if ( result == null )
				{
					result = index.next;
					end = index;
					temp = index.next.next;
					index.next.next = index;
					index.next = null;
					index = temp;
				}
				else
				{
					end.next = index.next;
					end = index;
					temp = index.next.next;
					index.next.next = index;
					index.next = null;
					index = temp;
				}

			}
		}

		return result;
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
				1, 2, 3, 4, 5,
		};

		ListNode la = generateList( a );
		ListNode lb = generateList( b );
		ListNode lc = generateList( c );
		ListNode ld = generateList( d );

		printList( swapPairs( la ) );
		printList( swapPairs( lb ) );
		printList( swapPairs( lc ) );
		printList( swapPairs( ld ) );
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
