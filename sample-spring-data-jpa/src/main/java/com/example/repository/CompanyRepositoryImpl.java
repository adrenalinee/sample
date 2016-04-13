package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.example.entity.Company;
import com.example.entity.QCompany;
import com.example.entity.QUser;
import com.example.vo.SearchCompany;
import com.mysema.query.jpa.JPQLQuery;

public class CompanyRepositoryImpl extends QueryDslRepositorySupport implements CompanyRepositoryCustom {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

	@Override
	public Page<Company> search(SearchCompany searchCompany, Pageable pageable) {
		QCompany company = QCompany.company;
		QUser member = QUser.user;
		
		JPQLQuery query = from(company);
		if (searchCompany.getCompanyId() != null) {
			query.where(company.companyId.eq(searchCompany.getCompanyId()));
		}
		if (searchCompany.getLocaton() != null) {
			query.where(company.locaton.eq(searchCompany.getLocaton()));
		}
		if (searchCompany.getMemberName() != null) {
			query
				.innerJoin(company.members, member)
				.where(member.name.like("%" + searchCompany.getMemberName() + "%"));
		}
		
		
		List<Company> companies = getQuerydsl().applyPagination(pageable, query).list(company);
		long totalCount = query.count();
		
		return new PageImpl<>(companies, pageable, totalCount);
	}

}
