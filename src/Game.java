class Place
{
	int row, col;
};

public class Game {
	public static int MAX = 81;
	public static void main(String[] args) {
		char[][] grid = { 
				{'-','-','-','-','-','-','4','6','-'},
				{'-','-','-','-','-','3','-','-','9'},
				{'-','8','4','-','-','7','-','-','1'},
				{'2','-','-','-','-','-','7','1','-'},
				{'5','-','3','8','-','-','-','-','-'},
				{'9','-','-','1','-','-','5','3','-'},
				{'-','2','5','-','-','8','-','-','6'},
				{'-','-','-','-','-','2','9','8','5'},
				{'-','-','-','-','-','5','-','-','7'},
		};
		Place []emptyPlaces = new Place[81];
		for ( int i = 0; i < emptyPlaces.length;i++)
		{
			emptyPlaces[i] = new Place();
		}
		int k = findEmpty(grid, emptyPlaces);
		System.out.print("The question is: \n");
		printOut(grid);
		if(Solve(grid, emptyPlaces,0,k))
		{
			System.out.print("The solution is: \n");
			printOut(grid);
		}
		else
		{
			System.out.print("There is no solution. Sorry! \n");
		}
	}
	
	public static void printOut(char grid[][])
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(grid[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	public static int findEmpty(char grid[][], Place places[])
	{
		int k = 0;
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(grid[i][j] == '-')
				{
					places[k].row = i;
					places[k].col = j;
					k++;
				}
			}
		}
		return k;
	}
    public static boolean Solve(char grid[][], Place places[], int tries, int index)
    {
    	char a;
    	if(tries == index)
    	{
    		return true;
    	}
    	for(a = '1'; a <= '9'; a++)
    	{
    	      if( isValid( grid, a, places[tries].row, places[tries].col ) )
    	      {
    	         grid[places[tries].row][places[tries].col] = a;
    	         if( Solve( grid, places, tries+1, index ) == true )
    	         {
    	            return true;
    	         }
    	         grid[places[tries].row][places[tries].col] = '-';
    	      }

    	}
    	return false;
    }
    public static boolean isValid(char grid[][], char value, int row, int col)
    {
    	int i, j, r, c;
    	// check row
    	for(i = 0; i < 9 ; i++ )
    	{
    		if(grid[row][i] == value)
    			return false;
    	}
    	for(i = 0; i < 9 ; i++ )
    	{
    		if(grid[i][col] == value)
    			return false;
    	}
    	r = row/3;
    	c = col/3;
    	for(i = r*3; i < r*3+3; i++)
    	{
    		for(j = c*3; j < c*3+3; j++)
    		{
    			if(grid[i][j] == value)
    				return false;
    		}
    	}
    	return true;
    }
}
