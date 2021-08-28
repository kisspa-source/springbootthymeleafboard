package com.tistory.hitomis.springbootthymeleafboard.service;

import com.tistory.hitomis.springbootthymeleafboard.domain.Board;
import com.tistory.hitomis.springbootthymeleafboard.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    /**
     * 글목록 조회
     * @param board
     * @return
     */
    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepository.findAll();
    }

    /**
     * 글쓰기 처리
     * @param board
     */
    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);

    }

    /**
     * 상세글 조회
     * @param board
     * @return
     */
    @Override
    public Board getBoard(Board board) {

        // 조회수 처리
        Board findBoard = boardRepository.findById(board.getSeq()).get();
        findBoard.setCnt(findBoard.getCnt()+1);
        boardRepository.save(findBoard);

        return findBoard;
    }

    /**
     * 글 수정
     * @param board
     */
    @Override
    public void updateBoard(Board board) {
        // 수정 대상 글을 가져온다.
        Board findBoard = boardRepository.findById(board.getSeq()).get();

        // 가져온 글에 수정한 내용을 세팅한다.
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());

        // DB에 저장
        boardRepository.save(findBoard);
    }

    /**
     * 글 삭제 처리
     * @param board
     */
    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

}
