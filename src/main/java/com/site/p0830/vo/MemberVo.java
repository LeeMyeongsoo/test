package com.site.p0830.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberVo {
	
	String id;
	String pw;
	String name;
	String nickname;
	String gender;
	String tel;
	String address1;
	String address2;
	String hobby;

}
