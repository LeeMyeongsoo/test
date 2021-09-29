package com.site.p0830.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.p0830.vo.BoardVo;
import com.site.p0830.vo.EventVo;

@Mapper
public interface event01Mapper {

	List<BoardVo> selectBoardList(int startrow, int endrow, String category, String searchWord);

	int selectListCount(String category, String searchWord);

	BoardVo selectOneList(int bid);
	//조회수 1증가
	void updateBhut(int bid);
	//하단댓글 가져오기

	List<EventVo> selectReplyAll(int bid);


}
