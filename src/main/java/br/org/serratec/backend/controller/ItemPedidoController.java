package br.org.serratec.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.dto.ItemPedidoDTO;
import br.org.serratec.backend.service.ItemPedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemPedidoDTO inserir(@Valid @RequestBody ItemPedidoDTO itemPedidoDTO) throws ItemPedidoException, PedidoException {
		ItemPedidoDTO iPDTO = itemPedidoService.addItemPedido(itemPedidoDTO);
		return iPDTO;
	}*/
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Listagem de todos itens pedido", notes = "Listagem de itens")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Itens com sucesso"),
	@ApiResponse (code = 401, message = "Erro de autenticação"),
	@ApiResponse (code = 403, message = "Você não tem permissão para acessar o recurso"),
	@ApiResponse (code = 404, message = "Recurso indisponível"),
	@ApiResponse (code = 500, message = "Erro interno no servidor"),
	@ApiResponse (code = 505, message = "Ocorreu uma exceção")
	}
	)
	public List<ItemPedidoDTO> listar() {
		List<ItemPedidoDTO> iPDTO = itemPedidoService.getItens();
		return iPDTO;
	}
}