/* section 1 start*/
//page1 slides
let sec1_pos;
let sec1_sLength = $('.page1_slides > li').length;
let sec1_state = 1; //움직임제어조건변수
let sec1_num;
let sec1_classNum = 0;
let sec1_nextSlider = ()=> {
  sec1_state = 0;
  sec1_classNum++;
  if(sec1_classNum == 3) {
    sec1_classNum = 0;
  }
  $('.page1_slides > li:eq(1)')
          .addClass('active')
          .css({opacity: 0})
          .animate({opacity:1}, function(){
            $('.page1_slides').append($('.page1_slides > li:eq(0)'));
            $('.page1_slides > li:last').removeClass('active');
            sec1_state=1;
          });
}
let sec1_prevSlider = ()=> {
  sec1_state =0;
  sec1_classNum--;
  if(sec1_classNum == -1) {
    sec1_classNum = 5;
  }
  $('.page1_slides > li:last')
          .addClass('active')
          .css({opacity: 0})
          .animate({opacity:1}, function(){
            $('.page1_slides').prepend($(this));
            $('.page1_slides > li:eq(1)').removeClass('active');
            sec1_state=1;
          });
}
let sec1_timer = setInterval(sec1_nextSlider,3000);
//버튼공통
$('#mainsliderBtn button').on('click', function(e){
  e.preventDefault();
  clearInterval(sec1_timer);
  sec1_timer = setInterval(sec1_nextSlider,3000);
});
$('#mainslide_btnNext').on('click',function(){
  if(sec1_state==1){
    sec1_nextSlider();
  }

});
$('#mainslide_btnPrev').on('click',function(){
  if(sec1_state==1){
    sec1_prevSlider();
  }
});
/* section 1 end */
