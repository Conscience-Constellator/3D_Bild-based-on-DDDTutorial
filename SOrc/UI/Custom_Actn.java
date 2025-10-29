package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Custom_Actn extends AbstractAction
{
	private Runnable Actn;
		@Override
		public void actionPerformed(ActionEvent EvNt)
		{Actn.run();}

	public Custom_Actn(Runnable Actn,String TXt)
	{
		super(TXt);
		this.Actn=Actn;
	}
}