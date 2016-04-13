package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Company;
import com.example.repository.CompanyRepository;
import com.example.vo.SearchCompany;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Transactional
	public Page<Company> search(SearchCompany searchCompany, Pageable pageable) {
		return companyRepository.search(searchCompany, pageable);
	}
}
