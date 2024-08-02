package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "Meddetails")
public class Meddetail {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;
	
	private String medicinename;
	private String medicinedetail;
	private String price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMedicinename() {
		return medicinename;
	}
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
	public String getMedicinedetail() {
		return medicinedetail;
	}
	public void setMedicinedetail(String medicinedetail) {
		this.medicinedetail = medicinedetail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
      