package com.github.gitGroupTest.mapper;

import com.github.gitGroupTest.domain.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	Member get(int m_no);

	List<Member> getAll();

	int getMemberNo();

	void register(Member m);

	void modify(Member m);

	void delete(int m_no);

}

