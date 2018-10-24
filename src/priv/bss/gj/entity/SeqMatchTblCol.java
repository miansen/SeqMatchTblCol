package priv.bss.gj.entity;

/**
 * @author wang.miansen
 * 2018年10月23日
 * 下午4:17:10
 * TODO
 */
public class SeqMatchTblCol {
	
	private String owner;
	private String seqName;
	private String tableName;
	private boolean isExists;
	private String columnName;
	private Integer columnLength;
	private String remark;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public boolean isExists() {
		return isExists;
	}
	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getColumnLength() {
		return columnLength;
	}
	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SeqMatchTblCol [owner=" + owner + ", seqName=" + seqName + ", tableName=" + tableName + ", isExists="
				+ isExists + ", columnName=" + columnName + ", columnLength=" + columnLength + ", remark=" + remark
				+ "]";
	}
	
}
