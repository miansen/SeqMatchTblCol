package priv.bss.gj.test;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryVisiter {

	void handlerSet(ResultSet set) throws SQLException;
}
