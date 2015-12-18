/**
 * Created by maciek on 15.11.15.
 */
"use strict";
var sicxe = angular.module("sicxe-sim");

sicxe.service('UserService', function ($http) {

    var handler = this;
    handler.user = {
        logged : false
    };
    handler.logUser = function(user){
        $http.post('/user/log', user).then(function success(response) {
            console.log(response)
        }, function error(response) {
            console.log(response)
        });
    };
    handler.getUser = function(){
        return handler.user;
    };

    handler.users = [
        {
            id: 1,
            username: 'mwal',
            admin: true,
            email: 'mwalerczuk@gmail.com',
            tutorials: [
                {
                    title:'lorem ipsum',
                    id:1
                }
            ]

        },{
            id: 2,
            username: 'user',
            admin: false,
            email: 'user@example.com',
            tutorials: [
                {
                    name:'haha',
                    id:2
                }
            ]

        }
    ];
    handler.getUsers = function(){
        return handler.users;
    };
    handler.remove = function(selectedUsers){
        for(var i = 0; i < handler.users.length; i++){
            for(var j = 0; j < selectedUsers.length; j++){
                if(handler.users[i].id == selectedUsers[j].id){
                    handler.users.splice(i, 1);
                }

            }
        }
    };

    handler.newUser = function (user) {
        $http.post('/user/new', user).then(function success(response) {
            console.log(response)
        }, function error(response) {
            console.log(response)
        });
    }

});
