package gameoflife.manger.cl;

public class Simulation extends Thread 
{	
    public boolean running;
    private CellButton[][] cells;

    public Simulation(CellButton[][] cells)
    {
        this.cells = cells;
    }

    private void simulateStep()
    {
        // Backup states
        boolean[][] states = new boolean[cells.length][cells.length];

        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells.length; j++)
            {
            	states[i][j] = cells[i][j].isLive;
            }
        }

        // Review rules for each cell
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells.length; j++)
            {
                CellButton cell = cells[i][j];
                int liveNeighborsCount = cell.countLiveNeighbors(states);

                if (cell.isLive == true)
                {
                    if (liveNeighborsCount == 2 || liveNeighborsCount == 3)
                    {
                        // Continue living
                    }
                    else
                    {
                        cell.kill();
                    }
                }
                else
                {
                    if (liveNeighborsCount == 3)
                    {
                        cell.born();
                    }

                }
            }
        }
    }
	
    @Override
    public void run()
    {
        while (running)
        {
            simulateStep();

            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
            	
            }
        }
    }

}
