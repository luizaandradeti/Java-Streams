package com.luiza.pedidos.tabelas;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double valorFormatado;
        private int prazoPagamento;
        private Boolean aprovada;
        private boolean incluida;
        private String detalhes;

        @OneToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "id_cliente")
        @JsonManagedReference
        private Cliente cliente;


        //um pedido pertence a um cliente, inner join atraves de id
    }