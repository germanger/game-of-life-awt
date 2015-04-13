package gameoflife.manger.cl;

import java.awt.*;
import java.awt.event.*;

public class BoardFrame extends Frame 
{
	private static final long serialVersionUID = 1L;
	
	private Panel cellsPanel;
    private Panel buttonsPanel;
    public int rows;
    private CellButton[][] cells;
    private Simulation simulation;
    
    private Button startButton;
    private Button pauseButton;
    private Button clearButton;

    public BoardFrame(int rows)
    {
        this.rows = rows;

        setTitle ("Game of Life");
        setSize (500, 500);
        setLayout(new BorderLayout());

        // Make the frame closeable
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

        // Panels
        cellsPanel = new Panel();
        cellsPanel.setLayout(new GridLayout(rows, rows));

        // Create cells
        cells = new CellButton[rows][rows];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                CellButton cell = new CellButton(i, j);
                               
                cell.addActionListener(new ActionListener() 
                {               	
                	@Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                		CellButton source = (CellButton) actionEvent.getSource();
                		source.toggle();
                    }
                });

                cells[i][j] = cell;

                cellsPanel.add(cell);
            }
        }

        buttonsPanel = new Panel();

        add(cellsPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);


        // Buttons
        startButton = new Button("Run");
        pauseButton = new Button("Pause");
        clearButton = new Button("Clear (\"kill all\")");
        
        pauseButton.setEnabled(false);

        buttonsPanel.add(startButton);
        buttonsPanel.add(pauseButton);
        buttonsPanel.add(clearButton);

        // Listeners
        startButton.addActionListener(new ActionListener() 
		{
        	@Override
            public void actionPerformed(ActionEvent actionEvent)
            {
        		simulation = new Simulation(cells);

                simulation.running = true;
                simulation.start();
                
        		startButton.setEnabled(false);
        		pauseButton.setEnabled(true);
            }
		});
        
        pauseButton.addActionListener(new ActionListener() 
		{
        	@Override
            public void actionPerformed(ActionEvent actionEvent)
            {
        		simulation.running = false;
        		
        		startButton.setEnabled(true);
        		pauseButton.setEnabled(false);
            }
		});
        
        clearButton.addActionListener(new ActionListener() 
		{
        	@Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < rows; j++)
                    {
                        cells[i][j].kill();
                    }
                }
            }
		});
    }

}
