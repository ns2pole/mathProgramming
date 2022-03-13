function request() {
  EulerPhiFunctionRequest();
  primeNumsUnderSetValRequest();
  isPrimeRequest();
};

function EulerPhiFunctionRequest() {
  $('input[id="EulerPhiFunction"]').change(function() {
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
}

function primeNumsUnderSetValRequest() {
  $('input[id="PrimeNumsUnderSetVal"]').change(function() {
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
}

function isPrimeRequest() {
  $('input[id="isPrime"]').change(function() {
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
}

function getChangedStrFromArrayListStrToMathJaxStr(integerArrayListstr) {
  str = integerArrayListstr.substr(1);
  str = str.substring(0, str.length - 1);
  return "\\{" + str + "\\}";
}


//⬆︎⬆︎⬆︎ここまでは定義

//ここからが動く所。
request();

$(document).ajaxStop(function() {
  request();
  MathJax.Hub.Typeset();
});


