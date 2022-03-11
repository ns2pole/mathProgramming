function request() {
    $('input[name="EulerPhiFunction"]').change(function(e) {
        e.preventDefault();
        $.ajax({
          url: "/EulerPhiFunction",
          type: "GET",
          data: {
            integer: $(this).val(),
            _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
          }
        })
        .done(function(str) {
          alert(str);
          document.getElementById('stringOfEulerPhiFunctionCalculate').textContent = str;
        })
        .fail(function() {
          alert("error");
        })
    });

    $('input[name="PrimeNumsUnderSetVal"]').change(function(e) {
      e.preventDefault();
      $.ajax({
        url: "/PrimeNumsUnderSetVal",
        type: "GET",
        data: {
          integer: $(this).val(),
          _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
        }
      })
      .done(function(str) {
        alert(str);
        document.getElementById('stringOfPrimeNumsUnderSetVal').textContent = str;
      })
      .fail(function() {
        alert("error");
      })

  });

};

request();

$(document).ajaxStop(function(d){
  request();
  MathJax.Hub.Typeset();
});