function primeFactorization() {
    $('input[name="integer"]').change(function(e) {
        e.preventDefault();
        $.ajax({
          url: "/test/primeFactorization",
          type: "GET",
          data: {
            integer: $(this).val(),
            _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
          }
        })
        .done(function(html) {
          var html = html.substr( 719, 392 );
          alert(html);
          $('html').children('body').html(html); // 抽出したもので現在のページのbodyタグの中身を置き換える
        })
        .fail(function() {
          alert("error");
        })
    });
};
primeFactorization();

$(document).ajaxStop(function(d){
  primeFactorization();
  MathJax.Hub.Typeset();
  
});