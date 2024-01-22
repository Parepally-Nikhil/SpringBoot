package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.example.demo.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
public class Ticket {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "tik_seq")
    @GenericGenerator(name="tik_seq",
            strategy = "com.example.demo.sequencegenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="T_"),
                    @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
            }
            )
	private String tid;
    private String tclass;
    private int tfare;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public int getTfare() {
		return tfare;
	}
	public void setTfare(int tfare) {
		this.tfare = tfare;
	}
	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", tclass=" + tclass + ", tfare=" + tfare + "]";
	}
    
    
}
