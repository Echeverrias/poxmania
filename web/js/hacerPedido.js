$(document).ready(
        function() {
            var btns = ['btn-one', 'btn-two'];
            var input = document.getElementById('btn-input');
            for (var i = 0; i < btns.length; i++) {
                
                document.getElementById(btns[i]).addEventListener('click', function() {
                    $('.radios').removeClass('btn-primary').addClass('btn-default');
                    $(this).removeClass('btn-default').addClass('btn-primary');
                    input.value = this.value;
                });
            }
        });
