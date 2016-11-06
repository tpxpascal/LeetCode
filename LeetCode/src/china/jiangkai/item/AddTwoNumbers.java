package china.jiangkai.item;

import java.math.*;

public class AddTwoNumbers
{
	public ListNode addTwoNumbers( ListNode l1, ListNode l2 )
	{
		ListNode result = null;
		ListNode end = null;

		ListNode a = l1;
		ListNode b = l2;

		int plus = 0;
		while ( a != null || b != null || plus != 0 )
		{
			int num1 = (a == null) ? 0 : a.val;
			int num2 = (b == null) ? 0 : b.val;

			int sum = num1 + num2 + plus;

			int value = sum % 10;
			plus = sum / 10;

			if ( result == null )
			{
				result = new ListNode( value );
				end = result;
			}
			else
			{
				end.next = new ListNode( value );
				end = end.next;
			}

			if ( a != null )
			{
				a = a.next;
			}
			if ( b != null )
			{
				b = b.next;
			}
		}

		return result;
	}

	public void debug()
	{
		int[] a =
		{
				1, 2, 6
		};
		int[] b =
		{
				8, 1
		};
		int[] c =
		{
				9, 6, 3
		};

		ListNode listA = generateList( a );
		ListNode listB = generateList( b );
		ListNode listC = generateList( c );

		printList( listA );
		printList( listB );
		printList( listC );

		// listA = changeList( listA );
		// listB = changeList( listB );
		// listC = changeList( listC );
		//
		// printList( listA );
		// printList( listB );
		// printList( listC );

		ListNode sum1 = addTwoNumbers( listA, listB );
		ListNode sum2 = addTwoNumbers( listB, listC );

		printList( sum1 );
		printList( sum2 );
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

	private ListNode changeList( ListNode list )
	{
		ListNode result = null;
		ListNode index = list;
		ListNode now = null;

		while ( index != null )
		{
			now = index;
			if ( index.next == null )
			{
				index.next = result;
				result = index;
				index = null;
			}
			else
			{
				index = index.next;
				now.next = result;
				result = now;
			}
		}

		return result;
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
