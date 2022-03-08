async function NewUser(form) {
    let newuser = {
        "username" : newuserform.formusername.value,
        "login": newuserform.formlogin.value,
        "password": newuserform.formpassword.value
    };

    fetch('clients/main', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newuser)
    });
}