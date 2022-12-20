// const sWrap = document.getElementById('SliderWrap_hj');
// const sList = document.querySelector('.Slider_hj');
// const lis = sList.querySelectorAll('li');
// const btn = document.querySelectorAll('#btnWrap_hj button');
// const lisCopy1 = lis[0].cloneNode(true);
// const lisCopy2 = lis[lis.length-1].cloneNode(true);
// let lisNum = lis.length + 2;
// console.log(lisNum);
// let sNum = 10;
// let state = 1;
// sList.append(lisCopy1);
// sList.prepend(lisCopy2);
// // let pos = sList.clientWidth;
// sList.style.width = `${lisNum*25}%`;
// sList.style.transform = `translateX(-${10}%)`;

// let nextSlider = ()=> {
//     sNum += 10;
//     sList.style.transition = '1s';
//     sList.style.transform = `translateX(-${sNum}%)`;
    
//     setTimeout(()=>{
//       if ( sNum == 50 ) {
//         sList.style.transition = '0s';
//         sList.style.transform = `translateX(-${10}%)`;
//         sNum = 10;
//       }
//       else {
//         state = 1;
//       }
//     }, 1000)
// }
// let prevSlider = ()=> {
//     sNum -= 10;
//     sList.style.transition = '1s';
//     sList.style.transform = `translateX(-${sNum}%)`;
//     setTimeout(()=>{
//       if ( sNum == 0 && state == 0 ) {
//         sList.style.transition = '0s';
//         sList.style.transform = `translateX(-${60}%)`;
//         sNum = 60;
//       }
//       state = 1;
//     }, 1000)
// }

// let timer = setInterval(nextSlider, 3000);

// btn[1].addEventListener('click', ()=> {
//   clearInterval(timer);
//   if ( state == 1) {
//     state = 0;
//     nextSlider();
//   }
// })
// btn[0].addEventListener('click', ()=> {
//   clearInterval(timer)
//   if ( state == 1 ) {
//     state = 0;
//     prevSlider();
//   }
// })

const sWrap = document.getElementById('SliderWrap_hj');
const sList = document.querySelector('.Slider_hj');
const list = sList.querySelectorAll('li');
const btn = document.querySelectorAll('#btnWrap_hj button');

let sNum = 12.5;
let state = 1;
sList.prepend(list[7]);
sList.style.transform = `translateX(-${sNum}%)`
let nextSlider = ()=> {
    sList.style.transition = '1s';
    sNum += 12.5;
    sList.style.transform = `translateX(-${sNum}%)`;
    setTimeout(()=>{
      if ( sNum == 50 ) {
        sList.style.transition = '0s';
        const newSliderList = sList.querySelectorAll('.Slider_hj li');
        sList.append(newSliderList[0]);
        sNum = 37.5;
        sList.style.transform = `translateX(-${sNum}%)`;
      }
      state = 1;
    }, 1000);
}
let prevSlider = ()=> {
  sList.style.transition = '1s';
    sNum -= 12.5;
    sList.style.transform = `translateX(-${sNum}%)`;
    setTimeout(()=>{
      if ( sNum == 0 ) {
        sList.style.transition = '0s';
        const newSliderList = sList.querySelectorAll('.Slider_hj li');
        sList.prepend(newSliderList[7]);
        sNum = 12.5;
        sList.style.transform = `translateX(-${sNum}%)`;
      }
      state = 1;
    }, 1000)
}

let timer = setInterval(nextSlider, 2500);

btn[1].addEventListener('click', ()=> {
  clearInterval(timer);
    if ( state == 1) {
      state = 0;
      nextSlider();
      timer = setInterval(nextSlider, 2500);
    }
})
btn[0].addEventListener('click', ()=> {
  clearInterval(timer);
    if ( state == 1 ) {
      state = 0;
      prevSlider();
      timer = setInterval(nextSlider, 2500);  
    }
})




