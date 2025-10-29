package TSt;

import java.awt.*;

import static CC.List.BAs_ArA.*;

public class Pyramid extends ShAp{
	double rotation = Math.PI*0.75;
	@Override
	public int Rot_Ad_Num()
	{return 4;}
	double x1, x2, x3, x4, x5, y1, y2, y3, y4, y5;

	public Pyramid(double x, double y, double z, double width, double length, double height, Color c)
	{
		super(x,y,z,width,length,height,c);

		setRotAdd();
		updatePoly();
	}
	@Override
	public void Set_Polys()
	{
		Polys=new DPolygon[5];
		Polys[0] = new DPolygon(new double[]{x, x+width, x+width, x}, new double[]{y, y, y+length, y+length},  new double[]{z, z, z, z}, c, false);
		Screen.DPolygons.add(Polys[0]);
		Polys[1] = new DPolygon(new double[]{x, x, x+width}, new double[]{y, y, y, y},  new double[]{z, z+height, z+height}, c, false);
		Screen.DPolygons.add(Polys[1]);
		Polys[2] = new DPolygon(new double[]{x+width, x+width, x+width}, new double[]{y, y, y+length},  new double[]{z, z+height, z+height}, c, false);
		Screen.DPolygons.add(Polys[2]);
		Polys[3] = new DPolygon(new double[]{x, x, x+width}, new double[]{y+length, y+length, y+length},  new double[]{z, z+height, z+height}, c, false);
		Screen.DPolygons.add(Polys[3]);
		Polys[4] = new DPolygon(new double[]{x, x, x}, new double[]{y, y, y+length},  new double[]{z, z+height, z+height}, c, false);
		Screen.DPolygons.add(Polys[4]);
	}

	@Override
	public void setRotAdd()
	{
		angle = new double[6];
		
		double xdif = - width + 0.00001;
		double ydif = - length + 0.00001;
		
		angle[0] = Math.atan(ydif/xdif);
		
		if(xdif<0)
			angle[0] += Math.PI;
		
/////////
		xdif = width + 0.00001;
		ydif = - length + 0.00001;
		
		angle[1] = Math.atan(ydif/xdif);
		
		if(xdif<0)
			angle[1] += Math.PI;
/////////
		xdif = width + 0.00001;
		ydif = length + 0.00001;
		
		angle[2] = Math.atan(ydif/xdif);
		
		if(xdif<0)
			angle[2] += Math.PI;
		
/////////
		xdif = - width + 0.00001;
		ydif = length + 0.00001;
		
		angle[3] = Math.atan(ydif/xdif);
		
		if(xdif<0)
			angle[3] += Math.PI;		
		
		RotAdd[0] = angle[0] + 0.25 * Math.PI;
		RotAdd[1] =	angle[1] + 0.25 * Math.PI;
		RotAdd[2] = angle[2] + 0.25 * Math.PI;
		RotAdd[3] = angle[3] + 0.25 * Math.PI;
	}

	@Override
	public void UpdateDirection(double toX, double toY)
	{
		double xdif = toX - (x + width/2) + 0.00001;
		double ydif = toY - (y + length/2) + 0.00001;
		
		double anglet = Math.atan(ydif/xdif) + 0.75 * Math.PI;

		if(xdif<0)
			anglet += Math.PI;

		rotation = anglet;
		updatePoly();		
	}

	@Override
	public void updatePoly()
	{
		for(int i = 0; i < 5; i++)
		{
			Screen.DPolygons.add(Polys[i]);
			Screen.DPolygons.remove(Polys[i]);
		}
		
		double radius = Math.sqrt(width*width + length*length);
		
			   x1 = x+width*0.5+radius*0.5*Math.cos(rotation + RotAdd[0]);
			   x2 = x+width*0.5+radius*0.5*Math.cos(rotation + RotAdd[1]);
			   x3 = x+width*0.5+radius*0.5*Math.cos(rotation + RotAdd[2]);
			   x4 = x+width*0.5+radius*0.5*Math.cos(rotation + RotAdd[3]);
			   x5 = x+width*0.5;
			   
			   y1 = y+length*0.5+radius*0.5*Math.sin(rotation + RotAdd[0]);
			   y2 = y+length*0.5+radius*0.5*Math.sin(rotation + RotAdd[1]);
			   y3 = y+length*0.5+radius*0.5*Math.sin(rotation + RotAdd[2]);
			   y4 = y+length*0.5+radius*0.5*Math.sin(rotation + RotAdd[3]);
			   y5 = y+length*0.5;
   
		Polys[0].x =ABCD(x1, x2, x3, x4);
		Polys[0].y =ABCD(y1, y2, y3, y4);
		Polys[0].z =A4(z);
			   
		Polys[1].x = new double[]{x1, x5, x2};
		Polys[1].y = new double[]{y1, y5, y2};
		Polys[1].z = new double[]{z, z+height, z};

		Polys[2].x = ABC(x3, x2, x5);
		Polys[2].y = ABC(y3, y2, y5);
		Polys[2].z = ABC(z, z, z+height);

		Polys[3].x = new double[]{x3, x5, x4};
		Polys[3].y = new double[]{y3, y5, y4};
		Polys[3].z = new double[]{z, z+height, z};

		Polys[4].x = new double[]{x1, x4, x5};
		Polys[4].y = new double[]{y1, y4, y5};
		Polys[4].z = new double[]{z, z, z+height};
		
	}
}