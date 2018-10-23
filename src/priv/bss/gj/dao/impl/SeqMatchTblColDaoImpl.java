package priv.bss.gj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import priv.bss.gj.dao.SeqMatchTblColDao;
import priv.bss.gj.db.DBUtil;
import priv.bss.gj.entity.SeqMatchTblCol;
import priv.bss.gj.test.MsTemp1008;

/**
 * @author wang.miansen
 * 2018年10月23日
 * 下午4:15:26
 * TODO
 */
public class SeqMatchTblColDaoImpl implements SeqMatchTblColDao{

	/**
	 * 查询所有的序列
	 */
	@Override
	public List<SeqMatchTblCol> findAll() {
		
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		List<SeqMatchTblCol> list = new ArrayList<>();
		
		String sql = "select * from seq_match_tbl_col ";
		try {
			conn = DBUtil.getConn();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				SeqMatchTblCol ms = new SeqMatchTblCol();
				ms.setSeqName(res.getString("SEQ_NAME"));
				ms.setTableName(res.getString("TABLE_NAME"));
				ms.setExists(res.getBoolean("IS_EXISTS"));
				ms.setOwner(res.getString("OWNER"));
				ms.setColumnName(res.getString("COLUMN_NAME"));
				ms.setRemark(res.getString("REMARK"));
				list.add(ms);
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(res, pre, conn);
		}
		return null;
	}

	/**
	 * 查询表是否存在
	 * owner:用户名
	 * tableName:表名
	 */
	@Override
	public int countTbl(String owner, String tableName) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		int count = 0;
		String sql = "select count(1) from all_tables a where a.TABLE_NAME = '"+tableName+"' and a.OWNER = '"+owner+"' ";
		try {
			conn = DBUtil.getConn();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				count = res.getInt("COUNT(1)");
			}
			return count;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(res, pre, conn);
		}
		return count;
	}

	/**
	 * 更新配置表的信息
	 * tableName:表名
	 * columnName:字段名
	 * seqName:序列名
	 */
	@Override
	public int update(String tableName,String columnName,String seqName) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		int count = 0;
		String sql = "update seq_match_tbl_col set table_name = '"+tableName+"' ,"
					  + "is_exists = 1 ,column_name = '"+columnName+"' "
					  + "where seq_name = '"+seqName+"'";
		try {
			conn = DBUtil.getConn();
			pre = conn.prepareStatement(sql);
			count = pre.executeUpdate();
			return count;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(res, pre, conn);
		}
		return count;
	}

	/**
	 * 判断字段是否存在
	 * owner:用户名
	 * tableName:表名
	 * columnName:字段名
	 */
	@Override
	public int countCol(String owner, String tableName, String columnName) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		int count = 0;
		String sql = "SELECT COUNT(1) FROM ALL_TAB_COLUMNS A WHERE A.OWNER = '"+owner+"' "
				     + "AND A.TABLE_NAME = '"+tableName+"' "
				     + "AND A.COLUMN_NAME = '"+columnName+"'";
		try {
			conn = DBUtil.getConn();
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				count = res.getInt("COUNT(1)");
			}
			return count;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(res, pre, conn);
		}
		return count;
	}
	
}
