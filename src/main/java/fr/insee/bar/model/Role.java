package fr.insee.bar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "roles")
@DynamicUpdate
@DynamicInsert
public class Role {

	@Id
	@Column(name = "id")
	private Short id;

	@Column(name = "libelle")
	private String libelle;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Role)) {
			return false;
		}
		Role other = (Role) object;
		return Objects.equal(this.id, other.id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("libelle", libelle)
			.toString();
	}
}
