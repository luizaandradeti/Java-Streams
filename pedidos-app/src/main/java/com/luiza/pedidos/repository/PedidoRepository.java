package com.luiza.pedidos.repository;

import com.luiza.pedidos.tabelas.Pedido;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    List<Pedido> findAllByIncluidaIsFalse();

    List<Pedido> findAllByAprovadaIsTrue();
    @Transactional
    @Modifying
    @Query(value = "UPDATE pedido SET aprovada = :aprovada, " +
            "detalhes = :detalhes WHERE id = :id", nativeQuery = true)
    void atualizarPedido(Long id, boolean aprovada, String detalhes);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Pedido SET incluida = :incluida WHERE id = :id")
    void atualizarStatusIncluida(Long id, boolean incluida);


}