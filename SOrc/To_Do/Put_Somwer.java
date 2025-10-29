package To_Do;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Put_Somwer
{
	public static void Do_W_Evry_N(Method Do,Object[] List)throws InvocationTargetException,IllegalAccessException
	{
		int N=Do.getParameterCount();
		Object[] Rgg=new Object[N];
		for(int IndX=0;IndX<List.length;IndX+=N)
		{
			for(int Rg_IndX=0;Rg_IndX<N;Rg_IndX+=1)
			{Rgg[Rg_IndX]=List[IndX+Rg_IndX];}
			Do.invoke(Rgg);
		}
	}
}