package com.tistory.hitomis.springbootthymeleafboard;

import com.tistory.hitomis.springbootthymeleafboard.domain.Board;
import com.tistory.hitomis.springbootthymeleafboard.domain.Member;
import com.tistory.hitomis.springbootthymeleafboard.persistence.BoardRepository;
import com.tistory.hitomis.springbootthymeleafboard.persistence.MemberRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInitTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testDataInsert() {
        Member member1 = new Member();
        member1.setId("member1");
        member1.setName("유저");
        member1.setPassword("1234");
        member1.setRole("ROLE_USER");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setName("어드민");
        member2.setPassword("1234");
        member2.setRole("ROLE_ADMIN");
        memberRepository.save(member2);

        for (int i = 0; i < 6; i++) {
            Board board = new Board();
            board.setWriter("유저");
            board.setTitle("유저가 등록한 글 " + i);
            board.setContent("게시물 내용" + i);
            boardRepository.save(board);
        }

        for (int i = 0; i < 6; i++) {
            Board board = new Board();
            board.setWriter("어드민");
            board.setTitle("어드민가 등록한 글 " + i);
            board.setContent("게시물 내용" + i);
            boardRepository.save(board);
        }
    }
}
