package com.iu.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		//1.로그인 정보
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1536:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2.클래스 로딩
		Class.forName(driver);
		
		//3.로그인 connection
		Connection con= DriverManager.getConnection(url, user, password);
		
		//4. sql문 생성
		String sql="select * from member where id=? and pw=?";
		
		//5. 미리보내기
		PreparedStatement st= con.prepareStatement(sql);
		
		//6.? 세팅
		st.setString(1,memberDTO.getId());
		st.setString(2,memberDTO.getPw());
		
		//7. 최종 전송 후 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			
		}else {
			memberDTO=null;
		}
		
		//8. 해제
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
}
