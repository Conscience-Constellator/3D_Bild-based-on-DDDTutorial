package MAn;

public class Voxl
{
	public static byte[][][]
		Dfalt_IDg=
			(true)?new byte[16][16][16]:
			new byte[][][]
			{
				{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}},
				{{1,1,1,1},{0,1,1,0},{1,1,1,1},{1,1,1,1}},
				{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}},
				{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}},
			},
			Smal=new byte[][][]
				{
					{{2,2},{2,2}},
					{{1,2},{2,127}},
				},
			Singl=new byte[][][]
			{{{2}}}
		;
		static
		{
			for(int Z=6;Z<Dfalt_IDg.length-6;Z+=1)
			{
				for(int Y=6;Y<Dfalt_IDg[0].length-6;Y+=1)
				{
					for(int X=6;X<Dfalt_IDg[0][0].length-6;X+=1)
					{Dfalt_IDg[Z][Y][X]=1;}
				}
			}
		}
			public static byte[][][] CoP_IDg(byte[][][] IDg)
			{
				int
					X_LNg=IDg[0][0].length,
					Y_LNg=IDg[0].length,
					Z_LNg=IDg.length;
				byte[][][] CoP=new byte
					[Z_LNg]
					[Y_LNg]
					[X_LNg];
				for(int Z=0;Z<Z_LNg;Z+=1)
				{
					for(int Y=0;Y<Y_LNg;Y+=1)
					{
						for(int X=0;X<X_LNg;X+=1)
						{CoP[Z][Y][X]=IDg[Z][Y][X];}
					}
				}

				return CoP;
			}
			public static byte[][][] Get_IDg()
			{return CoP_IDg(Smal);}
}