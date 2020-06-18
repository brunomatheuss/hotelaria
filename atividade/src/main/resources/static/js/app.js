var app = angular.module("hotel-web", []);

app.controller("hotel-controller", [ "$http", "$scope", function($http, $scope){
	
	$scope.listQuartos = [];
	
	$scope.listReservas = [];
	
	$scope.listProdutos = [];
	
	$scope.listProdutosReserva = [];
	
	$scope.setHome = function (){window.location.href = "http://localhost:9090";}
	
	$scope.getQuartosDisponiveis = function(){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/quarto"
		}).then(
			function success(response){
				$scope.listQuartos = [];
				$scope.listReservas = [];
				dados = response.data;
				for(dado of dados){
					if(dado.disponivel == 0){
						$scope.listQuartos.push(dado);
					}
				}
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.getQuartosReservados = function(){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/reserva"
		}).then(
			function success(response){
				$scope.listQuartos = [];
				$scope.listReservas = [];
				dados = response.data;
				for(dado of dados){
					if(dado.statusPagameno == 0){
						$scope.listReservas.push(dado);
					}
				}
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.getProdutosDaReserva = function(reserva){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/reserva/produto/"+reserva.id
		}).then(
			function success(response){
				$scope.listProdutosReserva = [];
				$scope.listProdutosReserva = response.data;
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.getProdutos = function(reserva){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/produto"
		}).then(
			function success(response){
				$scope.listProdutos = [];
				$scope.listProdutos = response.data;
				$scope.reserva = reserva;
				$scope.getProdutosDaReserva(reserva);
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.getQuartosDisponiveis();
	
	$scope.getDadosReserva = function(quarto){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/pessoa"
		}).then(
			function success(response){
				$scope.listPessoas = response.data;
				$scope.quarto = quarto;
			},
			function unsuccess(response){
				console.log(response);
			}
		)
		
	}
	
	$scope.reservar = function(quarto, pessoa){
		$http({
			method: "POST",
			url: "http://localhost:9090/reserva/quarto/"+quarto.id+"/pessoa/"+pessoa.cpf,
			data: {dataEntrada: $scope.dataEntrada}
		}).then(
			function success(response){
				alert("Quarto reservado com sucesso!")
				$scope.getQuartosDisponiveis();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
    
	$scope.setReservaProduto = function(reserva){
		$http({
			method: "POST",
			url: "http://localhost:9090/reserva/quarto/"+reserva.id+"/produto/"+$scope.produto.id,
			data: {quantidade: $scope.quantidadeP, data_hora: $scope.datahora}
		}).then(
			function success(response){
				alert("Produto adicionado com sucesso!");
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.desocupar = function(reserva){
		
		 $scope.calcValorDiarias = parseFloat($scope.qtdDiarias) * parseFloat(reserva.quarto.diaria);

		 $scope.calcValorProdutos = 0;
	
		 
		for(produto of $scope.listProdutosReserva){
			$scope.calcValorProdutos += produto.produto.valor * produto.quantidade;
		}
		
		$scope.calcValorFinal = $scope.calcValorDiarias + $scope.calcValorProdutos;
		
		$scope.desocuparQuarto = function(){
			$http({
		
			method: "PUT",
			url: "http://localhost:9090/quarto",
			data: {id: reserva.quarto.id, numero: reserva.quarto.numero, capacidade: reserva.quarto.capacidade, diaria: reserva.quarto.diaria, disponivel: 0}
		}).then(
			function success(response){
//				$scope.setHome();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
		}
		
		
		$http({
			method: "PUT",
			url: "http://localhost:9090/reserva/quarto/"+reserva.quarto.id+"/pessoa/"+reserva.pessoa.cpf,
			data: {id: reserva.id, dataEntrada: reserva.dataEntrada, dataSaida: $scope.dataSaida, valorFinal: $scope.calcValorFinal, statusPagameno: 1}
		}).then(
			function success(response){
				alert("Quarto desocupado com sucesso!");
				console.log($scope.calcValorFinal);
				alert("Valor final: " + $scope.calcValorFinal);
				$scope.desocuparQuarto();
				$scope.getQuartosDisponiveis();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
			
		
			
			
	}
	
}]);

// APP CLIENTE

var appCliente = angular.module("cliente-web", []);

appCliente.controller("cliente-controller", [ "$http", "$scope", function($http, $scope){
	
	$scope.getEstados = function(){
		
		$http({
			method: "GET",
			url: "https://servicodados.ibge.gov.br/api/v1/localidades/estados"
		}).then(
			function success(response){
				$scope.listEstados = response.data;
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.getEstados();
	
	$scope.getCidades= function(estado){
		
		$http({
			method: "GET",
			url: "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+estado+"/municipios"
		}).then(
			function success(response){
				$scope.listCidades = response.data;
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.setPessoa = function(id){
		$http({
			method: "POST",
			url: "http://localhost:9090/pessoa/"+id,
			data: {cpf: $scope.cpf,
				nome: $scope.nome,
				sexo: $scope.sexo,
				nascimento: $scope.nascimento,
				telefone: $scope.telefone}
		}).then(
			function success(response){
				alert("Pessoa cadastrado");
				window.location.href = "http://localhost:9090";
			},
			function unsuccess(response){
				console.log(response);
			})
	}
	
	$scope.setEndereco = function(){
		$http({
			method: "POST",
			url: "http://localhost:9090/endereco/"+$scope.cidade.id,
			data: {logradouro: $scope.logradouro, cep: $scope.cep, numero: $scope.numero}
		}).then(
			function success(response){
				$scope.enderecoDados = response.data;
				console.log("Endereço cadastrado")
				$scope.setPessoa($scope.enderecoDados.id);
			},
			function unsuccess(response){
				console.log(response);
			})
	}
	
	$scope.setCidade = function(){
		$http({
			method: "POST",
			url: "http://localhost:9090/cidade/"+$scope.estado.id,
			data: {id: $scope.cidade.id, nome: $scope.cidade.nome}
		}).then(
			function success(response){
				console.log("Cidade cadastrado")
				$scope.setEndereco();
			},
			function unsuccess(response){
				console.log(response);
			})
	}
	
	$scope.setEstado = function(){
		
		$http({
			method: "POST",
			url: "http://localhost:9090/estado",
			data: {id: $scope.estado.id, nome: $scope.estado.nome}
		}).then(
			function success(response){
				console.log("Estado cadastrado")
				$scope.setCidade();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
	}
	
	$scope.setHome = function (){window.location.href = "http://localhost:9090";}
	
}]);

// APP QUARTO

var appQuarto= angular.module("quarto-web", []);

appQuarto.controller("quarto-controller", [ "$http", "$scope", function($http, $scope){

	$scope.setHome = function (){
		window.location.href = "http://localhost:9090";
	}
	
	$scope.setQuarto = function(){
		
		$http({
			method: "POST",
			url: "http://localhost:9090/quarto",
			data: {numero: $scope.numero, capacidade: $scope.capacidade, diaria: $scope.diaria}
		}).then(
			function success(response){
				alert("Quarto cadastrado");
				$scope.setHome();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
		
		
		
	}
	
	
	
}]);

//APP PRODUTO

var appProduto= angular.module("produto-web", []);

appProduto.controller("produto-controller", [ "$http", "$scope", function($http, $scope){

	$scope.setHome = function (){
		window.location.href = "http://localhost:9090";
	}
	
	$scope.setProduto = function(){
		
		$http({
			method: "POST",
			url: "http://localhost:9090/produto",
			data: {nome: $scope.nome, valor: $scope.valor}
		}).then(
			function success(response){
				alert("Produto cadastrado");
				$scope.setHome();
			},
			function unsuccess(response){
				console.log(response);
			}
		)
		
		
		
	}
	
	
	
}]);
