package priv.bss.gj.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import priv.bss.gj.db.DBUtil;

/**
 * @author wang.miansen
 * 2018年10月23日
 * 下午9:25:32
 * TODO
 */
public class JDBCUtil {
	
	private static void query(String sql, QueryVisiter visiter, Object... obj) {
		ResultSet set = null;
		PreparedStatement statement = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			statement = conn.prepareStatement(sql);
			for (int i = 1; i <= obj.length; i++) {
				statement.setObject(i, obj[i - 1]);
			}
			set = statement.executeQuery();
			visiter.handlerSet(set);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(set, statement, conn);
		}
	}

	public static List<Map<String,Object>> findAll(String sql,Object... args){
		final List<Map<String,Object>> list = new ArrayList<>();
		query(sql, new QueryVisiter() {
			@Override
			public void handlerSet(ResultSet set) throws SQLException {
				ResultSetMetaData metaData = set.getMetaData();
				int columnCount = metaData.getColumnCount();
				while(set.next()){
					Map<String,Object> map = new HashMap<>();
					for(int i = 1;i <= columnCount;i++){
						map.put(metaData.getColumnName(i), set.getObject(i));
					}
					list.add(map);
				}
			}
		}, args);
		return list;
	}
	
	public static List<MsTemp1008> findAll2OOP(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		List<MsTemp1008> list = new ArrayList<>();
		String sql = "select * from ms_temp_1008 ";
		try {
			conn = DBUtil.getConn();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				MsTemp1008 mst = new MsTemp1008();
				mst.setTableName(res.getString("TABLE_NAME"));
				mst.setOwner(res.getString("OWNER"));
				mst.setIsExists(res.getString("IS_EXISTS"));
				mst.setSqlName(res.getString("SEQ_NAME"));
				list.add(mst);
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(res, pre, conn);
		}
		return null;
	}
}
