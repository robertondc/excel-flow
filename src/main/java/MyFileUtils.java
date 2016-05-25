import java.io.File;
import java.net.URL;

public class MyFileUtils {

	public static File getResourceFile(String resourceName) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		File resourceFile = null;
		try {
			URL fileUrl = loader.getResource(resourceName);
			resourceFile = new File(fileUrl.getFile());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return resourceFile;
	}

}
