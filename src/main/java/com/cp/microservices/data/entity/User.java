package com.cp.microservices.data.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="USER")
public class User {
	
	@Id	
	public String userId;
	public String firstName;
	public String lastName;
	public String email;
	public String login;
	@JsonIgnore
	public String passwordEnc;
	@JsonIgnore
	public String createdBy;
	@JsonIgnore
	public Timestamp createdOn;
	@JsonIgnore
	public String updatedBy;
	@JsonIgnore
	public Timestamp updatedOn;
}
