function request() {
  EulerPhiFunctionRequest();
  primeNumsUnderSetValRequest();
  isPrimeRequest();
  primeFactorsRequest();
};

function EulerPhiFunctionRequest() {
  $('input[id="EulerPhiFunction"]').change(function() {
    $.ajax(getArrToSendIntegerByAjax(this, "/EulerPhiFunction"))
    .done(function(str) {
      document.getElementById('EulerPhiFunctionCalculateResult').textContent = "$\\phi(" + document.getElementById("EulerPhiFunction").value + ")=" + str + "$";
    })
    .fail(function() {
      alert("error");
    })
  });
}

function primeNumsUnderSetValRequest() {
  $('input[id="primeNumsUnderSetVal"]').change(function() {
    $.ajax(getArrToSendIntegerByAjax(this, "/primeNumsUnderSetVal"))
    .done(function(str) {
      document.getElementById('primeNumsUnderSetValResult').textContent = document.getElementById("primeNumsUnderSetVal").value + "以下の素数の集合 = $" + getChangedStrFromArrayListStrToMathJaxStr(str) + "$";
    })
    .fail(function() {
      alert("error");
    })
  });
}

function isPrimeRequest() {
  $('input[id="isPrime"]').change(function() {
    $.ajax(getArrToSendIntegerByAjax(this, "/isPrime"))
    .done(function(str) {
      document.getElementById('isPrimeResult').textContent = document.getElementById("isPrime").value + "は素数か？" + str;
      if(str == "false") {
        inputForm = document.getElementById('isPrime');
        $.ajax(getArrToSendIntegerByAjax(inputForm, "/primeFactors"))
        .done(function(str) {
          document.getElementById('isPrimeResult').textContent += str;
        })
        .fail(function() {
          alert("error");
        })
      }
    })
    .fail(function() {
      alert("error");
    })
  });
}

function primeFactorsRequest() {
  $('input[id="primeFactors"]').change(function() {
    $.ajax(getArrToSendIntegerByAjax(this, "/primeFactors"))
    .done(function(str) {
      document.getElementById('primeFactorsResult').textContent = str;
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

function getArrToSendIntegerByAjax(inputForm, url) {
  return {
    url: url,
    type: "GET",
    data: {
      integer: $(inputForm).val(),
      _csrf: $("*[name=_csrf]").val()
    }
  }
}
//⬆︎⬆︎⬆︎ここまでは定義

//ここからが動く所。
request();

$(document).ajaxStop(function() {
  request();
  MathJax.Hub.Typeset();
});


