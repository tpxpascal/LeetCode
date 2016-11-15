package china.jiangkai.item;

import java.util.*;

public class GenerateParentheses
{
	public List< String > generateParenthesis( int n )
	{
		List< String > result = new LinkedList< String >();

		Node start = new Node();

		start.left = n;
		start.right = n;
		start.flag = 0;
		start.value = "";

		List< Node > list = start.generateNodes();
		while ( list.size() > 0 )
		{
			List< Node > temp = new LinkedList< Node >();

			for ( Node i : list )
			{
				if ( (i.left == 0) && (i.right == 0) )
				{
					result.add( i.value );
				}
				else
				{
					List< Node > curList = i.generateNodes();
					for ( Node j : curList )
					{
						temp.add( j );
					}
				}
			}

			list = temp;
		}

		return result;
	}

	public void debug()
	{
		int a = -1;
		int b = 0;
		int c = 3;
		int d = 5;

		printList( generateParenthesis( a ) );
		printList( generateParenthesis( b ) );
		printList( generateParenthesis( c ) );
		printList( generateParenthesis( d ) );
	}

	private void printList( List< String > list )
	{
		System.out.println( "List:" );
		for ( String i : list )
		{
			System.out.println( i );
		}
		System.out.println();
	}

	class Node
	{
		public String value = "";
		public int left = 0;
		public int right = 0;
		public int flag = 0;

		public List< Node > generateNodes()
		{
			List< Node > result = new LinkedList< Node >();
			Node n = null;

			if ( this.left >= 1 )
			{
				n = new Node();
				n.value = this.value + "(";
				n.left = this.left - 1;
				n.right = this.right;
				n.flag = this.flag + 1;
				result.add( n );
			}

			if ( (flag > 0) && (this.right >= 1) )
			{
				n = new Node();
				n.value = this.value + ")";
				n.left = this.left;
				n.right = this.right - 1;
				n.flag = this.flag - 1;
				result.add( n );
			}

			return result;
		}
	}
}
