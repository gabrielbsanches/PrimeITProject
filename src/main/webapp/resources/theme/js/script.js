function checkPassword(str)
  {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
    return re.test(str);
  }

  function checkForm(form)
  {
    if(form.loginname.value == "") {
      alert("Login name cannot be blank!");
      form.loginname.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.loginname.value)) {
      alert("Login name must contain only letters, numbers and underscores!");
      form.loginame.focus();
      return false;
    }
    if(form.password.value != "" && form.password.value == form.password2.value) {
      if(!checkPassword(form.password.value)) {
        alert("Please enter a passsword with: at least one number, one lowercase and one uppercase letter at least six characters that are letters, numbers or the underscore");
        form.password.focus();
        return false;
      }
    } else {
      alert("Please check that you've entered and confirmed your password!");
      form.password.focus();
      return false;
    }
    return true;
  }
