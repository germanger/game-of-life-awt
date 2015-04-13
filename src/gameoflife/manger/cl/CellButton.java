package gameoflife.manger.cl;

import java.awt.*;

public class CellButton extends Button 
{
	private static final long serialVersionUID = 1L;
	
	public int row;
    public int column;
    public boolean isLive;

    public CellButton(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.isLive = false;
        
        kill();
    }
    
    public void kill()
    {
        this.isLive = false;
        this.setBackground(Color.white);
    }

    public void born()
    {
        this.isLive = true;
        this.setBackground(Color.blue);
    }

    public void toggle()
    {
        if (isLive) 
        {
        	kill();
        }
        else
    	{
        	born();
    	}
    }
    
    public int countLiveNeighbors(boolean[][] states)
    {
    	int count = 0;

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                int neighborRow = this.row + i;
                int neighborColumn = this.column + j;

                // The cell itself is not a neighbor
                if (i == 0 && j == 0) 
                {
                    continue;
                }

                // Border cases
                if ((neighborRow == -1) || (neighborRow == states.length) || (neighborColumn == -1) || (neighborColumn == states.length))
                {
                    continue;
                }

                // We've found a live neighbor
                if (states[neighborRow][neighborColumn])
                {
                	count++;
                }

            }
        }

        return count;
    }
}
