package com.Petrucci.Agenda.impegni;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "impegni")
@Data
@NoArgsConstructor
public class Impegni {

	@Id
	@GeneratedValue
	private UUID impegnoId;
	private String dettagli;
	private Date dataImpegno;
	private Date oraImpegno;

	@CreationTimestamp
	private Date dataCreazione;

}
