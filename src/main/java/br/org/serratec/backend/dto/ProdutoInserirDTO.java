package br.org.serratec.backend.dto;



public class ProdutoInserirDTO {
	 	private String nome;
	    private String descricao;
	    private Integer qtdEstoque;
	    private Double valorUnitario;
	    private Long idCategoria;
	    
	    public ProdutoInserirDTO() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    
		public ProdutoInserirDTO(String nome, String descricao, Integer qtdEstoque, Double valorUnitario,
				Long idCategoria) {
			super();
			this.nome = nome;
			this.descricao = descricao;
			this.qtdEstoque = qtdEstoque;
			this.valorUnitario = valorUnitario;
			this.idCategoria = idCategoria;
		}




		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Integer getQtdEstoque() {
			return qtdEstoque;
		}

		public void setQtdEstoque(Integer qtdEstoque) {
			this.qtdEstoque = qtdEstoque;
		}

		public Double getValorUnitario() {
			return valorUnitario;
		}

		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}

		public Long getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(Long idCategoria) {
			this.idCategoria = idCategoria;
		}
	    
	    
}
