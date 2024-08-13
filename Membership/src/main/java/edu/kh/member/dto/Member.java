package edu.kh.member.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter  // 컴파일 시 getter 구문을 자동 추가
@Setter  // 컴파일 시 setter 구문을 자동 추가
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor  // 전체 필드 매개변수 생성자
@ToString // toString() 오버라이딩
@EqualsAndHashCode // equals(), hashCode 오버라이딩


public class Member implements Serializable{


	// 등급을 나타내는 상수
	public static final int COMMON = 0;
	public static final int GOLD = 1;
	public static final int DIAMOND = 2;

	// 회원 정보를 저장할 필드
	private String name;
	private String phone;
	private int amount; 
	private int grade;

}
