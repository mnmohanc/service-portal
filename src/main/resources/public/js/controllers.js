angular.module('app.controllers', []).controller('ServiceDetailsListController', function($scope, $state, popupService, $window, ServiceDetails) {
  $scope.ServiceDetails = ServiceDetails.query(); //fetch all ServiceDetailss. Issues a GET to /api/vi/ServiceDetailss
  
  

  $scope.deleteServiceDetails = function(ServiceDetails) { // Delete a ServiceDetails. Issues a DELETE to /api/v1/ServiceDetailss/:id
    if (popupService.showPopup('Really delete this?')) {
      ServiceDetails.$delete(function() {
        $scope.ServiceDetailss = ServiceDetails.query();
        $state.go('ServiceDetails');
      });
    }
  };
}).controller('ServiceDetailsViewController', function($scope, $stateParams, ServiceDetails) {
  $scope.ServiceDetails = ServiceDetails.get({ id: $stateParams.id }); //Get a single ServiceDetails.Issues a GET to /api/v1/ServiceDetails/:id
}).controller('ServiceDetailsCreateController', function($scope, $state, $stateParams, ServiceDetails) {
  $scope.ServiceDetails = new ServiceDetails();  //create new ServiceDetails instance. Properties will be set via ng-model on UI

  $scope.addServiceDetails = function() { //create a new ServiceDetails. Issues a POST to /api/v1/ServiceDetailss
    $scope.ServiceDetails.$save(function() {
      $state.go('ServiceDetails'); // on success go back to the list i.e. ServiceDetails state.
    });
  };
}).controller('ServiceDetailsEditController', function($scope, $state, $stateParams, ServiceDetails) {
  $scope.updateServiceDetails = function() { //Update the edited ServiceDetails. Issues a PUT to /api/v1/ServiceDetails/:id
    $scope.ServiceDetails.$update(function() {
      $state.go('ServiceDetails'); // on success go back to the list i.e. ServiceDetails state.
    });
  };

  $scope.loadServiceDetails = function() { //Issues a GET request to /api/v1/ServiceDetails/:id to get a ServiceDetails to update
    $scope.ServiceDetails = ServiceDetails.get({ id: $stateParams.id });
  };

  $scope.loadServiceDetails(); // Load a ServiceDetails which can be edited on UI
});
