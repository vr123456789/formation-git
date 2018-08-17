package fr.insee.bar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "cocktails")
@DynamicUpdate
@DynamicInsert
public class Cocktail {

	@Id
	@GeneratedValue(generator = "barGenerator")
	@SequenceGenerator(name = "barGenerator", sequenceName = "seq", allocationSize = 1, initialValue = 100)
	@Column(name = "id")
	private Short id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "norm")
	private String nomNorm;

	@Column(name = "prix")
	private Double prix;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getNomNorm() {
		return nomNorm;
	}

	public void setNomNorm(String nomNorm) {
		this.nomNorm = nomNorm;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Cocktail)) {
			return false;
		}
		Cocktail other = (Cocktail) object;
		return Objects.equal(this.id, other.id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("nom", nom)
			.add("prix", prix)
			.toString();
	}

}
