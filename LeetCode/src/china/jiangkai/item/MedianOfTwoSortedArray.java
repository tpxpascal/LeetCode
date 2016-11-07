package china.jiangkai.item;

public class MedianOfTwoSortedArray
{
	public double findMedianSortedArrays( int[] nums1, int[] nums2 )
	{
		double result = 0;

		int flag = ((nums1.length + nums2.length) % 2 == 0) ? 0 : 1;
		int limit = (nums1.length + nums2.length) / 2 + 1;

		int count = 0;
		int a = 0;
		int b = 0;
		int[] merge = new int[ limit ];
		while ( count < limit )
		{
			if ( ((a >= nums1.length) && (b < nums2.length))
					|| ((a < nums1.length) && (b < nums2.length) && (nums1[ a ] >= nums2[ b ])) )
			{
				merge[ count ] = nums2[ b ];
				b++;
			}
			else
			{
				if ( ((b >= nums2.length) && (a < nums1.length))
						|| ((a < nums1.length) && (b < nums2.length) && (nums1[ a ] < nums2[ b ])) )
				{
					merge[ count ] = nums1[ a ];
					a++;
				}
			}
			count++;
		}

		result = (flag == 0) ? ((merge[ limit - 2 ] + merge[ limit - 1 ]) / 2.0d)
				: (merge[ limit - 1 ]);

		return result;
	}

	public double findMedianSortedArraysFast( int[] nums1, int[] nums2 )
	{
		double result = 0;

		return result;
	}

	public void debug()
	{
		int[] a =
		{
				1, 2, 3, 4,
		};
		int[] b =
		{
				6, 7, 8,
		};
		int[] c =
		{
				9, 10, 11,
		};
		int[] d =
		{
				6, 9, 11, 13,
		};

		System.out.println( findMedianSortedArrays( a, b ) );
		System.out.println( findMedianSortedArrays( b, c ) );
		System.out.println( findMedianSortedArrays( c, d ) );
		System.out.println( findMedianSortedArrays( d, a ) );
	}
}
