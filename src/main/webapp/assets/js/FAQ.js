$('.sub_hj').hide();
$(".question_hj").on('click', function(){
  $('.sub_hj').not($(this).next()).slideUp(200);
  $(this).next().slideToggle(500);
})