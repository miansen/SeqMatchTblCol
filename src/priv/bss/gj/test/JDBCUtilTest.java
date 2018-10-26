package priv.bss.gj.test;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import priv.bss.gj.dao.SeqMatchTblColDao;
import priv.bss.gj.dao.impl.SeqMatchTblColDaoImpl;
import priv.bss.gj.entity.SeqMatchTblCol;
import priv.bss.gj.service.SeqMatchTblColService;
import priv.bss.gj.service.impl.SeqMatchTblColServiceImpl;

/**
 * 娴嬭瘯浠ｇ爜
 * @author wang.miansen
 * 2018骞�10鏈�23鏃�
 * 涓嬪崍9:24:08
 * TODO
 */
public class JDBCUtilTest {
	
	private static Logger logger = Logger.getLogger(JDBCUtilTest.class);
	
	@Test
	public void findAllTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		List<SeqMatchTblCol> findAll = msDao.findAll();
		//System.out.println(findAll);
		logger.debug(findAll);
		logger.debug(findAll.size());
	}
	
	@Test
	public void countTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int count = msDao.countTbl("JK", "ATTR_VALUE");
		System.out.println(count);
	}
	
	/**
	 * 鏇存柊閰嶇疆琛�
	 * @throws Exception
	 */
	@Test
	public void updateTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		//int update = msDao.update("ATTR_VALUE","LOG_ID","INF_MKT_RES_DEAL_DEAL_ID");
		SeqMatchTblCol smtl = new SeqMatchTblCol();
		smtl.setOwner("MARKING");
		smtl.setTableName("CONTACT_CHL_ATTR");
		smtl.setColumnName("INST_ID");
		smtl.setColumnLength(22);
		smtl.setExists(true);
		smtl.setRemark("榛樿涓婚敭");
		smtl.setSeqName("CONTACT_CHL_ATTR_INST");
		int update = msDao.update(smtl);
		System.out.println(update);
	}
	
	@Test
	public void stringBufferTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		String str = "BILL_CHARGE_DETAIL_INF_MKT_RES_DEAL_DEAL_ID";
		String[] split = str.split("_");
		StringBuffer sb = new StringBuffer();
		int count = 0;
		logger.debug("寮�濮嬫墽琛�,搴忓垪鍚�:SEQ_"+str);
		for(int i = 0;i< split.length;i++){
			if(i == 0){
				sb.append(split[i]);
			}else {
				sb.append("_");
				sb.append(split[i]);
			}
			logger.debug("褰撳墠鍖归厤:"+sb);
			count = msDao.countTbl("JK", sb.toString());
			if(count > 0){
				logger.debug("缁撴灉:"+count+"(鍖归厤鎴愬姛),琛ㄥ悕:"+sb+",鐢ㄦ埛:JK");
				return;
			}
		}
		logger.debug("鏈壘鍒颁笌涔嬪搴旂殑琛ㄥ悕");
	}
	
	/**
	 * 鍖归厤琛ㄥ悕鍜屽瓧娈�
	 * @throws Exception
	 */
	@Test
	public void serviceMatchTest() throws Exception{
		SeqMatchTblColService msSeqMatchTblService = new SeqMatchTblColServiceImpl();
		msSeqMatchTblService.match();
	}
	
	/**
	 * 鍒ゆ柇瀛楁鏄惁瀛樺湪
	 * @throws Exception
	 */
	@Test
	public void countColTest() throws Exception{
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int count = msDao.countCol("JK", "INF_OFFER_SMS", "ID");
		logger.debug(count);
	}
	
	@Test
	public void substringTest() throws Exception{
		String tableName = "CEPEX_SOO_ORDER_EXT";
		String str = "CEPEX_SOO_ORDER_EXT_LOG_ID";
		String substring = str.substring(tableName.length()+1);
		logger.debug(substring);
	}
	
	/*@Test
	public void matchColTest() throws Exception{
		SeqMatchTblColService msSeqMatchTblService = new SeqMatchTblColServiceImpl();
		String matchCol = msSeqMatchTblService.matchCol("JK", "CEPEX_SOO_ORDER_EXT", "CEPEX_SOO_ORDER_EXT_LOG_ID");
		logger.debug(matchCol);
	}*/
	
	/**
	 * 鏌ヨ琛ㄧ殑涓婚敭
	 * @throws Exception
	 */
	@Test
	public void selectPrimaryKeyTest() throws Exception {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		String selectPrimaryKey = msDao.selectPrimaryKey("MARKING","EVENT");
		logger.debug(selectPrimaryKey);
	}
	
	@Test
	public void test01() throws Exception {
		String seq = "EVENT_MATCH_RUL";
		String matchTbl = "EVENT";
		String matchCol = "aaa_id";
		String primaryKey = "EVENT_ID";
		String owner = "MARKING";
		String a = matchCol != null ? matchCol : primaryKey;
		logger.debug("缁撴灉:鍖归厤鎴愬姛,搴忓垪:"+seq+",琛ㄥ悕:"+matchTbl+",瀛楁:"+(matchCol != null ? matchCol : primaryKey)+",鐢ㄦ埛:"+owner+"");
		System.out.println("瀛楁:"+a);
	}
	
	/**
	 * 鏌ヨ瀛楁鐨勯暱搴�
	 * @throws Exception
	 */
	@Test
	public void selectColumnLengthTest() throws Exception {
		SeqMatchTblColDao msDao = new SeqMatchTblColDaoImpl();
		int selectColumnLength = msDao.selectColumnLength("MARKING", "MKT_QST_QUEST_DETAIL_REL", "REL_CONF_ID");
		logger.debug(selectColumnLength);
	}
	
	/**
	 * 测试分支
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception {
		logger.debug("测试分支");
	}
}
