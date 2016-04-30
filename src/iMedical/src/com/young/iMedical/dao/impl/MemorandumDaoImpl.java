package com.young.iMedical.dao.impl;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.MemorandumDao;
import com.young.iMedical.domain.Memorandum;

@Repository(MemorandumDao.SERVICE_NAME)
public class MemorandumDaoImpl extends CommonDaoImpl<Memorandum> implements
		MemorandumDao {

	/**
	 * select memorandum0_.time as time6_ from memorandum memorandum0_ where 1=1
	 * and memorandum0_.pre_id=? and memorandum0_.pm_id=? order by
	 * memorandum0_.time asc
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Time> findTimeByPresAndMed(final String pre_id,
			final Integer pm_id) {
		final String sql = "select memorandum0_.time as time6_ from memorandum memorandum0_ "
				+ "where 1=1 and memorandum0_.pre_id=? and memorandum0_.pm_id=? "
				+ "order by memorandum0_.time asc";
		List<Time> list = (List<Time>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@SuppressWarnings("deprecation")
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(sql).addScalar(
								"time6_", Hibernate.TIME);
						query.setParameter(0, pre_id);
						query.setParameter(1, pm_id);
						return query.list();
					}
				});
		return list;
	}
}
