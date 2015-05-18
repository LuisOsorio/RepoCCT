$(document).ready(function() {
        $('a#objective').click(function(event) {
        	console.log("inside load tasks")
        	var actionSource ='objetive';
        	 $.post('ActivitiesView', {action:actionSource
             }, function(responseText) {
                 $('#content').html(responseText);
             });
        });
        $('a#strategy').click(function(event) {
        	var actionSource ='strategy';
            $.post('ActivitiesView', {action:actionSource
            }, function(responseText) {
                $('#content').html(responseText);
            });
        });
        $('a#activity').click(function(event) {
        	var actionSource ='activity';
            $.post('ActivitiesView', {action:actionSource
            }, function(responseText) {
                $('#content').html(responseText);
            });
        });
        $('a#task').click(function(event) {
        	var actionSource ='task';
            $.post('ActivitiesView', {action:actionSource
            }, function(responseText) {
                $('#content').html(responseText);
            });
        });
    });