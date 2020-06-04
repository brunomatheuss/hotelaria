var app = angular.module("produto-web", []);

app.controller("produto-controller", [ "$http", "$scope", function($http, $scope){
	
	
	$scope.listProduto = []
	
	$scope.listar = function ()
	{
    	$http({
    		method: "GET", 
    		url : "http://localhost:8080/produto"
    	}).then(
    		function success(response)
    		{
    			$scope.listProduto = response.data;
    		}, 
    		function unsuccess(response)
    		{
    			console.log(response);
    		}
    	);
	}
	
	$scope.listar();

    $scope.cadastrar = function ()
	{
		$http({

			method: "POST" , 
			url: "http://localhost:8080/produto",
            data: {nome: $scope.nome, valor: $scope.valor}
            
		}).then(

			function success(response){
				console.log('Cadastrado com sucesso!');
				$scope.listar();
				$scope.nome = "";
				$scope.valor = "";
			}, 
			function unsuccess(response){
				console.log(response);
            }	
            
		);
    }
    
    $scope.deletar = function (idProduto)
	{
		$http({

			method: "DELETE" , 
			url: "http://localhost:8080/produto/"+idProduto
            
		}).then(

			function success(response){
				console.log('Deletado com Sucesso!');
				$scope.listar();
			}, 
			function unsuccess(response){
				console.log(response);
            }	
            
		);
    }
    
    $scope.produtoEdit = function (idProduto)
	{
		$http({

			method: "GET" , 
			url: "http://localhost:8080/produto/"+idProduto
            
		}).then(

			function success(response){
				dados = response.data;
				$scope.idEditar = dados.id;
				$scope.nomeEditar = dados.nome;
				$scope.valorEditar = dados.valor;
			}, 
			function unsuccess(response){
				console.log(response);
            }	
            
		);
    }
    
    $scope.editar = function (idProduto)
	{
		$http({

			method: "PUT" , 
			url: "http://localhost:8080/produto",
			data: {id: idProduto, nome: $scope.nomeEditar, valor: $scope.valorEditar}
            
		}).then(

			function success(response){
				console.log('Editado com Sucesso!');
				$scope.listar();
			}, 
			function unsuccess(response){
				console.log(response);
            }	
            
		);
    }
    
    
    
    
}]);