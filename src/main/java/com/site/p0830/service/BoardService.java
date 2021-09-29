package com.site.p0830.service;

import java.util.List;
import java.util.Map;

import com.site.p0830.vo.BoardVo;

public interface BoardService {

	//게시판 전체검색
	Map<String, Object> selectBoardList(int page, String category, String searchWord);

}
