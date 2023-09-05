package com.clientes.apirest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data   //Gerar geters e seteres e toString
@AllArgsConstructor //Gerar o construtor com todos atributos
@NoArgsConstructor  //Gera um construtor vazio
@Builder  //Pra criar objetos clientes
@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "cl_nome", nullable = false)
	private String nome;
	@Column(name = "cl_email", nullable = false)
	private String email;
	@Column(name = "cl_nuit", nullable = false)
	private String nuit;

	
}
