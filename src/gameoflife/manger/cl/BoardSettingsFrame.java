package gameoflife.manger.cl;

import java.awt.*;
import java.awt.event.*;

public class BoardSettingsFrame extends Frame 
{
	private static final long serialVersionUID = 1L;
	
	public TextField rowsTextField;
    public Button createButton;
    public int rows;

    public BoardSettingsFrame()
    {
        setTitle("Board size");
        setSize(300, 120);
        setLayout(new BorderLayout(10,5));

        // Make the frame closeable
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

        rowsTextField = new TextField("12", 3);
        add(rowsTextField, BorderLayout.NORTH);

        createButton = new Button("Create");

        createButton.addActionListener(new ActionListener() 
        {
        	@Override
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    rows = Integer.parseInt(rowsTextField.getText());

                    if (rows >= 4 && rows <= 200)
                    {
                        BoardFrame boardFrame = new BoardFrame(rows);
                        boardFrame.setVisible(true);

                        setVisible(false);
                    }
                }
                catch (Exception e)
                {
                }
            }
        });
        
        add(createButton, BorderLayout.CENTER);
    }

}
