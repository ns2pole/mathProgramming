function primeFactorization() {
    $('input[name="integer"]').change(function(e) {
        e.preventDefault();
        $.ajax({
          url: "/primeFactorization",
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

primeFactorization();

$(document).ajaxStop(function(d){
  primeFactorization();
  MathJax.Hub.Typeset();
  
});