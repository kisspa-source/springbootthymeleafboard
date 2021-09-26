package com.tistory.hitomis.springbootthymeleafboard.persistence;

import com.tistory.hitomis.springbootthymeleafboard.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
