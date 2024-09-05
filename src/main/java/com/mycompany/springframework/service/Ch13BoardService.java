package com.mycompany.springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13BoardDao;
import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch13BoardService {
	@Autowired
	private Ch13BoardDao boardDao;
	
	public List<Ch13Board> getBoardList(Ch13Pager pager){
		List<Ch13Board> list = boardDao.selectList(pager);
		
		return list;
	}
	 
	public Ch13Board getBoard(int bno) {
		Ch13Board board = boardDao.selectByBno(bno);
		
		 return board;
	 }
	
	public void writeBoard(Ch13Board board) {
		log.info("실행");
		log.info("bno: " + board.getBno()); //0값이 나올것이다.
		boardDao.insert(board);
		log.info("bno: " + board.getBno()); //insert 후에도 0값이 나올것이다.
		//bno를 이용해서 추가적인 비즈니스 로직을 작성해야 할 경우
		int bno = board.getBno();
	}
	
	public void updateBoard(Ch13Board board) {
		boardDao.update(board);
	}
	
	public void deleteBoard (int bno) {
		boardDao.delete(bno);
	}

	public int getTotalRows() {
		int totalRows = boardDao.countRows();
		return totalRows;
	}

	public Ch13Board getBoardAttach(int bno) {
		Ch13Board board = boardDao.selectAttachByBno(bno);
		return board;
	}

	public void addHitcount(int bno) {
		boardDao.updateHitcount(bno);
	}
}
