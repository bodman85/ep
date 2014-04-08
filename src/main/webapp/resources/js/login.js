function handleLoginRequest(xhr, status, args) {
	if (args.validationFailed || !args.loggedIn) {
		//PF('loginDlg').jq.effect("shake", { times:5 }, 100);  
	} else {
		PF('loginDlg').hide();
		$('#loginLink').fadeOut();
		$('#registrationLink').fadeOut();
	}
}
