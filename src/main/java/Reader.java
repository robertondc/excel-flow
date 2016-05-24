import java.util.List;
import java.util.Map;

import br.com.roberto.excelsql.model.Field;

public interface Reader {
	
	List<Row<Field<?>>> allRows();
	
}
