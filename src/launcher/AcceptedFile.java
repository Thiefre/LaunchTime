package launcher;

import java.io.File;

public enum AcceptedFile {
	ACCEPT,DECLINE;
	static String[] names = {"PerfLogs", "Users", "Windows", "Program Files", "Intel", "Logs", "Common Files", "data", "Data"
			
	};
	
	static String[] keyWords = {"Windows", "NVIDIA", "MSI", "Google", "AMD", "Microsoft", "Graphics", "config", "patch", "resource", "server",
			"graphics", "drivers", "DirectX", "sound", "music"
			
	};
	
	public static AcceptedFile isAccepted(File f)
	{
		for(String x : names)
		{
			if(f.getName().equalsIgnoreCase(x))
			{
				return DECLINE;
			}
		}
		for(String y : keyWords)
		{
			if(f.getName().toLowerCase().contains(y.toLowerCase()))
			{
				return DECLINE;
			}
		}
		return ACCEPT;
	}
}
