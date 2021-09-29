package com.site.p0830.service;

import java.util.Map;

public interface Event01Service {

	Map<String, Object> selectBoardList(int page, String category, String searchWord);

	Map<String, Object> selectOneList(int bid);

	

	

}
