package priv.bss.gj.test;

/**
 * 测试代码
 * @author wang.miansen
 * 2018年10月23日
 * 下午9:25:09
 * TODO
 */
public class MsTemp1008 {
	private String tableName;
	private String owner;
	private String isExists;
	private String sqlName;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getIsExists() {
		return isExists;
	}
	public void setIsExists(String string) {
		this.isExists = string;
	}
	public String getSqlName() {
		return sqlName;
	}
	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}
	@Override
	public String toString() {
		return "MsTemp1008 [tableName=" + tableName + ", owner=" + owner + ", isExists=" + isExists + ", sqlName="
				+ sqlName + "]";
	}
}
