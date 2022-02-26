$(function() {
    $('input[name="integer"]').change(function(e) {
        e.preventDefault();
        alert($(this).val());

        $.ajax({
          url: "/test/primeFactorization",
          type: "POST",
          data: {
            integer: $(this).val(),
            _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
          }
        })
        .done(function(data) {
          alert("success");
        })
        .fail(function() {
          alert("error");
        })
    });
});