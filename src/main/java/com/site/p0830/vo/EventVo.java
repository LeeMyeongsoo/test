package com.site.p0830.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventVo {
	
	private int cno;
	private int bid;
	private String id;
	private String cpw;
	private String ccontent;
	private Timestamp cdate;

}
