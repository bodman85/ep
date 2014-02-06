	function handleLoginRequest(xhr, status, args) {
		if (args.validationFailed || !args.loggedIn) {
			PF('dlg').jq.effect("shake", {
				times : 5
				}, 100);
		} else {
			PF('dlg').hide();
			toggle("loginPanelId");
			toggle("logoutPanelId");
			$('#loginLink').fadeOut();
		}
	}

    function toggle(id) {
    	//alert("toggle run");
        var element = document.getElementById(id);
        if(element.style.display != 'none') {
          element.style.display = 'none';
        } else {
          element.style.display = 'block';
        }
    }