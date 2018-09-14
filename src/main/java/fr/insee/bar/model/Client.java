package fr.insee.bar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "clients")
@DynamicUpdate
@DynamicInsert
public class Client {

	public static Client EMPTY = new Client((short) 0, "<client>");

	public Client() {
		titre = Titre.M;
	}

	private Client(Short id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	@Min(0)
	@Id
	@GeneratedValue(generator = "barGenerator")
	@SequenceGenerator(name = "barGenerator", sequenceName = "seq", allocationSize = 1, initialValue = 100)
	@Column(name = "id")
	private Short id;

	@Size(min = 5, max = 300)
	@Column(name = "nom")
	private String nom;

	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "titre")
	@Enumerated(EnumType.ORDINAL)
	private Titre titre;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	@Past
	@Column(name = "date_naissance")
	private Date dateNaissance;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public enum Titre {

		M((short) 1, "Monsieur"), MME((short) 2, "Madame");

		private String libelle;
		private Short code;

		private Titre(Short code, String libelle) {
			this.code = code;
			this.libelle = libelle;
		}

		public String getLibelle() {
			return libelle;
		}

		public Short getCode() {
			return code;
		}

		public static Titre of(short titre) {
			switch (titre) {
			case 2:
				return MME;
			default:
				return M;
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		return Objects.equal(this.id, other.id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("nom", nom)
			.add("email", email)
			.add("dateNaissance", dateNaissance)
			.toString();
	}

}
