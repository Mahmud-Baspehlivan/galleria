package com.emrebaspehlivan.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "refresh_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken extends BaseEntity{
	
	@Column(name = "refresh_token")
	private String refreshToken;
	
	@Column(name = "exprired_date")
	private Date expriredDate;
	
	@ManyToOne
	private User user;

}
