 var lastDate = 0;
        var data = [];
        var data_1 = [];

        var TICKINTERVAL = 86400000

         var socket = new SockJS('/websocket-example');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/user', function (greeting) {

                    var y_1 = JSON.parse(greeting.body).valuee_hum;
                    var y_2 = JSON.parse(greeting.body).valuee_temp;

                    console.log("valuee_hum: ",JSON.parse(greeting.body).valuee_hum)
                    console.log("valuee_temp: ",JSON.parse(greeting.body).valuee_temp)

                    console.log("y_1: ", y_1);
                    console.log("y_2: ", y_2);

                    var xx = JSON.parse(greeting.body).date
                   // console.log("Date: ",JSON.parse(greeting.body).date)
                    console.log("x: ", xx);

                    data.push({x: xx, y: y_1});
                    data_1.push({x: xx, y: y_2});

                    console.log("DATA",data);
                    chart.updateSeries([
                            {
                                data: data
                            },
                            {
                                data: data_1
                            }
                    ])
                   // showGreeting(JSON.parse(greeting.body).valuee_hum);
                   // showGreeting(JSON.parse(greeting.body).valuee_temp);
                });
            });

        var options = {
            chart: {
                height: 350,
                type: 'line',
                animations: {
                    enabled: true,
                    easing: 'linear',
                    dynamicAnimation: {
                        speed: 1000
                    }
                },
                toolbar: {
                    show: true
                },
                zoom: {
                    enabled: true
                }
            },
          //  colors: ['#77B6EA', '#545454'],
            dataLabels: {
                enabled: true
            },
            stroke: {
                curve: 'smooth'
            },
            series: [{
                name: "Humidity",
                data: data
            },
            {
               name: "Temperature",
                    data: data_1
            }
            ],
            title: {
                text: 'Dynamic Chart for Temperature and Humidity',
                align: 'center'
            },
            markers: {
                size: 0
            },
            xaxis: {
               type: 'datetime',
                title: {
                    text: "Time"
                       },
            },
            yaxis: {
                title: {
                    text: 'Temperature & Humidity'
                }
            },
            legend: {
               show: true
            },
        }

        var chart = new ApexCharts(
            document.querySelector("#chart"),
            options
        );

        chart.render();


