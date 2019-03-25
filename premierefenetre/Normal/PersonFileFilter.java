package premierefenetre.Normal;

import org.apache.commons.io.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class PersonFileFilter extends FileFilter {
	public boolean accept(File file)
	{
		if(file.isDirectory())
			return true;
		
		int index = file.getName().lastIndexOf("."); //localise le point d'extension
		if(index!=(-1) || index!=(file.getName().length()-1)) //s'il existe et n'est pas en derniere position
		{
			String name = FilenameUtils.getExtension(file.getName()); //recupere l'extension
			
			if (	
					name.equals("per") || 
					name.equals("tiff") ||
					name.equals("tif") ||
					name.equals("gif") ||
					name.equals("jpeg") ||
					name.equals("jpg") ||
					name.equals("png")
				)
                return true;
		}
		return false;
	}
	public String getDescription() 
	{
		return "per | tiff | tif | gif | jpeg | jpg | png files";
	}	
	
}
