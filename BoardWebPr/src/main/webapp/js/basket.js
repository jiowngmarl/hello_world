/**
 * 
 */

let basket = {
  changePNum: function(index, direction, price) {
    let input = document.getElementById('p_num' + index);
    let sum = document.getElementById('sum' + index);
    let currentValue = parseInt(input.value);

    let target = event.target;

    if (target.classList.contains('up')) {
      currentValue++;
    } else if (target.classList.contains('down')) {
      if (currentValue > 1) {
        currentValue--;
      }
    }

    input.value = currentValue;

    // 개별 상품 금액 변경
    let totalPrice = currentValue * price;
    sum.innerHTML = totalPrice;

    // 총 금액 / 총 개수 업데이트
    basket.updateTotalCount();
	basket.updateTotalPrice();
  },

  updateTotalCount: function() {
    let totalCount = 0;
    let inputs = document.querySelectorAll('.p_num');

    inputs.forEach(input => {
      totalCount += parseInt(input.value);
    });

    document.getElementById('totalCount').innerText = totalCount;
  },
  
  updateTotalPrice: function() {
      let totalPrice = 0;
      let sums = document.querySelectorAll('.sum span');

      sums.forEach(sum => {
        totalPrice += parseInt(sum.innerText);
      });

      document.getElementById('totalPrice').innerText = totalPrice;
    }
}
