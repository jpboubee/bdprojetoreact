package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.ItemPedidoDTO;
import br.org.serratec.backend.dto.ItemPedidoInserirDTO;
import br.org.serratec.backend.exception.ItemPedidoException;
import br.org.serratec.backend.exception.PedidoException;
import br.org.serratec.backend.model.ItemPedido;
import br.org.serratec.backend.model.Pedido;
import br.org.serratec.backend.model.Produto;
import br.org.serratec.backend.repository.ItemPedidoRepository;
import br.org.serratec.backend.repository.PedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	public List<ItemPedido> salvarListaItemPedido (List<ItemPedidoInserirDTO> itemPedidoInserirDTOLista, Pedido pedido) throws ItemPedidoException, PedidoException {
			List<ItemPedido> ItensLista = new ArrayList<>();
				for(ItemPedidoInserirDTO itemPedidoDTO : itemPedidoInserirDTOLista) {
					ItemPedido iP = new ItemPedido();
					Produto produto = produtoService.buscarProdutoPorId(itemPedidoDTO.getId_produto());
					iP.setTotal(itemPedidoDTO.getQuantidade() * produto.getValorUnitario());
					produto.setQtdEstoque(produto.getQtdEstoque() - itemPedidoDTO.getQuantidade());
					iP.setPrecoVenda(produto.getValorUnitario());
					iP.setPedido(pedido);
					iP.setProduto(produto);
					iP.setQuantidade(itemPedidoDTO.getQuantidade());
					itemPedidoRepository.save(iP);
					ItensLista.add(iP);
				}
				return ItensLista;
	}

	public List<ItemPedidoDTO> getItens() {
		List<ItemPedidoDTO> itemPedidoDTOLista = new ArrayList<>();
		List<ItemPedido> ItemPedidoLista = itemPedidoRepository.findAll();
		ItemPedido ip = new ItemPedido();
		
		for(int i = 0; i < ItemPedidoLista.size(); i++) {
			ItemPedidoDTO iPDTO = new ItemPedidoDTO();
			ip = ItemPedidoLista.get(i);
			iPDTO.setId_pedido(ip.getPedido().getId());
			iPDTO.setProduto(ip.getProduto());
			iPDTO.setPrecoVenda(ip.getPrecoVenda());
			iPDTO.setQuantidade(ip.getQuantidade());
			iPDTO.setTotal(ip.getTotal());
			itemPedidoDTOLista.add(iPDTO);
		}
		return itemPedidoDTOLista;
	}
	
	public Boolean deletarPorPedido(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		List<ItemPedido> lista  =  itemPedidoRepository.findAllByPedido(pedido.get());
		itemPedidoRepository.deleteAll(lista);
		return true;
	}
}