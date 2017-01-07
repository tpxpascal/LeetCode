package china.jiangkai.item;

public class ValidNumber
{
	public boolean isNumber( String s )
	{
		try
		{
			String word = s.trim();
			if( word.length() < 1 )
			{
				return false;
			}
			Double.parseDouble( word );
			char end = word.charAt( word.length() - 1 );
			if ( ((end < '0' || end > '9')) && (end != '.') )
			{
				return false;
			}
			return true;
		}
		catch ( NumberFormatException e )
		{
			return false;
		}
	}

	public void debug()
	{
		System.out.println( isNumber( "3." ) );
	}
}
