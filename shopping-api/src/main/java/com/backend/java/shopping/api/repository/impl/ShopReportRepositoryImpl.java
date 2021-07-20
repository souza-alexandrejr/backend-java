package com.backend.java.shopping.api.repository.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.backend.java.shopping.api.dto.ShopReportDTO;
import com.backend.java.shopping.api.model.Shop;
import com.backend.java.shopping.api.repository.ShopReportRepository;

public class ShopReportRepositoryImpl implements ShopReportRepository {

	@Override
	public List<Shop> getShopByFilters(Date startDate, Date endDate, Float minimumValue) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT s ");
		sb.append("FROM shop s ");
		sb.append("WHERE s.date >= :startDate ");
		
		if (endDate != null) {
			sb.append("AND s.date <= :endDate ");
		}
		
		if (minimumValue != null) {
			sb.append("AND s.total <= :minimumValue ");
		}
		
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter("startDate", startDate);
		
		if (endDate != null) {
			query.setParameter("endDate", endDate);
		}
		
		if (minimumValue != null) {
			query.setParameter("minimumValue", minimumValue);
		}
		
		return query.getResultList();
	}

	@Override
	public ShopReportDTO getShopReportByDate(Date startDate, Date endDate) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(sp.id), AVG(sp.total), SUM(sp.total) ");
		sb.append("FROM shopping.shop sp ");
		sb.append("AND sp.date >= :startDate ");
		sb.append("AND sp.date <= :endDate ");
		
		Query query = entityManager.createNamedQuery(sb.toString());
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		
		Object[] result = (Object[]) query.getSingleResult();
		
		ShopReportDTO shopReportDTO = new ShopReportDTO();
		shopReportDTO.setCount(((BigInteger) result[0]).intValue());
		shopReportDTO.setMean((Double) result[1]);
		shopReportDTO.setTotal((Double) result[2]);
		
		return shopReportDTO;
	}
	
	@PersistenceContext
	private EntityManager entityManager;

}
