// 초기 차트 설정
const ctx = document.getElementById('myChart').getContext('2d');
const chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        datasets: [{
            label: '기온 (°C)',
            borderColor: 'blue',
            data: [4.5, 5.2, 8.7, 14.4, 18.9, 22.7, 26.4, 27.8, 24.1, 18.1, 12.2, 7],
            fill: false,
            tension: 0.1
        }, {
            label: '습도 (%)',
            borderColor: 'red',
            data: [64, 61, 59, 60, 56, 54, 47, 44, 55, 64, 67, 65],
            fill: false,
            tension: 0.1
        }]
    },
    options: {
        responsive: true,
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

// 랜덤 데이터 생성 함수
function generateRandomData() {
    for (let i = 1; i <= 12; i++) {
        const randomTemp = (Math.random() * 20 + 5).toFixed(2);  // 기온 랜덤
        const randomHumidity = Math.floor(Math.random() * 40 + 50);  // 습도 랜덤

        // 각 입력 필드에 랜덤 값 할당
        document.getElementById(`temp${i}`).value = randomTemp;
        document.getElementById(`humidity${i}`).value = randomHumidity;
    }

    // 차트 데이터 업데이트
    updateChartData();
}

// 입력 필드가 변경될 때마다 차트를 업데이트하는 함수
function updateChartData() {
    const tempData = [];
    const humidityData = [];

    // 1월부터 12월까지 기온과 습도 값을 배열에 저장
    for (let i = 1; i <= 12; i++) {
        tempData.push(parseFloat(document.getElementById(`temp${i}`).value));
        humidityData.push(parseInt(document.getElementById(`humidity${i}`).value));
    }

    // 차트 데이터 업데이트
    chart.data.datasets[0].data = tempData;
    chart.data.datasets[1].data = humidityData;

    // 차트 업데이트
    chart.update();
}

// 모든 input 필드에 이벤트 리스너 추가 (수동으로 값 변경 시 차트 업데이트)
for (let i = 1; i <= 12; i++) {
    document.getElementById(`temp${i}`).addEventListener('input', updateChartData);
    document.getElementById(`humidity${i}`).addEventListener('input', updateChartData);
}
