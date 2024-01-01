package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@ToString @Getter @Setter
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TaskID;

    private String description;
    private int priority;
    private String assignedTo;
    private String status;
    private Date creationDate;
    private Date dueDate;
	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setPriority(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setAssignedTo(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCreationDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	public void setDueDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	
    
}