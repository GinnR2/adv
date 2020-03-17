package ua.lviv.lgs.domain;

import java.sql.Date;

public class Bucket {
	private int id;
	private int user_id;
	private int product_id;
	private Date date;

	public Bucket(int id, int user_id, int product_id, Date date) {

		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.date = date;
	}

	public Bucket(int user_id, int product_id, Date date) {

		this.user_id = user_id;
		this.product_id = product_id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + product_id;
		result = prime * result + user_id;
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
		Bucket other = (Bucket) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (product_id != other.product_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", date=" + date + "]";
	}

}
