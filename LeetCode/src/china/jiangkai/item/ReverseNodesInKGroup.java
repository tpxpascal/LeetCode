package china.jiangkai.item;

public class ReverseNodesInKGroup
{
	public ListNode reverseKGroup( ListNode head, int k )
	{
		ListNode result = null;

		ListNode index = null;
		ListNode end = null;

		ListNode[] container = new ListNode[ k ];

		index = head;

		while ( index != null )
		{
			int i = 0;
			for ( i = 0; i < k; i++ )
			{
				if ( index != null )
				{
					container[ i ] = index;
					index = index.next;
				}
				else
				{
					break;
				}
			}

			if ( i != k )
			{
				if ( end == null )
				{
					result = container[ 0 ];
					break;
				}
				else
				{
					end.next = container[ 0 ];
					break;
				}
			}
			else
			{
				i--;
				if ( end == null )
				{
					end = container[ 0 ];
					index = container[ i ].next;
					result = container[ i ];
					for ( int j = i; j >= 1; j-- )
					{
						container[ j ].next = container[ j - 1 ];
					}
					container[ 0 ].next = null;
				}
				else
				{
					end.next = container[ i ];
					end = container[ 0 ];
					index = container[ i ].next;
					for ( int j = i; j >= 1; j-- )
					{
						container[ j ].next = container[ j - 1 ];
					}
					container[ 0 ].next = null;
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

		printList( reverseKGroup( la, 3 ) );
		printList( reverseKGroup( lb, 2 ) );
		printList( reverseKGroup( lc, 3 ) );
		printList( reverseKGroup( ld, 4 ) );
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
