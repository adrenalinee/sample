package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Company;
import com.example.vo.SearchCompany;

public interface CompanyRepositoryCustom {
	
	Page<Company> search(SearchCompany searchCompany, Pageable pageable);
}
