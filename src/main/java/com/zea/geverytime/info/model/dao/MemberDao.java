package com.zea.geverytime.info.model.dao;

import static com.zea.geverytime.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zea.geverytime.info.model.MemberException;
import com.zea.geverytime.info.model.vo.Member;

public class MemberDao {
private Properties prop = new Properties();
	
	public MemberDao(){
		// /build/classes 하위에서 파일을 조회
		String filepath = MemberDao.class.getResource("/member-query.properties").getPath();
		System.out.println(filepath);
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneMember");
		ResultSet rset = null;
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setEmail(rset.getString("email"));
				member.setMemberRole(rset.getString("member_role"));
				member.setMemberType(rset.getString("member_Type"));
				member.setBirthday(rset.getDate("birthday"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		int result = 0;
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,member.getMemberId());
		pstmt.setString(2,member.getPassword());
		pstmt.setString(4,member.getMemberName());
		pstmt.setString(5,member.getEmail());
		pstmt.setString(6,member.getPhone());
		pstmt.setString(7,member.getAddress());
		pstmt.setString(8,member.getMemberRole());
		pstmt.setString(9,member.getMemberType());
		pstmt.setDate(10,member.getBirthday());


		//2. 실행 - executeUpdate
		result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			throw new MemberException("회원가입 오류!", e);
		} finally {
			// 3.자원반납
			close(pstmt);
		}
		
		
		return result;
	}
}