var app = angular.module("hotel-web", []);

app.controller("hotel-controller", [ "$http", "$scope", function($http, $scope){
	
	$scope.listQuartos = [];
	
	$scope.getQuartosDisponiveis = function(){
		
		$http({
			method: "GET",
			url: "http://localhost:9090/quarto"
		}).then(
			function success(response){
				$scope.listQuartos = [];
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
			url: "http://localhost:9090/quarto"
		}).then(
			function success(response){
				$scope.listQuartos = [];
				dados = response.data;
				for(dado of dados){
					if(dado.disponivel == 1){
						$scope.listQuartos.push(dado);
					}
				}
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
