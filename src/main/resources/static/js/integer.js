function request() {
  $('input[name="EulerPhiFunction"]').change(function() {
      $.ajax({
        url: "/EulerPhiFunction",
        type: "GET",
        data: {
          integer: $(this).val(),
          _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
        }
      })
      .done(function(str) {
        document.getElementById('stringOfEulerPhiFunctionCalculate').textContent = "$\\phi(" + document.getElementById("EulerPhiFunction").value + ")=" + str + "$";
      })
      .fail(function() {
        alert("error");
      })
  });

  $('input[name="PrimeNumsUnderSetVal"]').change(function(e) {
    $.ajax({
      url: "/PrimeNumsUnderSetVal",
      type: "GET",
      data: {
        integer: $(this).val(),
        _csrf: $("*[name=_csrf]").val()
      }
    })
    .done(function(str) {
      document.getElementById('stringOfPrimeNumsUnderSetVal').textContent = document.getElementById("PrimeNumsUnderSetVal").value + "以下の素数の集合 = $" + getChangedStrFromArrayListStrToMathJaxStr(str) + "$";
    })
    .fail(function() {
      alert("error");
    })
  });

  $('input[name="isPrime"]').change(function() {
    $.ajax({
      url: "/isPrime",
      type: "GET",
      data: {
        integer: $(this).val(),
        _csrf: $("*[name=_csrf]").val()
      }
    })
    .done(function(str) {
      document.getElementById('stringOfIsPrime').textContent = document.getElementById("isPrime").value + "は素数か？" + str;
    })
    .fail(function() {
      alert("error");
    })
  });
};

request();

$(document).ajaxStop(function() {
  request();
  MathJax.Hub.Typeset();
});

function getChangedStrFromArrayListStrToMathJaxStr(integerArrayListstr) {
  str = integerArrayListstr.substr(1);
  str = str.substring(0, str.length - 1);
  return "\\{" + str + "\\}";
}