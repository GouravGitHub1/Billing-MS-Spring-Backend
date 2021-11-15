package com.billms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.billms.model.BillDataModel;

@Repository
public class BillRepositoryTemplate {

	@Autowired
	MongoTemplate mongotemplate;

	public List<BillDataModel> findByDate(Date start, Date end) {
		Query query = new Query();
		query.addCriteria(Criteria.where("dueDate").lt(end).gte(start));
		return mongotemplate.find(query, BillDataModel.class);
	}
	

}
