package com.cp.microservices.data.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="PROJECT")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long projectId;
	public String userId;
	public String title;
	public String description;
	public String status;	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Timestamp bidEndDate;
	@OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
    private List<Bid> bids;
}
