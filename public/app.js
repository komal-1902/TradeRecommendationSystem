var app = angular.module('mainApp', ['ngRoute']);
app.value('userdata', { username:null});

app.config(function($routeProvider){
  $routeProvider
  .when('/', {
    templateUrl: 'login.html',
    controller: 'loginController'
  })
  .when('/dashboard', {
    templateUrl: 'dashboard.html',
    controller: 'dashboardController'
  })
  .when('/profile', {
    templateUrl: 'profile.html',
    controller: 'profileController'
  })
  .when('/topgainers', {
    templateUrl: 'topgainers.html',
    controller: 'gainerController'
  })
  .when('/toplosers', {
    templateUrl: 'toplosers.html',
    controller: 'loserController'
  })
  .when('/watchlist', {
    templateUrl: 'watchlist.html',
    controller: 'watchlistController'
  })
  .when('/trade', {
    templateUrl: 'trade.html',
    controller: 'tradeController'
  })
  .otherwise({
    redirectTo: '/'
  });
});

app.controller('loginController', function($scope, $http, $location, userdata){
userdata.username = null;
  $scope.message = "Hello, this is Login Controller";
  console.log("Login controller invoked");
  $scope.username = null;
  $scope.password = null;
  $scope.error = null;
  
  $scope.login = function(username, password){
	  var data = {
		username: username, 
		password: password
	  };
  
  $http.post("/server/login", data).then(
	  function(response){
		  if(response.data){
			  userdata.username = data.username;
			  console.log("Show dashboard");
			  $location.path('/dashboard');
		  }
			  else{
				  console.log("Invalid");
				  $scope.error = "Invalid password!";
			  }  
	  },
	  function(response){
		  console.log("Major error");
		  $scope.error = "Cannot login, problem with server";
		  $scope.statusval = response.status;
		  $scope.statustext = response.statusText;
		  $scope.headers = response.headers();
	  });
  };
});

app.controller('dashboardController', function($scope, $http, userdata){
	console.log(userdata);
  $scope.message = "Hello, this is Dashboard Controller";
  $scope.title = "Nifty-50 Securities";
  console.log("Calling nifty server log");
  $http.get("/server/nifty-50")
  .then(function(resp3){
	  $scope.dataModel = resp3.data;
  });
  
	$scope.symbol = null;
	$scope.username = null;
		
		$scope.Add = function(symbol){
			var data = {
				username: userdata.username,
				symbol: symbol
			};
			  
			  $http.post("/server/watchlist", data).then(
				  function(response){
					  if(response.data){
						  alert("Stocks added to your watchlist!");
					  }
						  else{
							  console.log("Invalid");
							  $scope.error = "Cannot add";
						  }  
				  },
				  function(response){
					  console.log("Major error");
					  $scope.error = "Cannot add, problem with server";
					  $scope.statusval = response.status;
					  $scope.statustext = response.statusText;
					  $scope.headers = response.headers();
				  });
			  };
  
});

app.controller('profileController', function($scope, $http, userdata){
  $scope.message = "Hello, this is Profile Controller";
	var url = "/server/showBought" + "/" + userdata.username;
	$http.get(url)
	.then(function(resp7){
		$scope.dataModel = resp7.data;
	});
});

app.controller('gainerController', function($scope, $http){
  $scope.message = "Hello, this is Charts Controller";
  console.log("Calling gainer server log");
  $http.get("/server/topgainers")
	  .then(function(resp1){
		  $scope.dataModel = resp1.data;
	  });
});

app.controller('loserController', function($scope, $http){
	  $scope.message = "Hello, this is Charts Controller";
	  console.log("Calling loser server log");
	  $http.get("/server/toplosers")
		  .then(function(resp2){
			  $scope.dataModel = resp2.data;
		  });
	});

app.controller('watchlistController', function($scope, $http, userdata){
  $scope.message = "Hello, this is Watchlist Controller";
	var url = "/server/showWatchlist" + "/" + userdata.username;
	$http.get(url)
	.then(function(resp6){
		$scope.dataModel = resp6.data;
	});
});

app.controller('tradeController', function($scope, $http, userdata){
	console.log("Calling trade server log");
	$scope.sectorSelect = null;
	
	$scope.show = function(sectorSelect){
		console.log(sectorSelect)
		var data = {
			sectorSelect: sectorSelect
		};
		
		
		var url = "/server/trade" + "/" + $scope.sectorSelect;
		
		$http.get(url)
		.then(function(resp5){
			$scope.dataModel = resp5.data;
		});
		
	};
	
	$scope.symbol = null;
	$scope.username = null;
		
		$scope.Add = function(symbol){
			var data = {
				username: userdata.username,
				symbol: symbol
			};
			  
			  $http.post("/server/buy", data).then(
				  function(response){
					  if(response.data){
						  alert("Stocks bought!");
					  }
						  else{
							  console.log("Invalid");
							  $scope.error = "Cannot add!";
						  }  
				  },
				  function(response){
					  console.log("Major error");
					  $scope.error = "Cannot add, problem with server";
					  $scope.statusval = response.status;
					  $scope.statustext = response.statusText;
					  $scope.headers = response.headers();
				  });
			  };
});
