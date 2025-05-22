import com.luiza.pedidos.dto.PedidoRequestDto;
import com.luiza.pedidos.tabelas.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido convertDtoToPedido(PedidoRequestDto pedidoRequestDto);

}