package com.Petrucci.Agenda.impegni;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImpegniPayload {

	private String dettagli;
	private Date dataImpegno;
	private Date oraImpegno;

}
