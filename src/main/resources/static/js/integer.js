function EulerPhiFunction() {
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
        .done(function(html) {
          var bodyOfHtml = html.substr(getLengthFromStartToHeadEnd(html), getLengthOfHtmlBody(html));
          $('html').children('body').html(bodyOfHtml); // 抽出したもので現在のページのbodyタグの中身を置き換える
          document.getElementById('stringOfPrimeNumsUnderSetVal').textContent = '$\{1,3,4,5\}$';
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
      .done(function(html) {
        var bodyOfHtml = html.substr(getLengthFromStartToHeadEnd(html), getLengthOfHtmlBody(html));
          alert(bodyOfHtml);
        $('html').children('body').html(bodyOfHtml); // 抽出したもので現在のページのbodyタグの中身を置き換える
      })
      .fail(function() {
        alert("error");
      })

  });

};

//indexOfは一致した文字列の最初の場所を返すので、"<"の位置を返してしまう。残りの/head>の調整分が"8"
function getLengthFromStartToHeadEnd(html) {
  var end = html.indexOf('</head>');
  return end + 8;
}

//indexOfは一致した文字列の最初の場所を返すので、"<"の位置を返してしまう。body>や/body>の文字列の調整分が"12"
function getLengthOfHtmlBody(html) {
  var start = html.indexOf('<body>');
  var end = html.indexOf('</body>');
  var lengthOfHtmlBody = end - start + 12;
  return lengthOfHtmlBody;
}

EulerPhiFunction();

$(document).ajaxStop(function(d){
  EulerPhiFunction();
  MathJax.Hub.Typeset();
});