package com.app.auth.server.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Role extends BasedIdEntity{

	private String name;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
			fetch = FetchType.EAGER)
	@JoinTable(name = "permission_role",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
	private List<Permission> permissions;
}
