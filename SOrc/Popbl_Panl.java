import CC.COd.Finishd;

import CC.Bool.Trn.Onbl;
import CC.Bool.Trn.Flagd_On_Trnbl.Flagd_On_Trnbl_Imp;
import CC.Img.Mandlbrot;
import CC.Img.Trand_Img_Popr;
import CC.UI.Sig.Input_Com;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static CC.Img.Mandlbrot.Dfalt;
import static CC.List.ArA_X.Get_Last;
import static DDDTutorial_Modd.GUI.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Popbl_Panl
	extends JPanel implements Input_Com
{
	public Trand_Img_Popr Popr;
	public void paintComponent(Graphics Graphcs)
	{
		Popr.Mov(
			-KE_AccSr.Get_Unit(this,GD_Axis),
			+KE_AccSr.Get_Unit(this,RF_Axis));
		Popr.Zoom(KE_AccSr.Get_Unit(this,SpAc_B_Axis));

		BufferedImage Img=new BufferedImage(
			getWidth(),
			getHeight(),
			TYPE_INT_RGB);
		Popr.Pop(Img);
		Graphcs.drawImage(Img, 0, 0, null);

		repaint();
	}
	private Map<String,Onbl> Inputg=new HashMap<>();
		@Override @Finishd(Is_Finishd=true)
		public Map<String,Onbl> Get_On_Trnbl_List()
		{return Inputg;}

	public Popbl_Panl(Trand_Img_Popr Popr)
	{
		this.Popr=Popr;
		KE_AccSr.Set(this,VK_R,new Flagd_On_Trnbl_Imp());
		KE_AccSr.Set(this,VK_F,new Flagd_On_Trnbl_Imp());
		KE_AccSr.Set(this,VK_G,new Flagd_On_Trnbl_Imp());
		KE_AccSr.Set(this,VK_D,new Flagd_On_Trnbl_Imp());
		KE_AccSr.Set(this,VK_SPACE,new Flagd_On_Trnbl_Imp());
		KE_AccSr.Set(this,VK_B,new Flagd_On_Trnbl_Imp());
		Init();
	}

	public static void main(String[] args)
	{
		JFrame FrAm=new JFrame("Mandelbrot Set");
		Popbl_Panl panel=new Popbl_Panl(new Trand_Img_Popr(new Mandlbrot(500,Dfalt),
			1000,100,16,
			200,16));
		FrAm.add(panel);
		FrAm.setSize(800,800);
		FrAm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrAm.setVisible(true);
	}
}