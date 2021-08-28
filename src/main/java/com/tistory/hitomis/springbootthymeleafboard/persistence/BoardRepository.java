package com.tistory.hitomis.springbootthymeleafboard.persistence;

import com.tistory.hitomis.springbootthymeleafboard.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
