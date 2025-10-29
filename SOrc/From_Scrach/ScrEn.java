package From_Scrach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScrEn extends JPanel implements //Spac_Havr,
	KeyListener,
	MouseListener,
	MouseMotionListener,
	MouseWheelListener
{
	public ScrEn(SpAc SpAc){}

	@Override
	public void paintComponent(Graphics Graphcs)
	{
		Graphcs.setColor(new Color(140,180,180));
		Graphcs.fillRect(0,0,
				getWidth(),
				getHeight()
		);
	}

	@Override
	public void keyTyped(KeyEvent EvNt){}
	@Override
	public void keyPressed(KeyEvent EvNt){}
	@Override
	public void keyReleased(KeyEvent EvNt){}
	@Override
	public void mouseClicked(MouseEvent EvNt){}
	@Override
	public void mousePressed(MouseEvent EvNt){}
	@Override
	public void mouseReleased(MouseEvent EvNt){}
	@Override
	public void mouseEntered(MouseEvent EvNt){}
	@Override
	public void mouseExited(MouseEvent EvNt){}
	@Override
	public void mouseDragged(MouseEvent EvNt){}
	@Override
	public void mouseMoved(MouseEvent EvNt){}
	@Override
	public void mouseWheelMoved(MouseWheelEvent EvNt){}
}