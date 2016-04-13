package com.example.predicate;

import com.example.entity.QUserGroup;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

public class UserGroupPredicate {
	
	public static Predicate search(Long userGroupId, String userName) {
		QUserGroup userGrop = QUserGroup.userGroup;
		
		BooleanBuilder builder = new BooleanBuilder();
		if (userGroupId != null) {
			builder.and(userGrop.userGroupId.eq(userGroupId));
		}
		if (userName != null) {
			builder.and(userGrop.users.any().name.like("%" + userName + "%"));
		}
		
		return builder;
	}
}
