package CC;
/*
import CC.Encycloped.Abs.Org.Comput.Soft.Ling.Java.X.F.Finishd;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class MpT_Meth_Findr
{
	@Finishd(Is_Finishd=false)
	public static void findJavaFiles(File folder,List<File> List)
	{
		if(folder.isDirectory())
		{
			File[] files=folder.listFiles();
			if(files!=null)
			{
				for(File file:files)
				{
					if(file.isDirectory())
					{findJavaFiles(file,List);}
					else if(file.getName().endsWith(".java"))
					{List.add(file);}
				}
			}
		}
	}
	@Finishd(Is_Finishd=false)
	public static void Find_Rongly_MpT_Methg(File Foldr)throws Exception
	{
		out.println("Searching for unallowed empty functions");

		List<File> javaFiles=new ArrayList<>();
		findJavaFiles(Foldr,javaFiles);

		for(File file:javaFiles)
		{
			SourceRoot sourceRoot=new SourceRoot(Paths.get(file.getParent()));
			List<ParseResult<CompilationUnit>> Unitg=sourceRoot.tryToParse("");
//			out.println("Parse done");

			for(ParseResult<CompilationUnit> Unit:Unitg)
			{
				Unit.ifSuccessful((compilationUnit)->{
//					out.println("Parse successful");

					compilationUnit.accept(new EmptyMethodVisitor(),file);
				});
			}
		}
		out.println("Units processed");
	}

	public static class EmptyMethodVisitor
		extends VoidVisitorAdapter<File>
	{
		@Override
		public void visit(MethodDeclaration Meth,File FIl)
		{
			super.visit(Meth,FIl);

			boolean Is_MpT_Meth=Meth.getBody().isPresent()&&Meth.getBody().get().isEmpty();
			boolean Has_AnOt=Meth.getAnnotations().stream()
				.anyMatch(annotation->annotation.getName().asString().equals("Shud_B_MpT"));

			if(Is_MpT_Meth&&!Has_AnOt)
			{out.println("File: "+FIl.getPath()+":"+Meth.getBegin().get());}
		}
	}
}*/