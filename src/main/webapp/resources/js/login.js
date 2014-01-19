	function handleLoginRequest(xhr, status, args) {
		alert("Hello World!");
		if (args.validationFailed || !args.loggedIn) {
			PF('dlg').jq.effect("shake", {
				times : 5
				}, 100);
		} else {
			PF('dlg').hide();
			$('#loginLink').fadeOut();
		}
	}
