package com.site.p0830.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	
	public BoardVo(String btitle, String bcontent, String bname, String bupload) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bname = bname;
		this.bupload = bupload;
	}
	
	private int bid;
	private String btitle;
	private String bcontent;
	private String bname;
	private int bgroup;
	private int bstep;  //default 0
	private int bindent;
	private Timestamp bdate;
	private String bupload;
	private int bhit;
	

}
