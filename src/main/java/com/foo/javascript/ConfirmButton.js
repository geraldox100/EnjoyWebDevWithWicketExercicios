if(typeof(myapp)=="undefined")
	myapp = {};

myapp.confirm = {
	getConfirmation : function(){ 
		return confirm('Are you sure?');
	}
}