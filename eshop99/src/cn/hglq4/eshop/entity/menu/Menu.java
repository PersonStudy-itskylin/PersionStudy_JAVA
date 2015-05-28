package cn.hglq4.eshop.entity.menu;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tmenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MENU")
public class Menu implements java.io.Serializable {

	// Fields

	private String id;
	private Menu tmenu;
	private String text;
	private String iconcls;
	private String url;
	private Set<Menu> tmenus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iconcls == null) ? 0 : iconcls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((tmenu == null) ? 0 : tmenu.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (iconcls == null) {
			if (other.iconcls != null)
				return false;
		} else if (!iconcls.equals(other.iconcls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (tmenu == null) {
			if (other.tmenu != null)
				return false;
		} else if (!tmenu.equals(other.tmenu))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	/** full constructor */
	public Menu(String id, Menu tmenu, String text, String iconcls, String url, Set<Menu> tmenus) {
		this.id = id;
		this.tmenu = tmenu;
		this.text = text;
		this.iconcls = iconcls;
		this.url = url;
		this.tmenus = tmenus;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID")
	public Menu getTmenu() {
		return this.tmenu;
	}

	public void setTmenu(Menu tmenu) {
		this.tmenu = tmenu;
	}

	@Column(name = "TEXT", length = 100)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "ICONCLS", length = 50)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "URL", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tmenu")
	public Set<Menu> getTmenus() {
		return this.tmenus;
	}

	public void setTmenus(Set<Menu> tmenus) {
		this.tmenus = tmenus;
	}

}