package com.site.p0830.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.p0830.vo.BoardVo;

@Mapper
public interface BoardMapper {

	//게시판 전체검색
	List<BoardVo> selectBoardList(int startrow,int endrow, String category, String searchWord);

	//게시글 전체개수
	int selectListCount(String category, String searchWord);

}
