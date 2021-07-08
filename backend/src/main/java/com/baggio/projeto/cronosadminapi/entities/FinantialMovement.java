package com.baggio.projeto.cronosadminapi.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baggio.projeto.cronosadminapi.entities.enums.Origin;
import com.baggio.projeto.cronosadminapi.entities.enums.Status;

@Entity
@Table(name="tb_finantial_movement")
public class FinantialMovement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Número da conta/nota
	@Column(name = "invoice_number")
	private Long invoiceNumber;
	
	//Número da parcela
	@Column(name = "portion_number")
	private Long portionNumber;
	
	@Enumerated(EnumType.STRING)
	private Origin origin;
	
	//Data de Vencimento
	@Column(name = "due_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dueDate;
	
	//Data de Pagamento/Recebimento
	@Column(name = "paid_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant paidDate;
	
	//Data de lançamento
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name= "attachment_url", columnDefinition = "TEXT")
	private String attachmentUrl;	
	
	private Double value;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "historic_id")
	private FinantialHistoric historic;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public FinantialMovement() {

	}
	
	public FinantialMovement(Long id, Long invoiceNumber, Long portionNumber, Origin origin, Instant dueDate,
			Instant paidDate, Instant moment, String description, String attachmentUrl, Double value, Status status,
			Person person, FinantialHistoric historic, User user) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.portionNumber = portionNumber;
		this.origin = origin;
		this.dueDate = dueDate;
		this.paidDate = paidDate;
		this.moment = moment;
		this.description = description;
		this.attachmentUrl = attachmentUrl;
		this.value = value;
		this.status = status;
		this.person = person;
		this.historic = historic;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Long getPortionNumber() {
		return portionNumber;
	}

	public void setPortionNumber(Long portionNumber) {
		this.portionNumber = portionNumber;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	public Instant getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Instant paidDate) {
		this.paidDate = paidDate;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getAttachmentUrl() {
		return attachmentUrl;
	}
	
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public FinantialHistoric getHistoric() {
		return historic;
	}

	public void setHistoric(FinantialHistoric historic) {
		this.historic = historic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FinantialMovement other = (FinantialMovement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
