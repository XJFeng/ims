package cn.com.lianbi.framework.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author junhong.xie
 * @since 2015年11月9日 下午5:22:10
 */
@Repository
public class HibernateDao {
	
	private static final Logger logger = LogManager
			.getLogger(HibernateDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * SQL查询，结果为 {@code List<Map>}
	 * 
	 * @param sqlString
	 *            SQL字符串
	 * @param paramMap
	 *            查询参数
	 * @param page
	 *            分页信息
	 * @return {@link Map} 类型的结果集
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findListBySql(String sqlString,
			Map<String, Object> paramMap, Page page) {

		logger.debug("sqlString: {}", sqlString);
		logger.debug("paramMap: {}", paramMap);
		logger.debug("page: {}", page);

		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlString);

		if (paramMap != null && paramMap.size() > 0)
			paramMap.forEach((key, val) -> sqlQuery.setParameter(key, val));

		if (page != null) {
			sqlQuery.setFirstResult(page.getFirstResult());
			sqlQuery.setMaxResults(page.getMaxResult());
		}

		sqlQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

		@SuppressWarnings("unchecked")
		List<Map> list = sqlQuery.list();

		return list;
	}

	/**
	 * 返回单条结果 或 null，如果多个结果找到，则抛出 {@link org.hibernate.NonUniqueResultException}
	 * 
	 * @param sqlString
	 *            SQL字符串
	 * @param paramMap
	 *            查询参数
	 * @return 单条结果 或 {@code null}
	 */
	public Object findUniqueResultBySql(String sqlString,
			Map<String, Object> paramMap) {

		logger.debug("sqlString: {}", sqlString);
		logger.debug("paramMap: {}", paramMap);
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlString);
		
		if (paramMap != null && paramMap.size() > 0)
			paramMap.forEach((key, val) -> sqlQuery.setParameter(key, val));
		
		return sqlQuery.uniqueResult();
	}

	public Session getCurrentSession(String sqlString,
			Map<String, Object> paramMap, Page page) {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
