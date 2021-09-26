package com.tistory.hitomis.springbootthymeleafboard.service;

import com.tistory.hitomis.springbootthymeleafboard.domain.Member;
import com.tistory.hitomis.springbootthymeleafboard.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member getMember(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getId());
        if (findMember.isPresent()) {
            return findMember.get();
        } else return null;

    }

}
